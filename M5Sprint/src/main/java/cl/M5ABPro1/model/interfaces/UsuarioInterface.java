package cl.M5ABPro1.model.interfaces;

import java.util.List;

import cl.M5ABPro1.model.users.Usuario;

public interface UsuarioInterface {
	
	public Usuario usuarioPorId(String id);

	public List<Usuario> listarUsuarios();

	public void registrarUsuario(Usuario usuario);
	
	public void editarUsuario(Usuario usuario);
}
