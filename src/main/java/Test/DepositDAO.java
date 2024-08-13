    package Test;

import com.dao.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class DepositDAO {
   public int k = 0;

   public int deposit(CreateNewAccountBean cnab) {
      try {
         Connection con = DBConnection.getConnection();
         PreparedStatement ps = con.prepareStatement("update apnabankreg set amount=amount-? where accno=? and username=? and password=?");
         ps.setDouble(1, cnab.getAmount());
         ps.setLong(2, cnab.getAccNo());
         ps.setString(3, cnab.getUserName());
         ps.setString(4, cnab.getPassword());
         this.k = ps.executeUpdate();
      } catch (Exception var4) {
         var4.printStackTrace();
      }

      return this.k;
   }
}