package futbol;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import Festival.Actuacion;

public class PartidoFutbol {
	private String visitante;
	private String local;
	private int golesLocal;
	private int golesVisitante;

	PartidoFutbol() {

	}

	PartidoFutbol(String local, String visitante, int golesLocal, int golesVisitante) {
		this.local = local;
		this.visitante = visitante;
		this.golesLocal = golesLocal;
		this.golesVisitante = golesVisitante;
	}

	public String getVisitante() {
		return visitante;
	}

	public void setVisitante(String visitante) {
		this.visitante = visitante;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public int getGolesVisitante() {
		return golesVisitante;
	}

	public void setGolesVisitante(int golesVisitante) {
		this.golesVisitante = golesVisitante;
	}

	public int getGolesLocal() {
		return golesLocal;
	}

	public void setGolesLocal(int golesLocal) {
		this.golesLocal = golesLocal;
	}

	public static ArrayList<PartidoFutbol> crearLista(String nombreFichero, ArrayList<PartidoFutbol> lista) {
		File file = new File(nombreFichero);
		try {
			Scanner scan = new Scanner(file);

			// por cada linea del texto añade una persona a la lista
			while (scan.hasNext()) {
				String linea = scan.nextLine();
				String[] partes = linea.split(":");

				PartidoFutbol partido = new PartidoFutbol();
				partido.setLocal(partes[0]);
				partido.setGolesLocal(Integer.parseInt(partes[1]));
				partido.setVisitante(partes[2]);
				partido.setGolesVisitante(Integer.parseInt(partes[3]));
				lista.add(partido);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return lista;
	}

	public static void mostrarInfo(ArrayList<PartidoFutbol> partidos) {
		Iterator<PartidoFutbol> i = partidos.iterator();
		if (i.hasNext()) {
			while (i.hasNext()) {
				String infoPartido = i.next().showInfo();
				System.out.println(infoPartido);
			}
		} else {
			System.out.println("No hay partidos");
		}
	}

	private String getInfo() {
		String info = local + ":" + golesLocal + ":" + visitante + ":" + golesVisitante;
		return info;
	}
	
	private String showInfo(){
		String info = local + " " + golesLocal + ":" + visitante + " " + golesVisitante;
		return info;
	}

	public static void cambiarMarcador(String nombre_equipo, int goles, ArrayList<PartidoFutbol> partidos) {
		for (int i = 0; i < partidos.size(); i++) {
			if (partidos.get(i).getLocal().equals(nombre_equipo)) {
				PartidoFutbol a = partidos.get(i);
				a.setGolesLocal(goles);
				partidos.set(i, a);
			}
		}
		for (int i = 0; i < partidos.size(); i++) {
			if (partidos.get(i).getVisitante().equals(nombre_equipo)) {
				PartidoFutbol a = partidos.get(i);
				a.setGolesVisitante(goles);
				partidos.set(i, a);
			}
		}
		System.out.println("El marcador de " + nombre_equipo + " ha sido modificado");
	}

	public static void eliminarPartido(String nombreEquipo, ArrayList<PartidoFutbol> partidos) {
		Iterator<PartidoFutbol> i = partidos.iterator();
		while (i.hasNext()) {
			PartidoFutbol a = i.next();
			if (a.getLocal().equals(nombreEquipo)) {
				i.remove();
				System.out.println("el partido de " + a.getLocal() + " ha sido eliminado");
			} else if (a.getLocal().equals(nombreEquipo)) {
				i.remove();
				System.out.println("el partido de " + a.getLocal() + " ha sido eliminado");
			}
		}

	}

	public static void guardarLista(ArrayList<PartidoFutbol> partidos, String nombreFichero) {

		FileWriter fileWriter = null;

		try {
			fileWriter = new FileWriter(nombreFichero);

			PrintWriter printWriter = new PrintWriter(fileWriter);

			Iterator<PartidoFutbol> it = partidos.iterator();
			while (it.hasNext()) {
				PartidoFutbol partido = it.next();
				printWriter.println(partido.getInfo());
			}
			fileWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
