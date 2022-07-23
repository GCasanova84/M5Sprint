package cl.M5ABPro1.controller;

import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import cl.M5ABPro1.model.events.Capacitacion;
import cl.M5ABPro1.model.implementation.CapacitacionImpl;

/**
 * Servlet implementation class NuevaCapacitacion
 */
public class NuevaCapacitacion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NuevaCapacitacion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String rut = request.getParameter("rut");
		String dia = request.getParameter("dia");
		String hora = request.getParameter("hora");
		String lugar = request.getParameter("lugar");
		String duracion = request.getParameter("duracion");
		String asistentes = request.getParameter("asistentes");
		
		Capacitacion capacitacion = new Capacitacion(4, rut, dia, hora, lugar, duracion, Integer.parseInt(asistentes));
		CapacitacionImpl impl = new CapacitacionImpl();
		impl.registrarCapacitacion(capacitacion);
		request.setAttribute("capacitacion", capacitacion);	
		
		HttpSession session = request.getSession();
		String user = (String) session.getAttribute("user");		
		if (user != null) {
			getServletContext().getRequestDispatcher("/views/nueva-capacitacion.jsp").forward(request, response);
		} else {
			response.sendRedirect(request.getContextPath() + "/Login");
		}
	}

}
