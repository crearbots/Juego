import javax.swing.*;
import java.awt.Image;
import java.awt.Color;
import java.awt.Font;

public class GUIJuego extends JFrame {
  //Atributos 
  private ImageIcon imagen1, imagen2, imagen3, imagen4;
  private JLabel marcador1, marcador2, player1, player2;
  private JLabel nombre1, nombre2;
  private Mesa lamina;
  private final Velocidad animacion;

  //Constructor
  public GUIJuego(boolean cpu, String jugador1, String jugador2, String ruta1, String ruta2) {
    //Construyecto lamina
    lamina = new Mesa(cpu);
    animacion = new Velocidad(lamina);

    //Condiguraciones generales
    this.setTitle("Ping Pong");
    this.setLayout(null);
    this.setContentPane(lamina);
    this.setBounds(0,0,1300,700);
    this.setVisible(true);
    this.setLocationRelativeTo(null);
    this.setResizable(false);
    this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    //Otras configuraciones
    addKeyListener(new Movimiento());
    animacion.start();
    lamina.setLayout(null);
    colocarElementos(jugador1, jugador2, ruta1, ruta2);
  }

  public void colocarElementos(String name1, String name2, String image1, String image2) {
    //Configuraciones de las etiquetas tipo imagen
    imagen1 = new ImageIcon("cero.jpg");
    marcador1 = new JLabel(imagen1);
    marcador1.setBounds(655,0,80,105);
    marcador1.setIcon(new ImageIcon(imagen1.getImage().getScaledInstance(marcador1.getWidth(), marcador1.getHeight(), Image.SCALE_SMOOTH)));
    this.add(marcador1);

    imagen2 = new ImageIcon("cero.jpg");
    marcador2 = new JLabel(imagen2);
    marcador2.setBounds(565,0,80,105);
    marcador2.setIcon(new ImageIcon(imagen2.getImage().getScaledInstance(marcador2.getWidth(), marcador2.getHeight(), Image.SCALE_SMOOTH)));
    this.add(marcador2);

    imagen3 = new ImageIcon(image1);
    player1 = new JLabel(imagen3);
    player1.setBounds(0,0,110,130);
    player1.setIcon(new ImageIcon(imagen3.getImage().getScaledInstance(player1.getWidth(), player1.getHeight(), Image.SCALE_SMOOTH)));
    this.add(player1);

    imagen4 = new ImageIcon(image2);
    player2 = new JLabel(imagen4);
    player2.setBounds(1190,0,110,130);
    player2.setIcon(new ImageIcon(imagen4.getImage().getScaledInstance(player2.getWidth(), player2.getHeight(), Image.SCALE_SMOOTH)));
    this.add(player2);

    //Configuraciones de la etiquetas normales
    player1 = new JLabel(name1);
    player1.setBounds(160,30,300,105);
    player1.setForeground(Color.GREEN);
    player1.setFont(new Font("Lato Black", 1, 60));
    this.add(player1);

    player2 = new JLabel(name2);
    player2.setBounds(850,30,300,105);
    player2.setForeground(Color.GREEN);
    player2.setFont(new Font("Lato Black", 1, 60));
    this.add(player2);
  }
}