public class Hechizo {
    private String nombre;
    private EstadoEspecial estadoEspecial;

    public Hechizo(String nombre, EstadoEspecial estadoEspecial) {
        this.nombre = nombre;
        this.estadoEspecial = estadoEspecial;
    }


    public EstadoEspecial getEstadoEspecial() {
        return estadoEspecial;
    }
}
