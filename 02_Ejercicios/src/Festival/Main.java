package Festival;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// Vamos a crear una actuacion por programacion

		Actuacion a1 = new Actuacion();
		a1.setNombreGrupo("AC/DC");
		a1.setDuracion(90);

		// crear una actuacion por inputs del teclado

		Actuacion a2 = new Actuacion();
		Scanner scan = new Scanner(System.in);
		System.out.println("Nombre del grupo que va a actuar");
		a2.setNombreGrupo(scan.nextLine());
		System.out.println("Duracion de la actuacion");
		a2.setDuracion(scan.nextInt());

		// crear una actuacion por archivo de texto

		String[] partesActuacion;
		String linea;
		Actuacion a3 = new Actuacion();
		File fichero = new File("D:/Robert_Baluta/2. Evaluacion/archivos/actuaciones.txt");
		Scanner scanf;
		try {
			scanf = new Scanner(fichero);
			while (scanf.hasNextLine()) {
				linea = scanf.nextLine();
				partesActuacion = linea.split(":");
				a3.setNombreGrupo(partesActuacion[0]);
				a3.setDuracion(Integer.parseInt(partesActuacion[1]));
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// crear un festival con 3 actuaciones

		Festival f1 = new Festival();
		f1.setNombre("Formula 1");
		f1.setPatrocinador("Ferrari");
		ArrayList<Actuacion> listaActuaciones = new ArrayList();
		listaActuaciones.add(a1);
		listaActuaciones.add(a2);
		listaActuaciones.add(a3);
		f1.setActuaciones(listaActuaciones);
		
		Actuacion a4 = new Actuacion();
		a4.setNombreGrupo("Jimmy Hendrix");
		a4.setDuracion(30);
		f1.addActuacion(a4);
		f1.addActuacion("Disturbed", 50);
		f1.addActuacion("El reno renardo", 100);
		
		
		f1.mostrarInfo();
		
	}

}
