package cl.M5ABPro1.model.interfaces;

import java.util.List;

import cl.M5ABPro1.model.events.Capacitacion;

public interface CapacitacionInterface {
	
	public List<Capacitacion> listarCapacitaciones();
	
	public void registrarCapacitacion(Capacitacion capacitacion);
}
