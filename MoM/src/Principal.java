
public class Principal {

	public static void main(String[] args) {

///////////////////////////////////        ITEMS        ////////////////////////////////////////////////////////////////
		/// ARCOS ///
		Arco arco_fuego = new Arco("Arco de Fuego", 10);
		Arco arco_dorado = new Arco("Arco dorado", 15);
		/// FLECHAS ///
		Flecha flecha_fuego = new Flecha("Flecha de fuego", 7, 20);
		Flecha flecha_dorada = new Flecha("Flecha dorada", 14, 10);
		/// ESPADA ///
		Espada espada_larga = new Espada("Espada", 125);
		/// HACHAS ///
		Hacha hacha = new Hacha("Hacha",15,30);


		/// CASCOS ///
		Armadura wings_helm = new Armadura("Wings Helm", 7);
		Armadura horned_helm = new Armadura("Horned helm", 10);
		/// CHALECOS ///
		Armadura hauberk = new Armadura("Hauberk", 7);
		Armadura plate_mail = new Armadura("Plate Mail", 10);
		/// PANTALONES ///
		Armadura chain_hose = new Armadura("Chain House", 7);
		Armadura plate_leggins = new Armadura("Plate Leggins", 10);
		// ESCUDOS ///
		Armadura wood_shield = new Armadura("Wood Shield", 7);
		Armadura tower_shield = new Armadura("Tower Shield", 10);

		/// COMIDAS ///
		Comida manzana = new Comida("Manzana", 15, 1);
		Comida pan = new Comida("Pan", 7, 2);

///////////////////////////////////	HECHIZOS  //////////////////////////////////////////////////////////////////////////
		Hechizo paralizar = new Hechizo("Paralizar", EstadoEspecial.PARALIZADO);
		Hechizo confusionar = new Hechizo("Paralizar", EstadoEspecial.CONFUSION);
		Hechizo normalizar = new Hechizo("Paralizar", EstadoEspecial.NORMAL);
		Hechizo dormir = new Hechizo("Paralizar", EstadoEspecial.DORMIDO);
		Hechizo envenenar = new Hechizo("Paralizar", EstadoEspecial.ENVENENADO);

/////////////////////////////////        PERSONAJES        /////////////////////////////////////////////////////////////
////////// GRIGUOL //////////
		Personaje griguol = new Personaje("Griguol");

		Inventario i1 = new Inventario();
		griguol.agregarInventario(i1);
		Equipamiento e1 = new Equipamiento(i1);
		griguol.agregarEquipamiento(e1);

///////// CANELON //////////
		Personaje canelon = new Personaje("Canelon");

		Inventario i2 = new Inventario();
		canelon.agregarInventario(i2);
		Equipamiento e2 = new Equipamiento(i2);
		canelon.agregarEquipamiento(e2);

///////// ENEMIGOS ///////////////

		Guerrero guerrero = new Guerrero();
		Guerrero guerrero2 = new Guerrero();
		Chaman chaman = new Chaman();
		Mago mago = new Mago();

///////// MISIONES ///////////
		Mision m1 = new Mision("matar 30 guerreros",new Guerrero(), 30);
		m1.añadirItem(espada_larga);
		m1.añadirItem(manzana);
		m1.añadirItem(pan);

		Mision m2 = new Mision("matar 1 guerrero", new Guerrero(), 1);
		m2.añadirItem(flecha_fuego);
		m2.añadirItem(manzana);
		m2.añadirItem(pan);

		Mision m3 = new Mision("matar 30 magos", new Mago(), 30);
		m3.añadirItem(arco_dorado);
		m3.añadirItem(flecha_dorada);
		m3.añadirItem(pan);


////////// CAMPO DE BATALLA //////////

//Equipa espada, agrega misiones, completa mision y  recoge recompensa
	/*i2.agregarItemAlInventario(espada_larga);
		e2.equiparArma(espada_larga);

		canelon.añadirMision(m1);
		canelon.añadirMision(m2);

		canelon.atacarEnemigo(guerrero);
		canelon.atacarEnemigo(guerrero);

		m1.getCantidadRestantes();
		m2.getCantidadRestantes();

		canelon.recogerRecompensa(m2);*/

//Muestra error al querer recoger la recompensa sin terminar la mision
/*
canelon.recogerRecompensa(m1);
*/
//Equipa arco, flechas, personaje ataca al guerrero, chaman cura al guerrero
/*
	i2.agregarItemAlInventario(arco_dorado);
	i2.agregarItemAlInventario(flecha_dorada);
	e2.equiparArma(arco_dorado);
	e2.equiparFlechas(flecha_dorada);

	canelon.atacarEnemigo(guerrero);
	canelon.atacarEnemigo(guerrero);
	chaman.curar(guerrero);
*/
//Equipa Hacha, ataca al guerrero (30% probabilidad de CRITICAL ATTACK)
/*		i2.agregarItemAlInventario(hacha);
		e2.equiparArma(hacha);
		canelon.atacarEnemigo(guerrero);
		canelon.atacarEnemigo(guerrero);
		canelon.atacarEnemigo(guerrero);
 */
//Guerrero ataca al personaje y el personaje disminuye el daño con armadura y se cura con comida
/*		i2.agregarItemAlInventario(hauberk);
		i2.agregarItemAlInventario(pan);
		e2.equiparArmadura(hauberk);
		guerrero.atacar(canelon);
		guerrero.atacar(canelon);
		canelon.consumir(pan);
		canelon.consumir(pan);
		//muestra cartel de error si no hay pan en el inventario
		//canelon.consumir(pan);
*/
//Mago cambia el estado especial del personaje
/*
		//mago.castear(canelon,paralizar);
		//mago.castear(canelon,envenenar);
		//mago.castear(canelon,confusionar);
		//mago.castear(canelon,dormir);
 */
//Muestra error al atacar con arco sin equipar flechas
/*		i2.agregarItemAlInventario(arco_dorado);
		i2.agregarItemAlInventario(flecha_dorada);
		e2.equiparArma(arco_dorado);

		canelon.atacarEnemigo(guerrero);*/
//Muestra error al querer equipar arma sin tener en el inventario
/*		e2.equiparArma(espada_larga);
 */
//Muestra patrón observer
/*i2.agregarItemAlInventario(espada_larga);
e2.equiparArma(espada_larga);

		canelon.añadirMision(m1);
		canelon.añadirMision(m2);
		canelon.atacarEnemigo(guerrero);
		canelon.atacarEnemigo(guerrero);
		canelon.atacarEnemigo(guerrero2);
		canelon.atacarEnemigo(guerrero2);

		m1.getCantidadRestantes();
		m2.getCantidadRestantes();
*/
//////// IMPRIMIR ////////////

		System.out.println(canelon);
		System.out.println("-------------------------------");
		System.out.println(guerrero);
		//System.out.println(guerrero2);

	}

}
