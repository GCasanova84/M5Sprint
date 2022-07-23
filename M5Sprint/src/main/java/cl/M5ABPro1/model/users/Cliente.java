package cl.M5ABPro1.model.users;

public class Cliente extends Usuario {

	private String rut;
	private String nombres;
	private String apellidos;
	private String telefono;
	private String afp;
	private int sistemaSalud;
	private String direccion;
	private String comuna;
	private int edad;

	public Cliente() {
		super();
	}

	public Cliente(String id, String nombre, String fechaNacimiento, String run, String rut, String nombres, String apellidos,
			String telefono, String afp, int sistemaSalud, String direccion, String comuna, int edad) {
		super(id, nombre, fechaNacimiento, run);
		this.rut = rut;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.telefono = telefono;
		this.afp = afp;
		this.sistemaSalud = sistemaSalud;
		this.direccion = direccion;
		this.comuna = comuna;
		this.edad = edad;
	}

	public Cliente(String rut, String nombres, String apellidos, String telefono, String afp, int sistemaSalud,
			String direccion, String comuna, int edad) {
		super();
		this.rut = rut;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.telefono = telefono;
		this.afp = afp;
		this.sistemaSalud = sistemaSalud;
		this.direccion = direccion;
		this.comuna = comuna;
		this.edad = edad;
	}

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getAfp() {
		return afp;
	}

	public void setAfp(String afp) {
		this.afp = afp;
	}

	public int getSistemaSalud() {
		return sistemaSalud;
	}

	public void setSistemaSalud(int sistemaSalud) {
		this.sistemaSalud = sistemaSalud;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getComuna() {
		return comuna;
	}

	public void setComuna(String comuna) {
		this.comuna = comuna;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
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
		builder.append("Cliente [rut=").append(rut).append(", nombres=").append(nombres).append(", apellidos=")
				.append(apellidos).append(", telefono=").append(telefono).append(", afp=").append(afp)
				.append(", sistemaSalud=").append(sistemaSalud).append(", direccion=").append(direccion)
				.append(", comuna=").append(comuna).append(", edad=").append(edad).append("]");
		return builder.toString();
	}

	public String analizarUsuario() {
		return super.analizarUsuario() + "\nDirección: " + direccion + "\nComuna: " + comuna;
	}

	public String analizarUsuario(Boolean soloPadre) {
		if (soloPadre) {
			return super.analizarUsuario();
		} else {
			return this.analizarUsuario();
		}
	}

	public String obtenerNombre() {
		return this.nombres + " " + this.apellidos;
	}

	public String obtenerSistemaSalud() {
		return this.sistemaSalud == 1 ? "Fonasa" : "Isapre";
	}
}
