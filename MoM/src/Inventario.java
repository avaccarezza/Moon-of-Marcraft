import java.util.ArrayList;

public class Inventario {

    private ArrayList<Item> inventario;

    public Inventario() {
        this.inventario = new ArrayList<>();
    }

    public void agregarItemAlInventario(Item i){
        this.inventario.add(i);
    }
    public void sacarItemDelInventario(Item i){
        this.inventario.remove(i);
    }

    public ArrayList<Item> getInventario() {
        return inventario;
    }






    @Override
    public String toString() {
        return "" + inventario ;
    }
}
