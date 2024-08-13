 package Test;

import com.dao.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CreateNewAccountDAO {
   public int k = 0;

   public int newAcc(CreateNewAccountBean cnab) {
      try {
         Connection con = DBConnection.getConnection();
         PreparedStatement check = con.prepareStatement("select *from ApnaBankReg where username=?");
         PreparedStatement ps = con.prepareStatement("insert into ApnaBankReg(USERNAME,PASSWORD,AMOUNT,ADDRESS,PHONE) values(?,?,?,?,?) ");
         ps.setString(1, cnab.getUserName());
         ps.setString(2, cnab.getPassword());
         ps.setDouble(3, cnab.getAmount());
         ps.setString(4, cnab.getAddress());
         ps.setLong(5, cnab.getPhno());
         this.k = ps.executeUpdate();
         check.setString(1, cnab.getUserName());
         ResultSet rs = check.executeQuery();
         if (rs.next()) {
            cnab.setAccNo(rs.getLong(1));
         }
      } catch (Exception var6) {
         var6.printStackTrace();
      }

      return this.k;
   }
}