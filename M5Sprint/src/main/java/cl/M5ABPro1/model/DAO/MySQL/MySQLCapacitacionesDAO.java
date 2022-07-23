package cl.M5ABPro1.model.DAO.MySQL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cl.M5ABPro1.model.DAO.ICapacitacionesDAO;
import cl.M5ABPro1.model.connection.MysqlConnection;
import cl.M5ABPro1.model.events.Capacitacion;

public class MySQLCapacitacionesDAO implements ICapacitacionesDAO {

	private Connection connection;

	public MySQLCapacitacionesDAO() {
		connection = MysqlConnection.getInstance();
	}

	@Override
	public Capacitacion get(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Capacitacion> getAll() {
		String query = "SELECT * FROM risk_prev_DB.capacitaciones";
		List<Capacitacion> capacitaciones = new ArrayList<Capacitacion>();
		try {
			Statement stm = connection.createStatement();
			ResultSet rs = stm.executeQuery(query);
			while (rs.next()) {
				capacitaciones.add(new Capacitacion(rs.getInt("id_capacitaciones"), rs.getString("rut_cliente"),
						rs.getString("dia_capacitacion"), rs.getString("hora_capacitacion"),
						rs.getString("lugar_capacitacion"), rs.getString("duracion_capacitacion"),
						rs.getInt("cantidad_asistentes")));
			}
			stm.close();
			rs.close();
		} catch (Exception e) {
			System.out.println("¡Error obteniendo las capacitaciones!");
		}
		return capacitaciones;
	}

	@Override
	public void addCapacitacion(Capacitacion capacitacion) {
		String query = "INSERT INTO risk_prev_DB.capacitaciones(rut_cliente, dia_capacitacion, hora_capacitacion, lugar_capacitacion, duracion_capacitacion, cantidad_asistentes)\n"
				+ "VALUES ('" + capacitacion.getRutCliente() + "', '" + capacitacion.getDia() + "', '"
				+ capacitacion.getHora() + "', '" + capacitacion.getLugar() + "', '" + capacitacion.getDuracion()
				+ "', " + capacitacion.getCantidadAsistentes() + ");";
		try {
			Statement stm = connection.createStatement();
			stm.execute(query);
			stm.close();
		} catch (Exception e) {
			System.out.println("¡Error agregando capacitación!");
		}
	}

}
