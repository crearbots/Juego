import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Velocidad extends Thread {
    //Atributos
    Mesa lamina;

    //Constructor
    public Velocidad(Mesa lamina){
        this.lamina=lamina;
    }
 
    @Override
    public void run(){
        while(true){
                try {
                    Thread.sleep(3);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Velocidad.class.getName()).log(Level.SEVERE, null, ex);
                }
            
            lamina.repaint();
            if(lamina.getJugador1Punto()==5) {
                JOptionPane.showMessageDialog(null,"Fin del juego!!!\n(~^-^)~ "+lamina.getJugador1Nombre()+" ha ganado ~(^-^~)");
                break;
            }
            if(lamina.getJugador2Punto()==5) {
                JOptionPane.showMessageDialog(null,"Fin del juego!!!\n(~^-^)~ "+lamina.getJugador2Nombre()+" ha gando ~(^-^~)");
                break;
            }
        }
    }
}