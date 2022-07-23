package cl.M5ABPro1.model.services;

import java.util.List;

import cl.M5ABPro1.model.DAO.IUsuariosDAO;
import cl.M5ABPro1.model.DAO.MySQL.MySQLUsuariosDAO;
import cl.M5ABPro1.model.users.Usuario;

public class UsuarioService {
	
private IUsuariosDAO usuarioDAO = new MySQLUsuariosDAO();
	
	public Usuario getUsuario(String id) {
		return usuarioDAO.get(id);
	}
	
	public List<Usuario> getAllUsuarios() {
		return usuarioDAO.getAll();
	}
	
	public void addUsuario(Usuario usuario) {
		usuarioDAO.addUsuario(usuario);
	}
	
	public void updateUsuario(Usuario usuario) {
		usuarioDAO.updateUsuario(usuario);
	}

}
