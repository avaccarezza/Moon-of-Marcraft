import java.util.ArrayList;

public class Personaje {

	private static final int MAX_VIDA = 100;
	private static final int MIN_VIDA = 0;
	private String nombre;
	private int vida;
	private Inventario inventario;
	private Equipamiento equipamiento;
	private EstadoSalud estadoSalud;
	private EstadoEspecial estadoEspecial;
	private ArrayList<Observador> misiones;

	
	public Personaje(String nombre)
	{
		this.nombre = nombre;
		this.vida = 100;
		this.inventario = null;
		this.equipamiento = null;
		this.estadoSalud = EstadoSalud.VIVO;
		this.estadoEspecial = EstadoEspecial.NORMAL;
		this.misiones = new ArrayList<>();
	}

	public ArrayList<Observador> getMisiones() {
		return misiones;
	}

	public void agregarInventario(Inventario inventario){
		this.inventario = inventario;
}

	public void agregarEquipamiento(Equipamiento equipamiento){
		this.equipamiento = equipamiento;
}



		public void consumir(Comida comida){
		int aumentaVida = comida.getCuracion();
		int cantUsos = comida.getCant_usos();
			if(cantUsos > 0 && tengoEnInventario(comida)){
				vida = vida + aumentaVida;
				maxAumentoVida();
				cantUsos--;
				comida.setCant_usos(cantUsos);
				System.out.println("Tienes " + cantUsos + " usos restantes de "+comida.getNombre());
			}else{
				System.err.println("No tienes " + comida.getNombre() + " en el inventario");
			}
			chequearCantUsos(comida);
		}
		private void chequearCantUsos(Comida c){
			if (c.getCant_usos() == 0){
				this.inventario.sacarItemDelInventario(c);
			}
		}
		private boolean tengoEnInventario(Comida comida){
			for (Item it: this.inventario.getInventario()) {
				if(it.getNombre().equals(comida.getNombre())){
					return true;
				}
			}
			return false;
		}
		private void maxAumentoVida(){
			if(vida >= MAX_VIDA){
				vida = MAX_VIDA;
			}
		}
	public void atacarPersonaje(Personaje p)
	{
		try {
			if(p.estadoSalud == EstadoSalud.MUERTO){
			System.err.println( p.nombre + " ya está muerto" );
			}else{
				p.vida = p.vida - (calculaAtaque() - calculaDefensa(p));
				p.chequearEstado();
			}

		}catch (ExceptionEquipamiento e){
			System.err.println(e);
		}
	}

	public void atacarEnemigo(Enemigo enemigo)
	{
		try {
			if(enemigo.vida == 0){
				System.err.println("El "+ enemigo.nombre +" ya está muerto");
			}else {
				enemigo.vida = enemigo.vida - calculaAtaque();
				if (enemigo.vida <= 0) {
					enemigo.vida = 0;
					notificar();
					System.out.println("! " + nombre + " ha matado a un " + enemigo.nombre + " !");
				}
			}
		}catch (ExceptionEquipamiento e){
			System.err.println(e);
		}
	}

	private int calculaAtaque() throws ExceptionEquipamiento {
		int ataque = 0;
		if(this.equipamiento.getArma() != null){

				ataque = this.equipamiento.getArma().ataque();
		}else{
			throw new ExceptionEquipamiento("No puedes atacar sin equipamiento");
		}
		return ataqueSegunEstado(ataque);
	}
	public int calculaDefensa(Personaje p){
		int defensa = 0;
		if(p.equipamiento.getArmadura() != null){
			 defensa = p.equipamiento.getArmadura().getDefensa();
		}
		return defensa;
	}

	private EstadoSalud chequearEstado(){
		if(vida <= 50 && vida > MIN_VIDA){
			estadoSalud = EstadoSalud.HERIDO;
		}else if(vida > 50){
			estadoSalud = EstadoSalud.VIVO;
		}else if( vida <= MIN_VIDA){
			estadoSalud = EstadoSalud.MUERTO;
			this.vida = MIN_VIDA;
		}
		return estadoSalud;
	}

	public String getNombre() {
		return nombre;
	}
	public int getVida() {
		return vida;
	}

	public EstadoEspecial getEstadoEspecial() {
		return estadoEspecial;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public void setEstadoEspecial(EstadoEspecial estadoEspecial) {
		this.estadoEspecial = estadoEspecial;
	}

	private int ataqueSegunEstado(int total){
		if(estadoSalud == EstadoSalud.HERIDO )
		{
			 total = total / 2;
		}else if(estadoSalud == EstadoSalud.MUERTO){
			 total = 0 ;
			System.out.println("ESTAS MUERTO, NO PUEDES ATACAR");
		}
		return total;
	}

	///MISIONES///
	public void añadirMision(Observador obs) {
		this.misiones.add(obs);
		obs.setPersonaje(this);
	}


	public void eliminarMision( Observador obs) {
		this.misiones.remove(obs);
		obs.setPersonaje(null);
	}
	public void notificar(){
		for( Observador obs : misiones){
			obs.actualizar();
		}
	}

	public void recogerRecompensa(Mision m1){
		try{
			String items = "";
			ArrayList<Item> recompensa = m1.getRecompensa();
			System.out.print("Felicitaciones, aquí tienes tu recompensa: ");
		for (Item item: recompensa) {
			this.inventario.agregarItemAlInventario(item);
			items = item.getNombre();

			System.out.print(items + ", ");
		}
			System.out.println("\b\b.");


		}catch(ExceptionRecompensa e){
			System.err.println(e);
		}

	}
	@Override
	public String toString() {
		return "Nombre : " + nombre + "\nVida : " + vida +"\nEstado de Salud : " + estadoSalud+ "\nEstado Especial : " + estadoEspecial+ "\nInventario : " + inventario + "\nEquipamiento : " + equipamiento;
	}


}
