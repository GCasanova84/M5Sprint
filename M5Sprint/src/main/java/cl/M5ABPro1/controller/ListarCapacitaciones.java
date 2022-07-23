package cl.M5ABPro1.controller;

import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

import cl.M5ABPro1.model.events.Capacitacion;
import cl.M5ABPro1.model.implementation.CapacitacionImpl;

/**
 * Servlet implementation class ListarCapacitaciones
 */
public class ListarCapacitaciones extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarCapacitaciones() {
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
			CapacitacionImpl impl = new CapacitacionImpl();
			List<Capacitacion> capacitaciones = impl.listarCapacitaciones();
			request.setAttribute("capacitaciones", capacitaciones);			
			getServletContext().getRequestDispatcher("/views/listar-capacitaciones.jsp").forward(request, response);
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
