  package Test;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet({"/closeAc"})
public class CloseAcServlet extends HttpServlet {
   protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
      CreateNewAccountBean cnab = new CreateNewAccountBean();
      long ac = Long.parseLong(req.getParameter("acno"));
      cnab.setAccNo(Long.parseLong(req.getParameter("acno")));
      cnab.setUserName(req.getParameter("username"));
      cnab.setPassword(req.getParameter("password"));
      int k = (new CloseAcDAO()).closeAc(cnab);
      if (k > 0) {
         req.setAttribute("msg", cnab);
         req.getRequestDispatcher("CloseAc.jsp").forward(req, res);
      } else {
         req.setAttribute("msg", ac);
         req.getRequestDispatcher("closeAcerror.jsp").forward(req, res);
      }

   }
}