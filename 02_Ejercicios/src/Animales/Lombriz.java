package Animales;

public class Lombriz extends Animal {
	private double longitud;
	boolean bajoTierra;

	/**
	 * @param longitud (cm)
	 */
	public Lombriz(double longitud) {
		super("Lombriz", 0);
		this.longitud = longitud;
		this.bajoTierra = false;
	}
	
	/* (non-Javadoc)
	 * @see Animales.Animal#mostrar()
	 */
	public void mostrar(){
		super.mostrar();
		System.out.print("mido " + getLongitud() + " cm y ");
		if (bajoTierra){
			System.out.print("estoy bajo tierra");
		}else{
			System.out.print("estoy en la superficie");
		}
	}
	/**
	 * @return longitud
	 */
	public double getLongitud() {
		return longitud;
	}

	/**
	 * @param longitud
	 * 
	 */
	public void setLongitud(int longitud) {
		this.longitud = longitud;
	}

	/**
	 * @return esta bajo tierra
	 */
	public boolean isBajoTierra() {
		return bajoTierra;
	}

	/**
	 * @param bajoTierra
	 */
	public void setBajoTierra(boolean bajoTierra) {
		this.bajoTierra = bajoTierra;
	}

}
