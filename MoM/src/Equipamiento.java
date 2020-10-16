import java.io.IOException;
import java.util.ArrayList;

public class Equipamiento {

    private Arma arma;
    private Armadura armadura;
    private Inventario inventario;


    public Equipamiento(Inventario inventario){
       this.inventario = inventario;

   }

    private boolean isInventario(Item it) {
        for(Item item : inventario.getInventario())
        {
            if(item.getNombre().equals(it.getNombre()))
            {
                inventario.sacarItemDelInventario(item);
                return true;
            }
        }
       return false;
    }

    public void equiparArma(Arma arma)
    {

            if (isInventario(arma)) {
                this.arma = arma;
            }else{
                System.err.println("No puedes equipar "+ arma + " porque no la tienes en el inventario");
            }
    }

    public void equiparArmadura(Armadura armadura){
        if(isInventario(armadura)){
            this.armadura = armadura;
        }else{
            System.err.println("No puedes equipar "+ armadura + " porque no la tienes en el inventario");
        }
    }
    public void equiparFlechas(Flecha flechas){

           if (isInventario(flechas)) {
               arma.equiparMunicion(flechas);
           }
    }


    public Arma getArma() {
        return arma;
    }

    public Armadura getArmadura() {
        return armadura;
    }



    @Override
    public String toString() {
        return "arma: " + arma  + " - armadura: " + armadura;
    }


}
