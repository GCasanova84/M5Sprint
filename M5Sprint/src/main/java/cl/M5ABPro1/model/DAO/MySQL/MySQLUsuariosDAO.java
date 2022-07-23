package cl.M5ABPro1.model.DAO.MySQL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cl.M5ABPro1.model.DAO.IUsuariosDAO;
import cl.M5ABPro1.model.connection.MysqlConnection;
import cl.M5ABPro1.model.users.Administrativo;
import cl.M5ABPro1.model.users.Cliente;
import cl.M5ABPro1.model.users.Profesional;
import cl.M5ABPro1.model.users.Usuario;

public class MySQLUsuariosDAO implements IUsuariosDAO {

	private Connection connection;

	public MySQLUsuariosDAO() {
		connection = MysqlConnection.getInstance();
	}

	@Override
	public Usuario get(String id) {
		String query = "SELECT * FROM risk_prev_DB.usuarios u WHERE u.id_usuario =" + id + ";";
		Usuario usuario = null;
		try {
			Statement stm = connection.createStatement();
			ResultSet rs = stm.executeQuery(query);
			if (rs.next()) {
				String tipoUsuario = rs.getString("tipo_usuario");
				if (tipoUsuario.equals("admin")) {
					String aQuery = "SELECT u.id_usuario, nombre_usuario, fecha_nacimiento, run, area, experiencia_previa "
							+ "FROM risk_prev_DB.usuarios u "
							+ "JOIN risk_prev_DB.administrativos a ON u.id_usuario = a.id_usuario "
							+ "AND u.id_usuario =" + id + ";";
					Statement astm = connection.createStatement();
					ResultSet ars = astm.executeQuery(aQuery);
					if (ars.next()) {
						usuario = new Administrativo(ars.getString("id_usuario"), ars.getString("nombre_usuario"),
								ars.getString("fecha_nacimiento"), ars.getString("run"), ars.getString("area"),
								ars.getString("experiencia_previa"));
					}
					ars.close();
					astm.close();
				} else if (tipoUsuario.equals("cliente")) {
					String cQuery = "SELECT u.id_usuario, nombre_usuario, fecha_nacimiento, run, rut, nombres, "
							+ "apellidos, telefono, afp, sistema_salud, direccion, comuna, edad "
							+ "FROM risk_prev_DB.usuarios u "
							+ "JOIN risk_prev_DB.clientes c ON u.id_usuario = c.id_usuario " + "AND u.id_usuario = "
							+ id + ";";
					Statement cstm = connection.createStatement();
					ResultSet crs = cstm.executeQuery(cQuery);
					if (crs.next()) {
						usuario = new Cliente(crs.getString("id_usuario"), crs.getString("nombre_usuario"),
								crs.getString("fecha_nacimiento"), crs.getString("run"), crs.getString("rut"),
								crs.getString("nombres"), crs.getString("apellidos"), crs.getString("telefono"),
								crs.getString("afp"), crs.getInt("sistema_salud"), crs.getString("direccion"),
								crs.getString("comuna"), crs.getInt("edad"));
					}
					crs.close();
					cstm.close();
				} else if (tipoUsuario.equals("pro")) {
					String pQuery = "SELECT u.id_usuario, nombre_usuario, fecha_nacimiento, run, titulo, fecha_ingreso "
							+ "FROM risk_prev_DB.usuarios u "
							+ "JOIN risk_prev_DB.profesionales p ON u.id_usuario = p.id_usuario " + "AND u.id_usuario ="
							+ id + ";";
					Statement pstm = connection.createStatement();
					ResultSet prs = pstm.executeQuery(pQuery);
					if (prs.next()) {
						usuario = new Profesional(prs.getString("id_usuario"), prs.getString("nombre_usuario"),
								prs.getString("fecha_nacimiento"), prs.getString("run"), prs.getString("titulo"),
								prs.getString("fecha_ingreso"));
					}
					prs.close();
					pstm.close();
				} else {
					usuario = new Usuario(rs.getString("id_usuario"), rs.getString("nombre_usuario"),
							rs.getString("fecha_nacimiento"), rs.getString("run"));
				}
			}
			stm.close();
			rs.close();
		} catch (Exception e) {
			System.out.println("¡Error obteniendo al usuario!");
		}
		return usuario;
	}

	@Override
	public List<Usuario> getAll() {
		String query = "SELECT * FROM risk_prev_DB.usuarios";
		List<Usuario> usuarios = new ArrayList<Usuario>();
		try {
			Statement stm = connection.createStatement();
			ResultSet rs = stm.executeQuery(query);
			while (rs.next()) {
				String tipoUsuario = rs.getString("tipo_usuario");
				if (tipoUsuario.equals("admin")) {
					String aQuery = "SELECT u.id_usuario, nombre_usuario, fecha_nacimiento, run, area, experiencia_previa "
							+ "FROM risk_prev_DB.usuarios u "
							+ "JOIN risk_prev_DB.administrativos a ON u.id_usuario = a.id_usuario "
							+ "AND u.id_usuario =" + rs.getString("id_usuario") + ";";
					Statement astm = connection.createStatement();
					ResultSet ars = astm.executeQuery(aQuery);
					if (ars.next()) {
						usuarios.add(new Administrativo(ars.getString("id_usuario"), ars.getString("nombre_usuario"),
								ars.getString("fecha_nacimiento"), ars.getString("run"), ars.getString("area"),
								ars.getString("experiencia_previa")));
					}
					ars.close();
					astm.close();
					continue;
				}

				if (tipoUsuario.equals("cliente")) {
					String cQuery = "SELECT u.id_usuario, nombre_usuario, fecha_nacimiento, run, rut, nombres, "
							+ "apellidos, telefono, afp, sistema_salud, direccion, comuna, edad "
							+ "FROM risk_prev_DB.usuarios u "
							+ "JOIN risk_prev_DB.clientes c ON u.id_usuario = c.id_usuario " + "AND u.id_usuario = "
							+ rs.getString("id_usuario") + ";";
					Statement cstm = connection.createStatement();
					ResultSet crs = cstm.executeQuery(cQuery);
					if (crs.next()) {
						usuarios.add(new Cliente(crs.getString("id_usuario"), crs.getString("nombre_usuario"),
								crs.getString("fecha_nacimiento"), crs.getString("run"), crs.getString("rut"),
								crs.getString("nombres"), crs.getString("apellidos"), crs.getString("telefono"),
								crs.getString("afp"), crs.getInt("sistema_salud"), crs.getString("direccion"),
								crs.getString("comuna"), crs.getInt("edad")));
					}
					crs.close();
					cstm.close();
					continue;
				}

				if (tipoUsuario.equals("pro")) {
					String pQuery = "SELECT u.id_usuario, nombre_usuario, fecha_nacimiento, run, titulo, fecha_ingreso "
							+ "FROM risk_prev_DB.usuarios u "
							+ "JOIN risk_prev_DB.profesionales p ON u.id_usuario = p.id_usuario " + "AND u.id_usuario ="
							+ rs.getString("id_usuario") + ";";
					Statement pstm = connection.createStatement();
					ResultSet prs = pstm.executeQuery(pQuery);
					if (prs.next()) {
						usuarios.add(new Profesional(prs.getString("id_usuario"), prs.getString("nombre_usuario"),
								prs.getString("fecha_nacimiento"), prs.getString("run"), prs.getString("titulo"),
								prs.getString("fecha_ingreso")));
					}
					prs.close();
					pstm.close();
					continue;
				}

				usuarios.add(new Usuario(rs.getString("id_usuario"), rs.getString("nombre_usuario"),
						rs.getString("fecha_nacimiento"), rs.getString("run")));
			}
			stm.close();
			rs.close();
		} catch (Exception e) {
			System.out.println("¡Error obteniendo los usuarios!");
		}
		return usuarios;
	}

	@Override
	public void addUsuario(Usuario usuario) {
		try {
			String tipoUsuario = usuario.getClass().getSimpleName();
			String nombre = usuario.getNombre();
			String fechaNacimiento = usuario.getFechaNacimiento();
			String run = usuario.getRun();
			Statement stm = connection.createStatement();
			stm.execute("INSERT INTO risk_prev_DB.usuarios(nombre_usuario, fecha_nacimiento, run) " + "VALUES ('"
					+ nombre + "', '" + fechaNacimiento + "', '" + run + "');");
			stm.close();

			Statement ustm = connection.createStatement();
			ResultSet urs = ustm
					.executeQuery("SELECT id_usuario FROM risk_prev_DB.usuarios u WHERE u.run = '" + run + "';");

			if (tipoUsuario.equals("Administrativo")) {
				String area = ((Administrativo) usuario).getArea();
				String experienciaPrevia = ((Administrativo) usuario).getExperienciaPrevia();
				if (urs.next()) {
					String idUsuario = urs.getString("id_usuario");
					Statement astm = connection.createStatement();
					astm.addBatch("INSERT INTO risk_prev_DB.administrativos(area, experiencia_previa, id_usuario) "
							+ "VALUES ('" + area + "', '" + experienciaPrevia + "', " + idUsuario + ");");
					astm.addBatch("UPDATE risk_prev_DB.usuarios SET tipo_usuario = 'admin' WHERE id_usuario = "
							+ idUsuario + ";");
					astm.executeBatch();
					astm.close();
				}
			} else if (tipoUsuario.equals("Cliente")) {
				String rut = ((Cliente) usuario).getRut();
				String nombres = ((Cliente) usuario).getNombres();
				String apellidos = ((Cliente) usuario).getApellidos();
				String telefono = ((Cliente) usuario).getTelefono();
				String afp = ((Cliente) usuario).getAfp();
				int sistemaSalud = ((Cliente) usuario).getSistemaSalud();
				String direccion = ((Cliente) usuario).getDireccion();
				String comuna = ((Cliente) usuario).getComuna();
				int edad = ((Cliente) usuario).getEdad();
				if (urs.next()) {
					String idUsuario = urs.getString("id_usuario");
					Statement cstm = connection.createStatement();
					cstm.addBatch(
							"INSERT INTO risk_prev_DB.clientes(rut, nombres, apellidos, telefono, afp, sistema_salud, direccion, comuna, edad, id_usuario) "
									+ "VALUES ('" + rut + "', '" + nombres + "', '" + apellidos + "', '" + telefono
									+ "', '" + afp + "', " + sistemaSalud + ", '" + direccion + "', '" + comuna + "', "
									+ edad + ", " + idUsuario + ");");
					cstm.addBatch("UPDATE risk_prev_DB.usuarios SET tipo_usuario = 'cliente' WHERE id_usuario = "
							+ idUsuario + ";");
					cstm.executeBatch();
					cstm.close();
				}
			} else if (tipoUsuario.equals("Profesional")) {
				String titulo = ((Profesional) usuario).getTitulo();
				String fechaIngreso = ((Profesional) usuario).getFechaIngreso();
				if (urs.next()) {
					String idUsuario = urs.getString("id_usuario");
					Statement pstm = connection.createStatement();
					pstm.addBatch("INSERT INTO risk_prev_DB.profesionales(titulo, fecha_ingreso, id_usuario) VALUES ('"
							+ titulo + "', '" + fechaIngreso + "', " + idUsuario + ");");
					pstm.addBatch("UPDATE risk_prev_DB.usuarios SET tipo_usuario = 'pro' WHERE id_usuario = "
							+ idUsuario + ";");
					pstm.executeBatch();
					pstm.close();
				}
			}
			urs.close();
			ustm.close();
		} catch (Exception e) {
			System.out.println("¡Error agregando usuario!");
		}
	}

	@Override
	public void updateUsuario(Usuario usuario) {
		try {
			String tipoUsuario = usuario.getClass().getSimpleName();
			String idUsuario = usuario.getId();
			System.out.println(idUsuario);
			String nombre = usuario.getNombre();
			String fechaNacimiento = usuario.getFechaNacimiento();
			String run = usuario.getRun();
			Statement stm = connection.createStatement();
			stm.addBatch("UPDATE risk_prev_DB.usuarios SET nombre_usuario = '" + nombre + "', fecha_nacimiento = '"
					+ fechaNacimiento + "', run = '" + run + "' WHERE id_usuario = " + idUsuario + ";");
			if (tipoUsuario.equals("Administrativo")) {
				String area = ((Administrativo) usuario).getArea();
				String experienciaPrevia = ((Administrativo) usuario).getExperienciaPrevia();
				stm.addBatch("UPDATE risk_prev_DB.administrativos SET area = '" + area + "', experiencia_previa = '"
						+ experienciaPrevia + "' WHERE id_usuario = " + idUsuario + ";");
			} else if (tipoUsuario.equals("Cliente")) {
				String rut = ((Cliente) usuario).getRut();
				String nombres = ((Cliente) usuario).getNombres();
				String apellidos = ((Cliente) usuario).getApellidos();
				String telefono = ((Cliente) usuario).getTelefono();
				String afp = ((Cliente) usuario).getAfp();
				int sistemaSalud = ((Cliente) usuario).getSistemaSalud();
				String direccion = ((Cliente) usuario).getDireccion();
				String comuna = ((Cliente) usuario).getComuna();
				int edad = ((Cliente) usuario).getEdad();
				stm.addBatch("UPDATE risk_prev_DB.clientes SET rut = '" + rut + "', nombres = '" + nombres
						+ "', apellidos = '" + apellidos + "', telefono = '" + telefono + "', afp = '" + afp
						+ "', sistema_salud = " + sistemaSalud + ", direccion = '" + direccion + "', comuna = '"
						+ comuna + "', edad = " + edad + " WHERE id_usuario = " + idUsuario + ";");
			} else if (tipoUsuario.equals("Profesional")) {
				String titulo = ((Profesional) usuario).getTitulo();
				String fechaIngreso = ((Profesional) usuario).getFechaIngreso();
				stm.addBatch("UPDATE risk_prev_DB.profesionales SET titulo = '" + titulo + "', fecha_ingreso = '"
						+ fechaIngreso + "' WHERE id_usuario = " + idUsuario + ";");
			}
			stm.executeBatch();
			stm.close();
		} catch (Exception e) {
			System.out.println("¡Error editando usuario!");
		}

	}

}
