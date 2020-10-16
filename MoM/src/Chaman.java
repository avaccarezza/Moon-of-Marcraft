public class Chaman extends Enemigo{
    private static final int CURAR = 30;
    private static final int MAX_VIDA = 80;

    public Chaman() {
        nombre = "Chaman";
        vida = 80;
    }

    public void curar(Enemigo e1) {
        if( e1.vida == 0){
            System.err.println("No puedes curar, ya está muerto");
        }else{
            e1.vida = e1.vida + CURAR;
            if (e1.vida >= e1.getMaxVida()) {
                e1.vida = e1.getMaxVida();
            }
        }

    }

    public  int getMaxVida() {
        return MAX_VIDA;
    }

    @Override
    public String toString() {
        return "Nombre : " + nombre + "\nVida :" + vida;
    }
}
