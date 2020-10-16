import java.util.ArrayList;

public class Arco extends Arma{


	private Flecha flecha;
	private int cantFlechas;

	public Arco(String nombre, int danio_base)
	{
		super(nombre, danio_base);
		this.flecha = null;
		this.cantFlechas = 0;
	}

	public void getCantFlechas() {
		System.out.println( cantFlechas);
	}

	public int ataque() {

		int danio_arco = 0;

		if (hayFlecha()) {
			restarFlechaStock();
			danio_arco = this.danio_base + this.flecha.getDanio();
		}else{
			System.err.println("No puedes atacar con el arco sin equipar flechas");
		}
			return danio_arco;
	}

	@Override
	public void equiparMunicion( Flecha flecha) {
		this.flecha = flecha;
		this.cantFlechas = cantFlechas + flecha.getStock();
		System.out.println("Equipaste: " + flecha.getStock());
	}

	private boolean hayFlecha()
	{
		if (this.cantFlechas > 0)
		{
			return true;
		}
			return false;
	}

	public void restarFlechaStock() {
		this.cantFlechas-- ;
	}
}

