package test;

import java.time.LocalDate;
import java.time.LocalTime;
import modelo.Sistema;

public class Test {

	public static void main(String[] args) {
		Sistema s = new Sistema();

		// Agregar los siguientes Usuarios e imprimir la lista de Usuarios
		System.out.println("\n------Test 1------");
		try {
			s.agregarUsuario("usuarioCreador1", LocalDate.of(2023, 9, 1));
			s.agregarUsuario("usuarioCreador2", LocalDate.of(2023, 9, 2));
			s.agregarUsuario("usuarioCreador3", LocalDate.of(2023, 9, 3));
			s.agregarUsuario("usuarioCreador4", LocalDate.of(2023, 9, 4));
			s.agregarUsuario("usuarioCreador5", LocalDate.of(2023, 9, 5));
			s.agregarUsuario("usuarioLector1", LocalDate.of(2023, 9, 6));
			s.agregarUsuario("usuarioLector2", LocalDate.of(2023, 9, 7));
			s.agregarUsuario("usuarioLector3", LocalDate.of(2023, 9, 8));
			System.out.println(s.getLstUsuarios());
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Agregar las siguientes Publicaciones e Imprimir la lista de Publicaciones
		System.out.println("\n------Test 2------");
		try {
			s.agregarPosteo(LocalDate.of(2023, 10, 1), LocalTime.of(10, 0), s.traerUsuario("usuarioCreador1"),
					"Que dia es el segundo parcial de OO1?", true);
			s.agregarPosteo(LocalDate.of(2023, 10, 5), LocalTime.of(11, 0), s.traerUsuario("usuarioCreador2"),
					"Comenten de que pais me estan leyendo", true);
			s.agregarPosteo(LocalDate.of(2023, 10, 10), LocalTime.of(12, 0), s.traerUsuario("usuarioCreador3"),
					"Hoy nos reunimos en mi casa!", false);
			s.agregarAvisoGeneral(LocalDate.of(2023, 10, 15), LocalTime.of(13, 0), s.traerUsuario("usuarioCreador4"),
					"Alerta para vecinos de Lanus", "Anuncian fuertes llvias para las 18hs");
			s.agregarAvisoGeneral(LocalDate.of(2023, 10, 20), LocalTime.of(14, 0), s.traerUsuario("usuarioCreador5"),
					"Informacion Importante", "La facultad permanecera abierta hasta las 20hs");

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(s.getLstPublicaciones());

		// Agregar los siguientes Comentarios e imprimir la lista de Comentarios
		System.out.println("\n------Test 3------");

		s.agregarComentario(111, s.traerPublicacion("usuarioCreador2", LocalDate.of(2023, 10, 5), LocalTime.of(11, 0)),
				s.traerUsuario("usuarioLector2"), "Uruguay");
		s.agregarComentario(222, s.traerPublicacion("usuarioCreador2", LocalDate.of(2023, 10, 5), LocalTime.of(11, 0)),
				s.traerUsuario("usuarioLector3"), "Chile");
		s.agregarComentario(333, s.traerPublicacion("usuarioCreador1", LocalDate.of(2023, 10, 1), LocalTime.of(10, 0)),
				s.traerUsuario("usuarioLector1"), "No recuerdo");
		s.agregarComentario(444, s.traerPublicacion("usuarioCreador1", LocalDate.of(2023, 10, 1), LocalTime.of(10, 0)),
				s.traerUsuario("usuarioLector2"), "Es el Martes 17/10/2023");
		System.out.println(s.getLstComentarios());

		// Traer e imprimir todas las publicaciones públicas entre las fechas 2023-10-05
		// y 2023-10-17
		System.out.println("\n------Test 4------");
		System.out.println(s.traerPublicacionesPublicas(LocalDate.of(2023, 10, 5), LocalDate.of(2023, 10, 17)));

		// Traer e imprimir todos los comentarios del "UsuarioLector2" en posteos
		System.out.println("\n------Test 5------");
		System.out.println(s.traerComentariosEnPosteosPorUsuario(s.traerUsuario("usuarioLector2")));

		// Traer e imprimir todas las Publicaciones que contengan el texto "de"
		System.out.println("------Test 6------");
		System.out.println(s.traerComentariosQueContenganTexto("de"));

		// Intentar agregar nuevamente al siguiente Usuario
		System.out.println("\n------Test 7------");
		try {
			s.agregarUsuario("usuarioCreador1", LocalDate.of(2023, 9, 1));
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Intentar agregar nuevamente la siguiente Publicación
		System.out.println("\n------Test 8------");
		try {
			s.agregarPosteo(LocalDate.of(2023, 10, 1), LocalTime.of(10, 0), s.traerUsuario("usuarioCreador1"),
					"Que dia es el segundo parcial de OO1?", true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
