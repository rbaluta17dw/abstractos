package futbol;

import java.util.ArrayList;
import java.util.Scanner;

public class MainPartido {

	public static void main(String[] args) {
		ArrayList<PartidoFutbol> partidos = new ArrayList<PartidoFutbol>();
		final int CREAR = 1;
		final int LEER = 2;
		final int ACTUALIZAR = 3;
		final int BORRAR = 4;
		final int SALIR = 0;
		int opcion;
		
		String fichero = "D:/Robert_Baluta/2. Evaluacion/archivos/partidos.txt";
		PartidoFutbol.crearLista(fichero, partidos);

		Scanner scan = new Scanner(System.in);

		do {
			System.out.println("-----MENU-----");
			System.out.println(CREAR + " Añadir un partido a la lista");
			System.out.println(LEER + " Leer la lista de los partidos");
			System.out.println(ACTUALIZAR + " Cambiar el marcador de un equipo");
			System.out.println(BORRAR + " Borrar un partido de la lista");
			System.out.println(SALIR + " Salir del menu");

			opcion = Integer.parseInt(scan.nextLine());

			switch (opcion) {

			case CREAR:
				System.out.println("Nombre del equipo local");
				String local = scan.nextLine();
				System.out.println("Numero de goles marcado por el equipo");
				int golesLocal = Integer.parseInt(scan.nextLine());
				System.out.println("Nombre del equipo visitante");
				String visitante = scan.nextLine();
				System.out.println("Numero de goles marcados por el equipo visitante");
				int golesVisitante = Integer.parseInt(scan.nextLine());
				PartidoFutbol partido = new PartidoFutbol(local, visitante, golesLocal, golesVisitante);
				partidos.add(partido);
				System.out.println("Guardando lista...");
				PartidoFutbol.guardarLista(partidos, fichero);
				break;
			case LEER:
				PartidoFutbol.mostrarInfo(partidos);

				break;
			case ACTUALIZAR:
				System.out.println("Nombre del equipo al que quieres modificar el marcador");
				String nombre_equipo = scan.nextLine();
				System.out.println("¿Cual es el marcador?");
				int goles = Integer.parseInt(scan.nextLine());
				PartidoFutbol.cambiarMarcador(nombre_equipo, goles, partidos);
				break;
			case BORRAR:
				System.out.println("Nombre del equipo del que quieres borrar el partido");
				String nombreEquipo = scan.nextLine();
				PartidoFutbol.eliminarPartido(nombreEquipo, partidos);
				System.out.println("Guardando lista...");
				PartidoFutbol.guardarLista(partidos, fichero);
				break;
			case SALIR:
				System.out.println("Saliendo...");
				break;
			default:
				System.out.println("Opcion mal");
				break;
			}

		} while (opcion != 0);
	}

}
