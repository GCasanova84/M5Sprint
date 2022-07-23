package cl.M5ABPro1.model.users;

public class Administrativo extends Usuario {

	private String area;
	private String experienciaPrevia;

	public Administrativo() {
		super();
	}

	public Administrativo(String id, String nombre, String fechaNacimiento, String run, String area, String experienciaPrevia) {
		super(id, nombre, fechaNacimiento, run);
		this.area = area;
		this.experienciaPrevia = experienciaPrevia;
	}

	public Administrativo(String area, String experienciaPrevia) {
		super();
		this.area = area;
		this.experienciaPrevia = experienciaPrevia;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getExperienciaPrevia() {
		return experienciaPrevia;
	}

	public void setExperienciaPrevia(String experienciaPrevia) {
		this.experienciaPrevia = experienciaPrevia;
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
		builder.append("Administrativo [area=").append(area).append(", experienciaPrevia=").append(experienciaPrevia)
				.append("]");
		return builder.toString();
	}

	public String analizarUsuario() {
		return super.analizarUsuario() + "\nÁrea: " + area + "\nExperiencia previa: " + experienciaPrevia;
	}
	
	public String analizarUsuario(Boolean soloPadre) {
		if (soloPadre) {
			return super.analizarUsuario();
		} else {
			return this.analizarUsuario();
		}		
	}
}
