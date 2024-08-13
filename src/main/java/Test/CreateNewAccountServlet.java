package Test;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet({ "/newAc" })
public class CreateNewAccountServlet extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		CreateNewAccountBean cnab = new CreateNewAccountBean();
		cnab.setUserName(req.getParameter("username"));
		cnab.setPassword(req.getParameter("password"));
		cnab.setAmount(Double.parseDouble(req.getParameter("amount")));
		cnab.setAddress(req.getParameter("address"));
		cnab.setPhno(Long.parseLong(req.getParameter("phone")));
		System.out.println(cnab.getUserName());
		int k = (new CreateNewAccountDAO()).newAcc(cnab);
		if (k > 0) {
			req.setAttribute("msg", "Your Account is Created Succussfully...");
			req.setAttribute("cnab", cnab);
			req.getRequestDispatcher("CreateNewAccount.jsp").forward(req, res);
		} else {
			req.setAttribute("msg", "Soory you don't have account");
			req.getRequestDispatcher("Error.jsp").forward(req, res);
		}

	}
}