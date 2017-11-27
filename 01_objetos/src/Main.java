import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Persona persona = new Persona();

		final int COMER = 1;
		final int CORRER = 2;
		final int DORMIR = 3;
		final int INFO = 4;
		final int SALIR = 0;
		int opcion;
		int acciones = 10;
		int token_comida = 0;
		int token_correr = 0;

		Scanner scan = new Scanner(System.in);
		System.out.println("¿Como se va a llamar tu avatar?");
		String nombre = scan.nextLine();
		persona.setNombre(nombre);
		System.out.println("¿Como se va a apellidar tu avatar?");
		String apellido = scan.nextLine();
		persona.setApellido(apellido);
		System.out.println("Tu avatar se llama " + persona.getNombre() + " " + persona.getApellido());
		persona.setPeso(Math.random() * 70 + 40);
		System.out.println(persona.getNombre() + " pesa " + (Math.round(persona.getPeso() * 100d) / 100d) + " KG");
		System.out.println("¿Cuantos años tiene " + persona.getNombre() + "?");
		int edad = Integer.parseInt(scan.nextLine());
		persona.setEdad(edad);
		System.out.println(persona.getNombre() + " tiene " + persona.getEdad() + " años");

		do {
			for (int i = 0; i < acciones; i++) {
				System.out.println("Turno numero " + i + " te quedan " + (acciones - i) + " turnos");
				System.out.println("---------MENU---------\n" + COMER + "- Comer\n" + CORRER + "- Correr\n" + DORMIR
						+ "- Dormir\n" + INFO + "- Informacion sobre le personaje\n" + SALIR + "- Salir");
				opcion = Integer.parseInt(scan.nextLine());
				switch (opcion) {
				case COMER:
					if (token_comida < 3) {
						persona.comer();
						token_comida = token_comida++;
					} else {
						System.out.println(persona.getNombre() + " no puede comer mas");
						i = i - 1;
					}
					break;
				case CORRER:
					if (token_correr < 2) {
						persona.correr();
						token_correr = token_correr++;
					} else {
						System.out.println(persona.getNombre() + " no puede correr mas");
						i = i - 1;
					}

					break;
				case DORMIR:
					if (i == acciones - 1) {
						persona.dormir();
					} else {
						System.out.println("Aun no se puede dormir");
						i = i - 1;
					}
					break;
				case INFO:
					System.out.println("Nombre\n" + persona.getNombre());
					System.out.println("Apellido\n" + persona.getApellido());
					System.out.println("Edad\n" + persona.getEdad());
					System.out.println("Peso\n" + (Math.round(persona.getPeso() * 100d) / 100d) + " KG");
					i = i - 1;
					break;
				case SALIR:

					break;
				default:
					System.out.println("Opcion invalida");
					break;
				}
			}
			System.out.println("Has acabado tus acciones");
		} while (1 == 1);
	}
}
