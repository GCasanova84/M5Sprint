package cl.M5ABPro1.model.services;

import java.util.List;

import cl.M5ABPro1.model.DAO.ICapacitacionesDAO;
import cl.M5ABPro1.model.DAO.MySQL.MySQLCapacitacionesDAO;
import cl.M5ABPro1.model.events.Capacitacion;

public class CapacitacionService {
	
	private ICapacitacionesDAO capacitacionDAO = new MySQLCapacitacionesDAO();
	
	public Capacitacion getCapacitacion(String id) {
		return capacitacionDAO.get(id);
	}
	
	public List<Capacitacion> getAllCapacitaciones() {
		return capacitacionDAO.getAll();
	}
	
	public void addCapacitacion(Capacitacion capacitacion) {
		capacitacionDAO.addCapacitacion(capacitacion);
	}

}
