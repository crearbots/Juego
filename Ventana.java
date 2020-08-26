
import javax.swing.JFrame;

public class Ventana extends JFrame {
    private final int ancho=800, alto=500;
    private final Mesa lamina;
    private final Velocidad velocidad;
    public Ventana(){
        setTitle("ping pong");
        setSize(ancho,alto);
        setLocationRelativeTo(null);
        setResizable(false);
        lamina= new Mesa();
        add(lamina);
        addKeyListener(new Movimiento());
        velocidad=new Velocidad(lamina);
        velocidad.start();
    
    }
}
