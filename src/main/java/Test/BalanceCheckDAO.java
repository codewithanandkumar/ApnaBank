  package Test;

import com.dao.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BalanceCheckDAO {
   public CreateNewAccountBean cnab = null;

   public CreateNewAccountBean balCheck(long acno, String username, String password) {
      try {
         Connection con = DBConnection.getConnection();
         PreparedStatement ps = con.prepareStatement("select *from  ApnaBankreg where ACCNO=? and USERNAME=? and PASSWORD=?");
         ps.setLong(1, acno);
         ps.setString(2, username);
         ps.setString(3, password);
         ResultSet k = ps.executeQuery();

         while(k.next()) {
            this.cnab = new CreateNewAccountBean();
            this.cnab.setAccNo(k.getLong(1));
            this.cnab.setUserName(k.getString(2));
            this.cnab.setPassword(k.getString(3));
            this.cnab.setAmount(k.getDouble(4));
            this.cnab.setAddress(k.getString(5));
            this.cnab.setPhno(k.getLong(6));
            System.out.println(k.getLong(3));
         }
      } catch (Exception var8) {
         var8.printStackTrace();
      }

      return this.cnab;
   }
}
    