package cl.M5ABPro1.model.implementation;

import java.util.List;

import cl.M5ABPro1.model.interfaces.UsuarioInterface;
import cl.M5ABPro1.model.services.UsuarioService;
import cl.M5ABPro1.model.users.Usuario;

public class UsuarioImpl implements UsuarioInterface {
	
	UsuarioService userServ = new UsuarioService();
	
	@Override
	public Usuario usuarioPorId(String id) {
		return userServ.getUsuario(id);
	}
	
	@Override
	public List<Usuario> listarUsuarios() {
		return userServ.getAllUsuarios();
	}

	@Override
	public void registrarUsuario(Usuario usuario) {
		userServ.addUsuario(usuario);
	}

	@Override
	public void editarUsuario(Usuario usuario) {
		userServ.updateUsuario(usuario);		
	}	

}
