package modelo;

import java.time.LocalDate;
import java.time.LocalTime;

public class AvisoGeneral extends Publicacion {
	private String titulo;
	private String cuerpo;

	public AvisoGeneral(int idPublicacion, LocalDate fecha, LocalTime hora, Usuario creador, String titulo,
			String cuerpo) {
		super(idPublicacion, fecha, hora, creador);
		this.titulo = titulo;
		this.cuerpo = cuerpo;
	}

	public boolean contieneTexto(String buscar) {
		boolean contiene = false;
		if ((cuerpo.indexOf(buscar) != -1) && (titulo.indexOf(buscar)) != -1) {
			contiene = true;
		}
		return contiene;

	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getCuerpo() {
		return cuerpo;
	}

	public void setCuerpo(String cuerpo) {
		this.cuerpo = cuerpo;
	}

	@Override
	public String toString() {
		return super.toString() + "AvisoGeneral [titulo=" + titulo + ", cuerpo=" + cuerpo + "]";
	}

}
