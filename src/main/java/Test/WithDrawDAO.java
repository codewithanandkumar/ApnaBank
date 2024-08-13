   package Test;

import com.dao.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class WithDrawDAO {
   public int k = 0;

   public int withdraw(CreateNewAccountBean cnab) {
      try {
         Connection con = DBConnection.getConnection();
         PreparedStatement checkbal = con.prepareStatement("select *from apnabankreg where accno=?");
         PreparedStatement ps = con.prepareStatement("update apnabankreg set amount=amount-? where accno=? and username=? and password=?");
         checkbal.setLong(1, cnab.getAccNo());
         ResultSet rs1 = checkbal.executeQuery();
         if (rs1.next()) {
            if ((double)rs1.getFloat(4) > cnab.getAmount()) {
               ps.setDouble(1, cnab.getAmount());
               ps.setLong(2, cnab.getAccNo());
               ps.setString(3, cnab.getUserName());
               ps.setString(4, cnab.getPassword());
               this.k = ps.executeUpdate();
            } else {
               System.out.println("amount is not sufficient");
            }
         }
      } catch (Exception var6) {
         var6.printStackTrace();
      }

      return this.k;
   }
}