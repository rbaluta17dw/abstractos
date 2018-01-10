package Vehiculos;

public class Main {

	public static void main(String[] args) {
		Vehiculo Gustav = new Vehiculo();
		Gustav.setRuedas(100);
		Gustav.setTipo("Cañon sobre railes");
		Gustav.setEnMarcha(true);
		Gustav.mostrarInfo();
		
		Vehiculo Lazzara = new Vehiculo("barco", 0, false);
		Lazzara.mostrarInfo();
		
		Coche Fiesta = new Coche();
		Fiesta.setTipo("Deportivo");
		Fiesta.setMarca("Ford");
		Fiesta.setRuedas(4);
		Fiesta.setEnMarcha(true);
		Fiesta.mostrarInfo();
		
		Coche Clio = new Coche("urbano", false, "Renault");
		Clio.mostrarInfo();
		
		Avion F14 = new Avion();
		F14.setEnMarcha(false);
		F14.setRuedas(4);
		F14.setTipo("Caza");
		F14.setVolando(false);
		F14.mostrarInfo();
		
	}

}
