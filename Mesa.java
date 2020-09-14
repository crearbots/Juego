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
    private Usuario jugador1, jugador2;
    private ImageIcon imagen1, imagen2;
    private JLabel marcador1, marcador2;
    private boolean[] turno = new boolean[10];

    //Constructor
    public Mesa(boolean cpu, String nombre1, String nombre2) {
        //Construyendo elementos del juego
        Arrays.fill(turno, Boolean.TRUE);
        r2 = new Raqueta(1260, 350, cpu);
        jugador1 = new Usuario(nombre1);
        if(cpu ==  true) {
            jugador2 = new Usuario("CPU");
        } else {
            jugador2 = new Usuario(nombre2);
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
        //Jugador 1
        if(jugador1.getPunto()==1 && turno[0]==true) {
            imagen1 = new ImageIcon("uno.jpg");
            marcador1.setIcon(new ImageIcon(imagen1.getImage().getScaledInstance(marcador1.getWidth(), marcador1.getHeight(), Image.SCALE_SMOOTH)));
            turno[0] = false;
        }
        if(jugador1.getPunto()==2 && turno[1]==true) {
            imagen1 = new ImageIcon("dos.jpg");
            marcador1.setIcon(new ImageIcon(imagen1.getImage().getScaledInstance(marcador1.getWidth(), marcador1.getHeight(), Image.SCALE_SMOOTH)));
            turno[1] = false;
        }
        if(jugador1.getPunto()==3 && turno[2]==true) {
            imagen1 = new ImageIcon("tres.jpg");
            marcador1.setIcon(new ImageIcon(imagen1.getImage().getScaledInstance(marcador1.getWidth(), marcador1.getHeight(), Image.SCALE_SMOOTH)));
            turno[2] = false;
        }
        if(jugador1.getPunto()==4 && turno[3]==true) {
            imagen1 = new ImageIcon("cuatro.jpg");
            marcador1.setIcon(new ImageIcon(imagen1.getImage().getScaledInstance(marcador1.getWidth(), marcador1.getHeight(), Image.SCALE_SMOOTH)));
            turno[3] = false;
        }
        if(jugador1.getPunto()==5 && turno[4]==true) {
            imagen1 = new ImageIcon("cinco.jpg");
            marcador1.setIcon(new ImageIcon(imagen1.getImage().getScaledInstance(marcador1.getWidth(), marcador1.getHeight(), Image.SCALE_SMOOTH)));
            turno[4] = false;
        }

        //Jugador 2
        if(jugador2.getPunto()==1 && turno[5]==true) {
            imagen2 = new ImageIcon("uno.jpg");
            marcador2.setIcon(new ImageIcon(imagen2.getImage().getScaledInstance(marcador2.getWidth(), marcador2.getHeight(), Image.SCALE_SMOOTH)));
            turno[5] = false;
        }
        if(jugador2.getPunto()==2 && turno[6]==true) {
            imagen2 = new ImageIcon("dos.jpg");
            marcador2.setIcon(new ImageIcon(imagen2.getImage().getScaledInstance(marcador2.getWidth(), marcador2.getHeight(), Image.SCALE_SMOOTH)));
            turno[6] = false;
        }
        if(jugador2.getPunto()==3 && turno[7]==true) {
            imagen2 = new ImageIcon("tres.jpg");
            marcador2.setIcon(new ImageIcon(imagen2.getImage().getScaledInstance(marcador2.getWidth(), marcador2.getHeight(), Image.SCALE_SMOOTH)));
            turno[7] = false;
        }
        if(jugador2.getPunto()==4 && turno[8]==true) {
            imagen2 = new ImageIcon("cuatro.jpg");
            marcador2.setIcon(new ImageIcon(imagen2.getImage().getScaledInstance(marcador2.getWidth(), marcador2.getHeight(), Image.SCALE_SMOOTH)));
            turno[8] = false;
        }
        if(jugador2.getPunto()==5 && turno[9]==true) {
            imagen2 = new ImageIcon("cinco.jpg");
            marcador2.setIcon(new ImageIcon(imagen2.getImage().getScaledInstance(marcador2.getWidth(), marcador2.getHeight(), Image.SCALE_SMOOTH)));
            turno[9] = false;
        }
    }
}