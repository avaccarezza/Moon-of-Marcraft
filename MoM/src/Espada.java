
public class Espada extends Arma {

	public Espada(String nombre, int danio_base) {
		super(nombre, danio_base);
	}

	public int ataque(){
		return danio_base;
	}

	@Override
	public void equiparMunicion(Flecha flecha) {

	}


}
