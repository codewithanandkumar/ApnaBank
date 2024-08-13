 package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
   private static Connection con = null;

   static {
      if (con == null) {
         try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "BATCH31", "DUDE");
         } catch (Exception var1) {
            var1.printStackTrace();
         }
      }

   }

   private DBConnection() {
   }

   public static Connection getConnection() {
      return con;
   }
}
    