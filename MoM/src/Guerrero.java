public class Guerrero extends Enemigo {

    private static final int DAÑO = 20;
    private static final int MAX_VIDA = 200;

    public Guerrero() {
        nombre = "Guerrero";
        vida = 200;
    }

    public void atacar(Personaje p1) {
        int vidaPersonaje = p1.getVida();
        vidaPersonaje = vidaPersonaje - (DAÑO - p1.calculaDefensa(p1));
        p1.setVida(vidaPersonaje);
    }


    public  int getMaxVida() {
        return MAX_VIDA;
    }

    @Override
    public String toString() {
        return "Nombre : " + nombre + "\nVida :" + vida;
    }
}


