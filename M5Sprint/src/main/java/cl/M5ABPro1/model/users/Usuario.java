package cl.M5ABPro1.model.users;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

public class Usuario {

	protected String id;
	protected String nombre;
	protected String fechaNacimiento;
	protected String run;

	public Usuario() {
	}

	public Usuario(String id, String nombre, String fechaNacimiento, String run) {
		this.id = id;
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
		this.run = run;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getRun() {
		return run;
	}

	public void setRun(String run) {
		this.run = run;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Usuario [nombre=").append(nombre).append(", fechaNacimiento=").append(fechaNacimiento)
				.append(", run=").append(run).append("]");
		return builder.toString();
	}

	public String analizarUsuario() {
		return "Nombre: " + nombre + "\nRun: " + run;
	}

	public String mostrarEdad() throws ParseException {
		int edad;
		final SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
		LocalDate fechaHoy = LocalDate.now();
		Date fechaNacimiento = formatoFecha.parse(this.fechaNacimiento);
		edad = Period.between(fechaNacimiento.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), fechaHoy)
				.getYears();
		return "El usuario tiene " + edad + " años";
	}
}
