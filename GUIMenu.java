import javax.swing.*;
import java.awt.Image;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUIMenu extends JFrame implements ActionListener {
    //Atributos
    private FondoPanel fondo = new FondoPanel();
    private JLabel etiqueta1, etiqueta2;
    private JButton boton1, boton2;
    private ImageIcon imagen1, imagen2;

    //Constructor
    public GUIMenu() {
        //Condiguraciones generales
        this.setTitle("Menu");
        this.setContentPane(fondo);
        this.setLayout(null);
        this.setBounds(0,0,500,350);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        //Agreando componentes
        colocarEtiquetas();
        colocarBotones();
    }

    //Metodos
    private void colocarEtiquetas() {
        //Configuracion primera etiqueta
        etiqueta1 = new JLabel("1 Jugador", SwingConstants.CENTER);
        etiqueta1.setBounds(30,50,200,40);
        etiqueta1.setForeground(Color.GREEN);
        etiqueta1.setFont(new Font("Lato Black", 1, 30));
        this.add(etiqueta1);

        //Configuracion segunda etiqueta
        etiqueta2 = new JLabel("2 Jugadores", SwingConstants.CENTER);
        etiqueta2.setBounds(270,50,200,40);
        etiqueta2.setForeground(Color.GREEN);
        etiqueta2.setFont(new Font("Lato Black", 1, 30));
        this.add(etiqueta2);
    }

    private void colocarBotones() {
        //Configuracion primer boton
        imagen1 = new ImageIcon("player1.png");
        boton1 = new JButton(imagen1);
        boton1.setBounds(30,100,200,200);
        boton1.setIcon(new ImageIcon(imagen1.getImage().getScaledInstance(boton1.getWidth(), boton1.getHeight(), Image.SCALE_SMOOTH)));
        boton1.addActionListener(this);
        this.add(boton1);

        //Configuracion segundo boton
        imagen2 = new ImageIcon("player2.png");
        boton2 = new JButton(imagen2);
        boton2.setBounds(270,100,200,200);
        boton2.setIcon(new ImageIcon(imagen2.getImage().getScaledInstance(boton2.getWidth(), boton2.getHeight(), Image.SCALE_SMOOTH)));
        boton2.addActionListener(this);
        this.add(boton2);
    }

    //Metodo que modela el evento
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == boton1) {
            GUIJuego ventana = new GUIJuego(true, "PLAYER 1", "CPU", "cuatroBrazos.jpg", "ultraT.jpg");
        }

        if(e.getSource() == boton2) {
            GUIJuego ventana = new GUIJuego(false, "PLAYER 1", "PLAYER 2", "planta.jpg", "xrl8.jpg");
        }
    }
}