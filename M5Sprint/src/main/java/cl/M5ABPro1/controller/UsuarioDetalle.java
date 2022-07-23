package cl.M5ABPro1.controller;

import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import cl.M5ABPro1.model.implementation.UsuarioImpl;
import cl.M5ABPro1.model.users.Usuario;

/**
 * Servlet implementation class Usuario
 */
public class UsuarioDetalle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsuarioDetalle() {
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
			String usuarioID = request.getParameter("usuarioId");
			UsuarioImpl impl = new UsuarioImpl();
			Usuario usuario = impl.usuarioPorId(usuarioID);
			request.setAttribute("usuario", usuario);	
			getServletContext().getRequestDispatcher("/views/usuario-detalles.jsp").forward(request, response);
		} else {
			response.sendRedirect(request.getContextPath() + "/Login");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
