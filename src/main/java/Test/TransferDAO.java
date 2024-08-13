   package Test;

import com.dao.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Savepoint;

public class TransferDAO {
   public String msg = "";

   public String transfer(long acno, String user, String password, long targetAc, double amt) {
      try {
         Connection con = DBConnection.getConnection();
         PreparedStatement hac = con.prepareStatement("select *from apnabankreg where accno=? and username=? and password=?");
         PreparedStatement bac = con.prepareStatement("select *from apnabankreg where accno=?");
         PreparedStatement transferMoney = con.prepareStatement("update apnabankreg set AMOUNT=AMOUNT+? where accno=?");
         con.setAutoCommit(false);
         Savepoint sv = con.setSavepoint();
         hac.setLong(1, acno);
         hac.setString(2, user);
         hac.setString(3, password);
         ResultSet rs1 = hac.executeQuery();
         if (rs1.next()) {
            double bal = rs1.getDouble(4);
            if (bal > amt) {
               transferMoney.setDouble(1, -amt);
               transferMoney.setLong(2, acno);
               int p = transferMoney.executeUpdate();
               bac.setLong(1, targetAc);
               ResultSet rs2 = bac.executeQuery();
               if (rs2.next()) {
                  transferMoney.setDouble(1, amt);
                  transferMoney.setLong(2, targetAc);
                  int q = transferMoney.executeUpdate();
                  if (p == 1 && q == 1) {
                     this.msg = "Transfer Succuss";
                     con.commit();
                  } else {
                     this.msg = "Tranfer failed";
                     con.rollback(sv);
                  }
               } else {
                  this.msg = "Transfer account is invalid";
               }
            } else {
               this.msg = "Your ac has no sufficient balance";
            }
         } else {
            this.msg = "Home ac is invalid";
         }
      } catch (Exception var20) {
         var20.printStackTrace();
      }

      return this.msg;
   }
}