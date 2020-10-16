import java.util.ArrayList;

public class Mision implements Observador{

    private String nombre;
    private Enemigo enemigo;
    private int cantidadRestante;
    private ArrayList<Item> recompensa;


    private Personaje personaje;

    public Mision(String nombre, Enemigo enemigo, int cantidadRestantes) {
        this.nombre = nombre;
        this.enemigo = enemigo;
        this.cantidadRestante = cantidadRestantes;
        this.recompensa = new ArrayList<>();
    }
    public void añadirItem(Item item){
        this.recompensa.add(item);
    }
    public void sacarItem(Item item){
        this.recompensa.remove(item);
    }
private boolean terminaMision(){
        if(cantidadRestante == 0){
            return true;
        }
        return false;
}

    public Enemigo getEnemigo() {
        return enemigo;
    }
    public String getNombre() {
        return nombre;
    }
    public int getCantidadRestantes() {
        if(cantidadRestante < 0){
            cantidadRestante = 0;
            System.out.println("Felicitaciones, terminaste la mision " +'"'+ this.nombre+'"');
        }else{
            System.out.println("Falta matar " + cantidadRestante + " para terminar la mision " +'"'+ this.nombre+'"' );
        }

        return cantidadRestante;
    }

    public ArrayList<Item> getRecompensa() throws ExceptionRecompensa {
        if(terminaMision()){
            return recompensa;
        }else{
            throw new ExceptionRecompensa("Aún no terminaste la misión");
        }
    }

    @Override
    public void setPersonaje(Personaje personaje) {
        this.personaje = personaje;
    }

    @Override
    public void actualizar() {
        this.cantidadRestante = cantidadRestante -1;

    }
    @Override
    public String toString() {
        return
                "nombre: " + nombre +"\nenemigo:" + enemigo +"\n cantidad restante:" + cantidadRestante + "\nrecompensa: "+recompensa;
    }


}
