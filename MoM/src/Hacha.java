import java.util.Random;

public class Hacha extends Arma {

private float porc_golpe_critico;
private Random rnd = new Random();



	public Hacha(String nombre, int danio_base, float porc_golpe_critico) {
		super(nombre, danio_base);
		this.porc_golpe_critico = porc_golpe_critico;
	}

	public double getPorc_golpe_critico() {
		return porc_golpe_critico;
	}

	public int ataque(){
			if(golpeCritico())
			{
				System.out.println("CRITICAL ATTACK");
				return danio_base * 2;
			}
			else{
				return danio_base;
			}

	}

	@Override
	public void equiparMunicion(Flecha flecha) {

	}

	private boolean golpeCritico()
	{
		int num = rnd.nextInt(100);
		if(num >= porc_golpe_critico)
		{
			return false;
		}else{
			return true;
		}
	}

	
}
