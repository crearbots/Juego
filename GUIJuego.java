import javax.swing.*;

public class GUIJuego extends JFrame {
  //Atributos 
  private FondoPanel fondo = new FondoPanel();

  //Constructor
  public GUIJuego() {
    //Condiguraciones generales
    this.setTitle("Ping Pong");
    this.setContentPane(fondo);
    this.setLayout(null);
    this.setBounds(0,0,1300,700);
    this.setVisible(true);
    this.setLocationRelativeTo(null);
    //this.setResizable(false);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
  }
}
