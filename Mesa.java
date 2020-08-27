import java.util.Arrays;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.Image;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class Mesa extends FondoPanel {
    //Atributos
    Pelota pelota=new Pelota(650,350);
    Raqueta r1=new Raqueta(40,350);
    Raqueta r2=new Raqueta(1260,350);
    Usuario jugador1, jugador2;
    private ImageIcon imagen1, imagen2;
    private JLabel marcador1, marcador2;
    private boolean[] turno = new boolean[10];

    //Constructor
    public Mesa(boolean cpu) {
        //Construyendo elementos del juego
        Arrays.fill(turno, Boolean.TRUE);
        r2 = new Raqueta(1260, 350, cpu);
        jugador1 = new Usuario("jugador 1");
        if(cpu ==  true) {
            jugador2 = new Usuario("CPU");
        } else {
            jugador2 = new Usuario("Juagdor 2");
        }

        //Definiendo marcador
        this.setLayout(null);
        
        imagen1 = new ImageIcon("cero.jpg");
        marcador1 = new JLabel(imagen1);
        marcador1.setBounds(565,0,80,105);
        marcador1.setIcon(new ImageIcon(imagen1.getImage().getScaledInstance(marcador1.getWidth(), marcador1.getHeight(), Image.SCALE_SMOOTH)));
        this.add(marcador1);

        imagen2 = new ImageIcon("cero.jpg");
        marcador2 = new JLabel(imagen2);
        marcador2.setBounds(655,0,80,105);
        marcador2.setIcon(new ImageIcon(imagen2.getImage().getScaledInstance(marcador2.getWidth(), marcador2.getHeight(), Image.SCALE_SMOOTH)));
        this.add(marcador2);
    }

    //Getter
    public int getJugador1Punto() {
        return jugador1.getPunto();
    }

    public int getJugador2Punto() {
        return jugador2.getPunto();
    }

    public String getJugador1Nombre() {
        return jugador1.getNombre();
    }

    public String getJugador2Nombre() {
        return jugador2.getNombre();
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
        //Movimiento de los objetos
        pelota.mover(getBounds(), choque(r1.getRaqueta()), choque(r2.getRaqueta()), jugador1, jugador2);
        r1.moverR1(getBounds());
        if(r2.getCpu() == true) {
            r2.moverR2(getBounds(), pelota.getY(), pelota.getX());
        } else {
            r2.moverR2(getBounds());
        }

        //Estado del marcador
        marcador();
    }

    private  boolean choque(Rectangle2D r){
      return pelota.getPelota().intersects(r);
    }

    private void marcador() {
        switch(jugador1.getPunto()) {
            case 1: marcador1.setText(""+jugador1.getPunto()); break;
            case 2: marcador1.setText(""+jugador1.getPunto()); break;
            case 3: marcador1.setText(""+jugador1.getPunto()); break;
            case 4: marcador1.setText(""+jugador1.getPunto()); break;
            case 5: marcador1.setText(""+jugador1.getPunto()); break;
        }

        switch(jugador2.getPunto()) {
            case 1: marcador2.setText(""+jugador2.getPunto()); break;
            case 2: marcador2.setText(""+jugador2.getPunto()); break;
            case 3: marcador2.setText(""+jugador2.getPunto()); break;
            case 4: marcador2.setText(""+jugador2.getPunto()); break;
            case 5: marcador2.setText(""+jugador2.getPunto()); break;
        }
    }
}