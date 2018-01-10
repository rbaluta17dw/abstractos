package Vehiculos;

public class Coche extends Vehiculo {
	private String marca;

	public Coche(String tipo, boolean enMarcha, String marca) {
		super(tipo, 4, enMarcha);
		this.marca = marca;
	}

	public Coche() {

	}
	
	public void mostrarInfo(){
		super.mostrarInfo();
		System.out.print(", " + getMarca() + " es la marca del coche");
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

}
