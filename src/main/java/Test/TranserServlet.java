    package Test;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet({"/transferAmt"})
public class TranserServlet extends HttpServlet {
   protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
      String msg = (new TransferDAO()).transfer(Long.parseLong(req.getParameter("acno")), req.getParameter("username"), req.getParameter("password"), Long.parseLong(req.getParameter("tAcno")), Double.parseDouble(req.getParameter("amount")));
      if (msg != "") {
         req.setAttribute("msg", msg);
         req.getRequestDispatcher("Tranfser.jsp").forward(req, res);
      }

   }
}