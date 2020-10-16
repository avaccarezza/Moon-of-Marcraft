import java.util.ArrayList;

public abstract class Arma extends Item {

	protected int danio_base;
	
	public Arma(String nombre, int danio_base) {
		super(nombre);
		this.danio_base = danio_base;
	}


	public abstract int ataque();


	public abstract void equiparMunicion(Flecha flecha);
	
}
