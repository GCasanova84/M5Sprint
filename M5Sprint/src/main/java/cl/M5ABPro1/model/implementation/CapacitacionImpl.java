package cl.M5ABPro1.model.implementation;

import java.util.List;

import cl.M5ABPro1.model.events.Capacitacion;
import cl.M5ABPro1.model.interfaces.CapacitacionInterface;
import cl.M5ABPro1.model.services.CapacitacionService;

public class CapacitacionImpl implements CapacitacionInterface {
	
	CapacitacionService capServ = new CapacitacionService();
	
	@Override
	public List<Capacitacion> listarCapacitaciones() {		
		return capServ.getAllCapacitaciones();
	}

	@Override
	public void registrarCapacitacion(Capacitacion capacitacion) {
		capServ.addCapacitacion(capacitacion);;		
	}	

}
