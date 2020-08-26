import java.util.logging.Level;
import java.util.logging.Logger;

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
        }
    }
}
