   package Test;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet({"/withdrawFrm"})
public class WIthDrawServlet extends HttpServlet {
   protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
      CreateNewAccountBean cnab = new CreateNewAccountBean();
      cnab.setAccNo(Long.parseLong(req.getParameter("acno")));
      cnab.setUserName(req.getParameter("username"));
      cnab.setPassword(req.getParameter("password"));
      cnab.setAmount(Double.parseDouble(req.getParameter("amount")));
      int k = (new DepositDAO()).deposit(cnab);
      if (k > 0) {
         req.setAttribute("cnab", cnab);
         req.getRequestDispatcher("WithdrawForm.jsp").forward(req, res);
      } else {
         req.setAttribute("msg", "invalide");
         req.getRequestDispatcher("Error.jsp").forward(req, res);
      }

   }
}