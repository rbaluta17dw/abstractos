package Festival;

public class Actuacion {
	private String nombreGrupo;
	private int duracion;

	public String getNombreGrupo() {
		return nombreGrupo;
	}

	public void setNombreGrupo(String nombreGrupo) {
		this.nombreGrupo = nombreGrupo;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public String getInfo() {
		String info = this.getNombreGrupo() + " : " + this.getDuracion();

		return info;
	}
}
