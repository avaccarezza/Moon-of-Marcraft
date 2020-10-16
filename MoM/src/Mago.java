public class Mago extends Enemigo {
    private static final int MAX_VIDA = 100;


    public Mago() {
        nombre = "Mago";
        vida = 100;
    }
    public void castear(Personaje p1,Hechizo h1) {
        EstadoEspecial est = h1.getEstadoEspecial();
        p1.setEstadoEspecial(est);
    }



    public  int getMaxVida() {
        return MAX_VIDA;
    }
    @Override
    public String toString() {
        return "Nombre : " + nombre + "\nVida :" + vida;
    }
}
