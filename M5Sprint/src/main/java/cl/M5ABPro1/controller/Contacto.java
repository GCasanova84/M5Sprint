package cl.M5ABPro1.controller;

import jakarta.servlet.ServletException;
//import jakarta.servlet.http.Cookie;
//import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Servlet implementation class Contacto
 */
public class Contacto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Contacto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String user = (String) session.getAttribute("user");
		if (user != null) {
			getServletContext().getRequestDispatcher("/views/contacto.jsp").forward(request, response);
		} else {
			response.sendRedirect(request.getContextPath() + "/Login");
		}	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String msg = request.getParameter("msg");
		System.out.println("email: " + email);
		System.out.println("msg: " + msg);
		HttpSession session = request.getSession();
		String user = (String) session.getAttribute("user");
		if (user != null) {
			response.sendRedirect(request.getContextPath() + "/Contacto");
		} else {
			response.sendRedirect(request.getContextPath() + "/Login");
		}
	}

}
