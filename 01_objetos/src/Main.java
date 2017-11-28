import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Persona persona = new Persona();

		final int COMER = 1;
		final int CORRER = 2;
		final int DORMIR = 3;
		final int TRABAJAR = 4;
		final int INFO = 5;
		final int SALIR = 0;
		int opcion;
		int acciones = 10;
		int token_comida = 0;
		int token_correr = 0;
		boolean checker = false;
		boolean descansado = false;
		int hambre = 0;

		Scanner scan = new Scanner(System.in);
		System.out.println("¿Como se va a llamar tu avatar?");
		String nombre = scan.nextLine();
		persona.setNombre(nombre);
		System.out.println("¿Como se va a apellidar tu avatar?");
		String apellido = scan.nextLine();
		persona.setApellido(apellido);
		System.out.println("Tu avatar se llama " + persona.getNombre() + " " + persona.getApellido());
		persona.setPeso(Math.random() * 60 + 40);
		System.out.println(persona.getNombre() + " pesa " + (Math.round(persona.getPeso() * 100d) / 100d) + " KG");
		System.out.println("¿Cuantos años tiene " + persona.getNombre() + "?");
		int edad = Integer.parseInt(scan.nextLine());
		persona.setEdad(edad);
		System.out.println(persona.getNombre() + " tiene " + persona.getEdad() + " años");
		do {
			System.out.println("¿Cual es el numero de telefono de " + persona.getNombre() + "?");
			String telefono = scan.nextLine();
			if (telefono.length() == 9) {
				persona.setTelefono(telefono);
				checker = true;
			} else {
				System.out.println("El numero introducido no es correcto");
			}
		} while (checker == false);

		do {
			System.out.println("Cual es el DNI de " + persona.getNombre() + "?");
			String DNI = scan.nextLine();
			if (DNI.length() == 9) {
				persona.setDNI(DNI);
				checker = true;
			} else {
				System.out.println("El DNI introducido no es correcto");
				checker = false;
			}
		} while (checker == false);

		do {
			if (acciones < 1) {
				System.out.println(persona.getNombre() + "ha muerto, que descanse en paz");
			} else {
				for (int i = 0; i < acciones; i++) {
					System.out.println("Turno numero " + i + " te quedan " + (acciones - i) + " turnos");
					System.out.println("---------MENU---------\n" + COMER + "- Comer\n" + CORRER + "- Correr\n" + DORMIR
							+ "- Dormir (Se ha de hacer en en ultimo turno)\n" + INFO
							+ "- Informacion sobre le personaje\n" + SALIR + "- Salir");
					opcion = Integer.parseInt(scan.nextLine());
					switch (opcion) {
					case COMER:
						if (token_comida < 3) {
							persona.comer();
							token_comida = token_comida + 1;
							hambre = hambre - 3;
						} else {
							System.out.println(persona.getNombre() + " no puede comer mas");
							i = i--;
							hambre = hambre - 1;
						}
						break;
					case CORRER:
						if (token_correr < 2) {
							persona.correr();
							token_correr = token_correr + 1;
						} else {
							System.out.println(persona.getNombre() + " no puede correr mas");
							i = i - 1;
							hambre = hambre - 1;
						}

						break;
					case DORMIR:
						if (i == acciones - 1) {
							persona.dormir();
							descansado = true;
						} else {
							System.out.println("Aun no se puede dormir");
							i = i - 1;
							hambre = hambre - 1;
						}
						break;
					case TRABAJAR:
						if (persona.getTrabajo().equals(null)) {
							System.out.println("¿" + persona.getNombre() + " no tiene trabajo, quieres buscar uno?");
						}

						break;
					case INFO:
						System.out.println("Nombre\n" + persona.getNombre());
						System.out.println("Apellido\n" + persona.getApellido());
						System.out.println("Edad\n" + persona.getEdad());
						System.out.println("Peso\n" + (Math.round(persona.getPeso() * 100d) / 100d) + " KG");
						i = i - 1;
						hambre = hambre - 1;
						break;
					case SALIR:
						System.exit(1);
						break;
					default:
						System.out.println("Opcion invalida");
						break;
					}
					hambre = hambre++;
					if (hambre == 3) {
						System.out.println(persona.getNombre() + " tiene hambre, dale de comer.");
					} else if (hambre == 5) {
						System.out.println(persona.getNombre() + " tienes mucha hamre");
					} else if (hambre == 6) {
						System.out.println(persona.getNombre() + " ha muerto, que descanse en paz");
					}
				}
				System.out.println("Has acabado tus acciones");
				if (descansado) {
					System.out.println("Has descansado");
					descansado = false;
				} else {
					System.out.println("No has descansado y por tanto tienes menos acciones");
					acciones = acciones - 2;
				}
			}
		} while (1 == 1);
	}
}
