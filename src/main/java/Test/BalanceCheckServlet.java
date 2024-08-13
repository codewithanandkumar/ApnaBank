   package Test;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet({"/balFrm"})
public class BalanceCheckServlet extends HttpServlet {
   protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
      CreateNewAccountBean balCheck = (new BalanceCheckDAO()).balCheck(Long.parseLong(req.getParameter("acno")), req.getParameter("username"), req.getParameter("password"));
      if (balCheck == null) {
         req.setAttribute("msg", "Soory Your Account is invalid");
         req.getRequestDispatcher("Error.jsp").forward(req, res);
      } else {
         req.setAttribute("msg", balCheck);
         req.getRequestDispatcher("CheckBalance.jsp").forward(req, res);
      }

   }
}