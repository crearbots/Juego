public class Usuario {
    //Atributos
    private String nombre;
    private int punto = 0;

    //Constructor
    public Usuario(String name) {
        this.nombre = name;
    }

    //Setter
    public void setPunto(int x) {
        this.punto = x;
    }

    //Getter
    public int getPunto() {
        return punto;
    }

    public String getNombre() {
        return nombre;
    }
}