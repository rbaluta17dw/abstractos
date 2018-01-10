package Festival;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Festival {
	private String nombre;
	private String patrocinador;
	private ArrayList<Actuacion> actuaciones;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPatrocinador() {
		return patrocinador;
	}

	public void setPatrocinador(String patrocinador) {
		this.patrocinador = patrocinador;
	}

	public ArrayList<Actuacion> getActuaciones() {
		return actuaciones;
	}

	public void setActuaciones(ArrayList<Actuacion> actuaciones) {
		this.actuaciones = actuaciones;
	}

	public void addActuacion(Actuacion actuacion) {
		this.actuaciones.add(actuacion);
	}

	public void addActuacion(String nombre, int duracion) {
		Actuacion a = new Actuacion();
		a.setNombreGrupo(nombre);
		a.setDuracion(duracion);

		this.actuaciones.add(a);
	}

	public void removeActuacion() {
		Scanner scan = new Scanner(System.in);
		System.out.println("¿Que grupo quieres eliminar?");
		String grupo = scan.nextLine();
		Iterator<Actuacion> i = actuaciones.iterator();
		while (i.hasNext()) {
			Actuacion a = i.next();
			if (a.getNombreGrupo().equals(grupo)) {
				i.remove();
				System.out.println(a.getNombreGrupo() + " ha sido eliminado");
			}
		}
	}

	public void cambiarDuracionActuacion(String nombre_grupo, int duracion) {
		for (int i = 0; i < this.actuaciones.size(); i++) {
			if (this.actuaciones.get(i).getNombreGrupo().equals(nombre_grupo)) {
				Actuacion a = this.actuaciones.get(i);
				a.setDuracion(duracion);
				this.actuaciones.set(i, a);
			}
		}
		System.out.println("La actuacion de " + nombre_grupo + " ha sido modificada");
	}

	public void duracionFestival() {
		int duracionTotal = 0;
		for (int i = 0; i < this.actuaciones.size(); i++) {
			Actuacion a = actuaciones.get(i);
			duracionTotal = duracionTotal + a.getDuracion();
		}
		System.out.println(duracionTotal + " minutos de musica!");
	}

	public void mostrarInfo() {
		System.out.println(getNombre());
		System.out.println("-----------------");
		System.out.println("Patrocinado por: " + getPatrocinador());
		Iterator<Actuacion> i = actuaciones.iterator();
		if (i.hasNext()) {
			while (i.hasNext()) {
				String infoActuacion = i.next().getInfo();
				System.out.println(infoActuacion);
			}
		} else {
			System.out.println("No hay actuaciones");
		}

		duracionFestival();
	}

	public static void eliminarActuacion(String nombreGrupo, ArrayList<Actuacion> actuaciones) {
		Iterator<Actuacion> i = actuaciones.iterator();
		while (i.hasNext()) {
			Actuacion a = i.next();
			if (a.getNombreGrupo().equals(nombreGrupo)) {
				i.remove();
				System.out.println(a.getNombreGrupo() + " eliminado");
			}
		}

	}

	public static ArrayList<Actuacion> crearLista(String nombreFichero) {
		ArrayList<Actuacion> lista = new ArrayList<Actuacion>();

		File file = new File(nombreFichero);
		try {
			Scanner scan = new Scanner(file);

			// por cada linea del texto añade una persona a la lista
			while (scan.hasNext()) {
				String linea = scan.nextLine();
				String[] partes = linea.split(":");

				Actuacion actuacion = new Actuacion();
				actuacion.setNombreGrupo(partes[0]);
				actuacion.setDuracion(Integer.parseInt(partes[1]));
				lista.add(actuacion);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return lista;
	}

	public static void guardarLista(ArrayList<Actuacion> actuaciones, String nombreFichero) {

		FileWriter fileWriter = null;

		try {
			fileWriter = new FileWriter(nombreFichero);

			PrintWriter printWriter = new PrintWriter(fileWriter);

			Iterator<Actuacion> it = actuaciones.iterator();
			while (it.hasNext()) {
				Actuacion actuacion = it.next();
				printWriter.println(actuacion.getInfo());
			}
			fileWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
