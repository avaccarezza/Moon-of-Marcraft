
public class Comida extends Item {

	private int curacion;
	private int cant_usos;
	
	public Comida(String nombre, int curacion, int cant_usos) {
		super(nombre);
		this.curacion = curacion;
		this.cant_usos = cant_usos;
	}

	public int getCuracion() {
		return curacion;
	}

	public void setCant_usos(int cant_usos) {
		this.cant_usos = cant_usos;
	}

	public int getCant_usos() {
		return cant_usos;
	}
}
