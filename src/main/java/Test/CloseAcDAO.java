   package Test;

import com.dao.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class CloseAcDAO {
   public int k = 0;

   public int closeAc(CreateNewAccountBean cnab) {
      try {
         Connection con = DBConnection.getConnection();
         PreparedStatement closeAccno = con.prepareStatement("delete from apnabankreg where accno=? and username=? and password=?");
         closeAccno.setLong(1, cnab.getAccNo());
         closeAccno.setString(2, cnab.getUserName());
         closeAccno.setString(3, cnab.getPassword());
         this.k = closeAccno.executeUpdate();
      } catch (Exception var4) {
         var4.printStackTrace();
      }

      return this.k;
   }
}