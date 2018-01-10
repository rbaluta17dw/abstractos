package Festival;

import java.util.ArrayList;
import java.util.Scanner;

public class MainFestival {

	public static void main(String[] args) {
		final int CREAR = 1;
		final int LEER = 2;
		final int ACTUALIZAR = 3;
		final int BORRAR = 4;
		final int SALIR = 0;
		int opcion;

		Festival festival = new Festival();
		festival.setNombre("Navifest");
		festival.setPatrocinador("Coca-Cola");
		festival.setActuaciones(Festival.crearLista("D:/Robert_Baluta/2. Evaluacion/archivos/festival.txt"));

		Scanner scan = new Scanner(System.in);
		do {
			System.out.println("--------MENU--------");
			System.out.println(CREAR + "- Agregar una actuacion al festival");
			System.out.println(LEER + "- Listar la informacion del festival");
			System.out.println(ACTUALIZAR + "- Cambiar la duracion de alguna actuacion");
			System.out.println(BORRAR + "- Eliminar una actuacion del festival");
			System.out.println(SALIR + "- Salir");
			

			opcion = Integer.parseInt(scan.nextLine());

			switch (opcion) {
			case CREAR:
				System.out.println("¿Nombre del grupo?");
				String nombreGrupo = scan.nextLine();
				System.out.println("¿Duracion de la actuacion?");
				int duracion = Integer.parseInt(scan.nextLine());

				Actuacion actuacion = new Actuacion();
				actuacion.setNombreGrupo(nombreGrupo);
				actuacion.setDuracion(duracion);
				festival.addActuacion(actuacion);

				break;
			case LEER:
				festival.mostrarInfo();
				break;
			case ACTUALIZAR:
				System.out.println("Nombre del grupo que quieres modificar");
				nombreGrupo = scan.nextLine();
				System.out.println("¿Duracion de la actuacion?");
				duracion = Integer.parseInt(scan.nextLine());
				festival.cambiarDuracionActuacion(nombreGrupo, duracion);
				break;
			case BORRAR:
				System.out.println("Nombre del grupo que quieres eliminar");
				nombreGrupo = scan.nextLine();
				ArrayList<Actuacion> actuaciones = festival.getActuaciones();
				Festival.eliminarActuacion(nombreGrupo, actuaciones);
				break;
			case SALIR:
				System.out.println("Saliendo...");
				Festival.guardarLista(festival.getActuaciones(), ("D:/Robert_Baluta/2. Evaluacion/archivos/festival.txt"));
				break;
			default:
				System.out.println("Error... Opcion mal");
				break;
			}

		} while (opcion != SALIR);

	}

}
