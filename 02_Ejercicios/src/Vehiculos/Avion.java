package Vehiculos;

public class Avion extends Vehiculo {
	private boolean volando;

	public Avion(int ruedas, boolean enMarcha, boolean volando, String marca) {
		super("avion", ruedas, enMarcha);
		this.volando = volando;
	}

	public Avion() {

	}

	public void mostrarInfo() {
		super.mostrarInfo();
		if (volando) {
			System.out.println("el avion esta volando");
		} else {
			System.out.println("el avion no esta volando");
		}
	}

	public boolean isVolando() {
		return volando;
	}

	public void setVolando(boolean volando) {
		this.volando = volando;
	}

}
