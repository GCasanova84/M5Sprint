package cl.M5ABPro1.model.DAO;

import java.util.List;

import cl.M5ABPro1.model.events.Capacitacion;

public interface ICapacitacionesDAO {
	
	public Capacitacion get(String id);
	
	public List<Capacitacion> getAll();
	
	public void addCapacitacion(Capacitacion capacitacion);
}
