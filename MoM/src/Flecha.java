public class Flecha extends Item {
    private int danio;
    private int stock;

    public Flecha(String nombre, int danio, int stock) {
        super(nombre);
        this.danio = danio;
        this.stock = stock;
    }

    public int getDanio()
    {
        return danio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }


}
