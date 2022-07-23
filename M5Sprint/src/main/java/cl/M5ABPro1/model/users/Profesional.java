package cl.M5ABPro1.model.users;

public class Profesional extends Usuario {

	private String titulo;
	private String fechaIngreso;

	public Profesional() {
		super();
	}

	public Profesional(String id, String nombre, String fechaNacimiento, String run, String titulo, String fechaIngreso) {
		super(id, nombre, fechaNacimiento, run);
		this.titulo = titulo;
		this.fechaIngreso = fechaIngreso;
	}

	public Profesional(String titulo, String fechaIngreso) {
		super();
		this.titulo = titulo;
		this.fechaIngreso = fechaIngreso;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(String fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return super.getId();
	}

	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return super.getNombre();
	}

	@Override
	public String getFechaNacimiento() {
		// TODO Auto-generated method stub
		return super.getFechaNacimiento();
	}

	@Override
	public String getRun() {
		// TODO Auto-generated method stub
		return super.getRun();
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Profesional [titulo=").append(titulo).append(", fechaIngreso=").append(fechaIngreso)
				.append("]");
		return builder.toString();
	}

	public String analizarUsuario() {
		return super.analizarUsuario() + "\nTítulo: " + titulo + "\nFecha de ingreso: " + fechaIngreso;
	}

	public String analizarUsuario(Boolean soloPadre) {
		if (soloPadre) {
			return super.analizarUsuario();
		} else {
			return this.analizarUsuario();
		}
	}
}
