package modelo;

import java.time.LocalDate;
import java.time.LocalTime;

public abstract class Publicacion {
	protected int idPublicacion;
	protected LocalDate fecha;
	protected LocalTime hora;
	protected Usuario creador;

	public Publicacion(int idPublicacion, LocalDate fecha, LocalTime hora, Usuario creador) {
		super();
		this.idPublicacion = idPublicacion;
		this.fecha = fecha;
		this.hora = hora;
		this.creador = creador;
	}

	// CU 6
	public abstract boolean contieneTexto(String buscar);

	public int getIdPublicacion() {
		return idPublicacion;
	}

	public void setIdPublicacion(int idPublicacion) {
		this.idPublicacion = idPublicacion;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
	}

	public Usuario getCreador() {
		return creador;
	}

	public void setCreador(Usuario creador) {
		this.creador = creador;
	}

	@Override
	public String toString() {
		return "Publicacion [idPublicacion=" + idPublicacion + ", fecha=" + fecha + ", hora=" + hora + ", creador="
				+ creador + "]";
	}

}
