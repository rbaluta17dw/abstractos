import java.util.Date;

public class Persona {
	// atributos private
	private String nombre;
	private String apellido;
	private int edad;
	private double peso;
	private String trabajo;
	private double dinero;
	Date Fecha_Nacimiento = new Date(1998 / 12 / 6);

	// metodos public
	public void trabajar() {
		System.out.println("Ya he trabajado");
	}

	public void comer() {
		System.out.println("He comido");
		cambiarPeso(Math.random() * 2);
	}

	public void comprar() {
		System.out.println("He comprado");
	}

	public void correr() {
		System.out.println("He terminado de correr");
		cambiarPeso(-Math.random() * 2);
	}

	public void dormir() {
		System.out.println("Ya desperté");
	}

	public void cumplirAnos() {
		System.out.println("Feliz cumpleaños");

	}

	/*
	 * @param peso en cuanto se va a cambiar el peso
	 */
	public void cambiarPeso(double cambioPeso) {
		peso = peso + cambioPeso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public double getPeso() {
		return peso;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public int getEdad() {
		return edad;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getTrabajo() {
		return trabajo;
	}

	public void setTrabajo(String trabajo) {
		this.trabajo = trabajo;
	}

	public double getDinero() {
		return dinero;
	}

	public void setDinero(double dinero) {
		this.dinero = dinero;
	}

}
