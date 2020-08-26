import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;import javax.swing.JPanel;


public class Mesa extends FondoPanel {
    //Atributos
    Pelota pelota=new Pelota(650,350);
    Raqueta r1=new Raqueta(40,350);
    Raqueta r2=new Raqueta(1260,350);

    //Constructor
    public Mesa() {
        r2 = new Raqueta(1260, 350);
    }

    public Mesa(boolean cpu) {
        r2 = new Raqueta(1260, 350, cpu);
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2= (Graphics2D)g;
        g2.setColor(Color.green);
       dibujar(g2);
       actualizar();
    }
    
    //Metodos
    public void dibujar(Graphics2D g){
        g.fill(pelota.getPelota());
        g.fill(r1.getRaqueta());
        g.fill(r2.getRaqueta());
    }

    public void actualizar(){
        pelota.mover(getBounds(),choque(r1.getRaqueta()),choque(r2.getRaqueta()));
        r1.moverR1(getBounds());
        if(r2.getCpu() == true) {
            r2.moverR2(getBounds(), pelota.getY(), pelota.getX());
        } else {
            r2.moverR2(getBounds());
        }
    }

    private  boolean choque(Rectangle2D r){
      return pelota.getPelota().intersects(r);
    }
}