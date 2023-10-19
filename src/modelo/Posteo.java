package modelo;

import java.time.LocalDate;
import java.time.LocalTime;

public class Posteo extends Publicacion {
	private String texto;
	private boolean publico;

	public Posteo(int idPublicacion, LocalDate fecha, LocalTime hora, Usuario creador, String texto, boolean publico) {
		super(idPublicacion, fecha, hora, creador);
		this.texto = texto;
		this.publico = publico;
	}

	public boolean contieneTexto(String buscar) {
		boolean contiene = false;
		if (texto.indexOf(buscar) != -1) {
			contiene = true;
		}
		return contiene;

	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public boolean isPublico() {
		return publico;
	}

	public void setPublico(boolean publico) {
		this.publico = publico;
	}

	@Override
	public String toString() {
		return super.toString() + "Posteo [texto=" + texto + ", publico=" + publico + "]";
	}

}
