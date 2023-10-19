package modelo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Sistema {
	private List<Usuario> lstUsuarios;
	private List<Publicacion> lstPublicaciones;
	private List<Comentario> lstComentarios;

	public Sistema() {
		super();
		this.lstUsuarios = new ArrayList<Usuario>();
		this.lstPublicaciones = new ArrayList<Publicacion>();
		this.lstComentarios = new ArrayList<Comentario>();
	}

	// CU 1
	public Usuario traerUsuario(String nombreUsuario) {
		boolean encontrado = false;
		Usuario usuarioAux = null;
		int i = 0;

		while ((!encontrado) && (i < lstUsuarios.size())) {
			if (lstUsuarios.get(i).getNombreUsuario().equals(nombreUsuario)) {
				encontrado = true;
				usuarioAux = lstUsuarios.get(i);
			}
			i++;
		}
		return usuarioAux;
	}

	// CU 2
	public boolean agregarUsuario(String nombreUsuario, LocalDate fechaAlta) throws Exception {
		if (traerUsuario(nombreUsuario) != null) {
			throw new Exception("Usuario existente!");
		}
		int id = 1;
		if (lstUsuarios.size() > 0) {
			int tamanio = lstUsuarios.size();
			id = lstUsuarios.get(tamanio - 1).getIdUsuario() + 1;
		}

		return lstUsuarios.add(new Usuario(id, nombreUsuario, fechaAlta));
	}

	// CU 3

	public Publicacion traerPublicacion(String nombreUsuario, LocalDate fecha, LocalTime hora) {
		Publicacion publicacionAux = null;
		boolean encontrada = false;
		int i = 0;
		while ((!encontrada) && (i < lstPublicaciones.size())) {
			if ((lstPublicaciones.get(i).getCreador().getNombreUsuario().equals(nombreUsuario))
					&& (lstPublicaciones.get(i).getFecha().equals(fecha))
					&& (lstPublicaciones.get(i).getHora().equals(hora))) {
				encontrada = true;
				publicacionAux = lstPublicaciones.get(i);
			}
			i++;
		}

		return publicacionAux;
	}

	// CU 4
	public boolean agregarPosteo(LocalDate fecha, LocalTime hora, Usuario creador, String texto, boolean publico)
			throws Exception {
		if ((traerPublicacion(creador.getNombreUsuario(), fecha, hora)) != null) {
			throw new Exception("Publicacion existente");
		}

		return lstPublicaciones.add(new Posteo(calcularIDIncremental(), fecha, hora, creador, texto, publico));
	}

	// CU 5
	public boolean agregarAvisoGeneral(LocalDate fecha, LocalTime hora, Usuario creador, String titulo, String cuerpo)
			throws Exception {
		if ((traerPublicacion(creador.getNombreUsuario(), fecha, hora)) != null) {
			throw new Exception("Publicacion existente");
		}
		return lstPublicaciones.add(new AvisoGeneral(calcularIDIncremental(), fecha, hora, creador, titulo, cuerpo));
	}

	// Util
	public int calcularIDIncremental() {
		int id = 1;
		if (lstPublicaciones.size() > 0) {
			int tamanio = lstPublicaciones.size();
			id = lstPublicaciones.get(tamanio - 1).getIdPublicacion() + 1;
		}

		return id;
	}

	// CU 7
	public boolean agregarComentario(int identificacion, Publicacion publicacion, Usuario usuario, String texto) {
		return lstComentarios.add(new Comentario(calcularIDIncremental(), identificacion, publicacion, usuario, texto));
	}

	// CU 8
	public List<Publicacion> traerPublicacionesPublicas(LocalDate fechaDesde, LocalDate fechaHasta) {
		List<Publicacion> listAux = new ArrayList<Publicacion>();

		for (Publicacion p : lstPublicaciones) {
			if (p instanceof Posteo) {
				if (((Posteo) p).isPublico()
						&& (((p.getFecha().isAfter(fechaDesde)) || (p.getFecha().equals(fechaDesde)))
								&& ((p.getFecha().isBefore(fechaHasta)) || (p.getFecha().equals(fechaHasta))))) {
					listAux.add(p);
				}
			}

		}
		return listAux;
	}

	// CU 9
	public List<Comentario> traerComentariosEnPosteosPorUsuario(Usuario usuario) {
		List<Comentario> ComentarioAux = new ArrayList<Comentario>();
		for (Comentario c : lstComentarios) {
			if (c instanceof Comentario) {
				if (c.getUsuario().equals(usuario)) {
					ComentarioAux.add(c);
				}
			}
		}
		return ComentarioAux;
	}

	// CU 10
	public List<Publicacion> traerComentariosQueContenganTexto(String texto) {
		List<Publicacion> listaAux = new ArrayList<Publicacion>();
		for (Publicacion p : lstPublicaciones) {
			if (p.contieneTexto(texto)) {
				listaAux.add(p);
			}
		}
		return listaAux;
	}

	public List<Usuario> getLstUsuarios() {
		return lstUsuarios;
	}

	public void setLstUsuarios(List<Usuario> lstUsuarios) {
		this.lstUsuarios = lstUsuarios;
	}

	public List<Publicacion> getLstPublicaciones() {
		return lstPublicaciones;
	}

	public void setLstPublicaciones(List<Publicacion> lstPublicaciones) {
		this.lstPublicaciones = lstPublicaciones;
	}

	public List<Comentario> getLstComentarios() {
		return lstComentarios;
	}

	public void setLstComentarios(List<Comentario> lstComentarios) {
		this.lstComentarios = lstComentarios;
	}

	@Override
	public String toString() {
		return "Sistema [lstUsuarios=" + lstUsuarios + ", lstPublicaciones=" + lstPublicaciones + ", lstComentarios="
				+ lstComentarios + "]";
	}

}
