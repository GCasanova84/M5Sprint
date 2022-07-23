package cl.M5ABPro1.model.events;

public class Capacitacion {

	private int identificador;
	private String rutCliente;
	private String dia;
	private String hora;
	private String lugar;
	private String duracion;
	private int cantidadAsistentes;

	public Capacitacion() {
	}

	public Capacitacion(int identificador, String rutCliente, String dia, String hora, String lugar, String duracion,
			int cantidadAsistentes) {
		this.identificador = identificador;
		this.rutCliente = rutCliente;
		this.dia = dia;
		this.hora = hora;
		this.lugar = lugar;
		this.duracion = duracion;
		this.cantidadAsistentes = cantidadAsistentes;
	}

	public int getIdentificador() {
		return identificador;
	}

	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}

	public String getRutCliente() {
		return rutCliente;
	}

	public void setRutCliente(String rutCliente) {
		this.rutCliente = rutCliente;
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public String getDuracion() {
		return duracion;
	}

	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}

	public int getCantidadAsistentes() {
		return cantidadAsistentes;
	}

	public void setCantidadAsistentes(int cantidadAsistentes) {
		this.cantidadAsistentes = cantidadAsistentes;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Capacitacion [identificador=").append(identificador).append(", rutCliente=").append(rutCliente)
				.append(", dia=").append(dia).append(", hora=").append(hora).append(", lugar=").append(lugar)
				.append(", duracion=").append(duracion).append(", cantidadAsistentes=").append(cantidadAsistentes)
				.append("]");
		return builder.toString();
	}

	public String mostrarDetalle() {
		return "La capacitacion será en " + lugar + " a las " + hora + " horas del día " + dia + ", y durará "
				+ duracion + " minutos.";
	}
}
