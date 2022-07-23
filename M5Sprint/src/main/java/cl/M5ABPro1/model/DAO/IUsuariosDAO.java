package cl.M5ABPro1.model.DAO;

import java.util.List;

import cl.M5ABPro1.model.users.Usuario;


public interface IUsuariosDAO {
	
	public Usuario get(String id);
	
	public List<Usuario> getAll();
	
	public void addUsuario(Usuario usuario);
	
	public void updateUsuario(Usuario usuario);

}
