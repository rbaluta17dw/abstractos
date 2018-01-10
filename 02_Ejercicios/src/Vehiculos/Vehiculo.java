package Vehiculos;

public class Vehiculo {
	private String tipo;
	private int ruedas;
	private boolean enMarcha;

	public void mostrarInfo() {
		System.out.println("\nEl vehiculo es de tipo " + getTipo() + " tiene " + getRuedas() + " ruedas y ");
		if (enMarcha){
			System.out.print("esta en marcha");
		}else{
			System.out.print("no esta en marcha");
		}
	}

	public Vehiculo(String tipo, int ruedas, boolean enMarcha) {
		super();
		this.tipo = tipo;
		this.ruedas = ruedas;
		this.enMarcha = enMarcha;
	}
	
	public Vehiculo(){
		
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getRuedas() {
		return ruedas;
	}

	public void setRuedas(int ruedas) {
		this.ruedas = ruedas;
	}

	public boolean isEnMarcha() {
		return enMarcha;
	}

	public void setEnMarcha(boolean enMarcha) {
		this.enMarcha = enMarcha;
	}

}
