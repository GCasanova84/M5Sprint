package cl.M5ABPro1.controller;

import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

import cl.M5ABPro1.model.implementation.UsuarioImpl;
import cl.M5ABPro1.model.users.Administrativo;
import cl.M5ABPro1.model.users.Cliente;
import cl.M5ABPro1.model.users.Profesional;
import cl.M5ABPro1.model.users.Usuario;

/**
 * Servlet implementation class EditarUsuario
 */
public class EditarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditarUsuario() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String user = (String) session.getAttribute("user");
		if (user != null) {
			String usuarioID = request.getParameter("usuarioId");
			UsuarioImpl impl = new UsuarioImpl();
			Usuario usuario = impl.usuarioPorId(usuarioID);
			request.setAttribute("usuario", usuario);
			getServletContext().getRequestDispatcher("/views/editar-usuario.jsp").forward(request, response);
		} else {
			response.sendRedirect(request.getContextPath() + "/Login");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String usuarioId = request.getParameter("usuarioId");
		String nombre = request.getParameter("nombre");
		String fechaNacimiento = request.getParameter("fechaNacimiento");
		String run = request.getParameter("run");
		String tipoUsuario = request.getParameter("tipoUsuario");
		Usuario usuario = null;
		if (tipoUsuario.equals("Administrativo")) {
			String area = request.getParameter("area");
			String experienciaPrevia = request.getParameter("experienciaPrevia");
			usuario = new Administrativo(usuarioId, nombre, fechaNacimiento, run, area, experienciaPrevia);
		} else if (tipoUsuario.equals("Cliente")) {
			String rut = request.getParameter("rut");
			String nombres = request.getParameter("nombres");
			String apellidos = request.getParameter("apellidos");
			String telefono = request.getParameter("telefono");
			String afp = request.getParameter("afp");
			String sistemaSalud = request.getParameter("sistemaSalud");
			String direccion = request.getParameter("direccion");
			String comuna = request.getParameter("comuna");
			String edad = request.getParameter("edad");
			usuario = new Cliente(usuarioId, nombre, fechaNacimiento, run, rut, nombres, apellidos, telefono, afp,
					Integer.parseInt(sistemaSalud), direccion, comuna, Integer.parseInt(edad));
		} else if (tipoUsuario.equals("Profesional")) {
			String titulo = request.getParameter("titulo");
			String fechaIngreso = request.getParameter("fechaIngreso");
			usuario = new Profesional(usuarioId, nombre, fechaNacimiento, run, titulo, fechaIngreso);
		} else {
			usuario = new Usuario(usuarioId, nombre, fechaNacimiento, run);
		}		

		HttpSession session = request.getSession();
		String user = (String) session.getAttribute("user");
		if (user != null) {
			UsuarioImpl impl = new UsuarioImpl();
			impl.editarUsuario(usuario);
			List<Usuario> usuarios = impl.listarUsuarios();
			request.setAttribute("usuarios", usuarios);	
			getServletContext().getRequestDispatcher("/views/listado-usuarios.jsp").forward(request, response);
		} else {
			response.sendRedirect(request.getContextPath() + "/Login");
		}
	}

}
