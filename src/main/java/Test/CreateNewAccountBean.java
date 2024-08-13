    package Test;

import java.io.Serializable;

public class CreateNewAccountBean implements Serializable {
   private long AccNo;
   private long phno;
   private String userName;
   private String password;
   private String address;
   private double amount;

   public long getAccNo() {
      return this.AccNo;
   }

   public void setAccNo(long accNo) {
      this.AccNo = accNo;
   }

   public long getPhno() {
      return this.phno;
   }

   public void setPhno(long phno) {
      this.phno = phno;
   }

   public String getUserName() {
      return this.userName;
   }

   public void setUserName(String userName) {
      this.userName = userName;
   }

   public String getPassword() {
      return this.password;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   public String getAddress() {
      return this.address;
   }

   public void setAddress(String address) {
      this.address = address;
   }

   public double getAmount() {
      return this.amount;
   }

   public void setAmount(double amount) {
      this.amount = amount;
   }
}