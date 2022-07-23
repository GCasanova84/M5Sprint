package cl.M5ABPro1.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
//import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
//import java.io.PrintWriter;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/views/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("user");
		String password = request.getParameter("password");
		
		if (user.equals("admin") && password.equals("1234")) {
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			session.setAttribute("password", password);
			response.sendRedirect(request.getContextPath() + "/Contacto");
		} else {
			doGet(request, response);
		}		
		
		Cookie cUser = new Cookie("user", user);
		Cookie cPassword = new Cookie("password", password);		
		response.addCookie(cUser);
		response.addCookie(cPassword);
	}

}
