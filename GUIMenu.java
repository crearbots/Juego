import javax.swing.*;
import java.awt.Image;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUIMenu extends JFrame implements ActionListener {
    //Atributos
    private FondoPanel fondo = new FondoPanel();
    private JTextField etiqueta1, etiqueta2;
    private JButton boton1, boton2, boton3, boton4, boton5;
    private ImageIcon imagen1, imagen2, imagen3, imagen4, imagen5;

    //Constructor
    public GUIMenu() {
        //Condiguraciones generales
        this.setTitle("Menu");
        this.setContentPane(fondo);
        this.setLayout(null);
        this.setBounds(0,0,500,360);
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
        etiqueta1 = new JTextField("1 Jugador");
        etiqueta1.setBounds(30,20,200,40);
        etiqueta1.setForeground(Color.GREEN);
        etiqueta1.setFont(new Font("Lato Black", 1, 30));
        this.add(etiqueta1);

        //Configuracion segunda etiqueta
        etiqueta2 = new JTextField("2 Jugadores");
        etiqueta2.setBounds(270,20,200,40);
        etiqueta2.setForeground(Color.GREEN);
        etiqueta2.setFont(new Font("Lato Black", 1, 30));
        this.add(etiqueta2);
    }

    private void colocarBotones() {
        //Configuracion primer boton
        imagen1 = new ImageIcon("player1.png");
        boton1 = new JButton(imagen1);
        boton1.setBounds(30,70,200,200);
        boton1.setIcon(new ImageIcon(imagen1.getImage().getScaledInstance(boton1.getWidth(), boton1.getHeight(), Image.SCALE_SMOOTH)));
        boton1.addActionListener(this);
        this.add(boton1);

        //Configuracion segundo boton
        imagen2 = new ImageIcon("player2.png");
        boton2 = new JButton(imagen2);
        boton2.setBounds(270,70,200,200);
        boton2.setIcon(new ImageIcon(imagen2.getImage().getScaledInstance(boton2.getWidth(), boton2.getHeight(), Image.SCALE_SMOOTH)));
        boton2.addActionListener(this);
        this.add(boton2);

        //Configuracion tercer boton
        imagen3 = new ImageIcon("instrucciones.jpg");
        boton3 = new JButton(imagen3);
        boton3.setBounds(150,280,40,40);
        boton3.setIcon(new ImageIcon(imagen3.getImage().getScaledInstance(boton3.getWidth(), boton3.getHeight(), Image.SCALE_SMOOTH)));
        boton3.addActionListener(this);
        this.add(boton3);

        //Configuraciones cuarto boton
        imagen4 = new ImageIcon("donar.png");
        boton4 = new JButton(imagen4);
        boton4.setBounds(220,280,60,40);
        boton4.setIcon(new ImageIcon(imagen4.getImage().getScaledInstance(boton4.getWidth(), boton4.getHeight(), Image.SCALE_SMOOTH)));
        boton4.addActionListener(this);
        this.add(boton4);

        imagen5 = new ImageIcon("salir.jpg");
        boton5 = new JButton(imagen5);
        boton5.setBounds(310,280,40,40);
        boton5.setIcon(new ImageIcon(imagen5.getImage().getScaledInstance(boton5.getWidth(), boton5.getHeight(), Image.SCALE_SMOOTH)));
        boton5.addActionListener(this);
        boton5.setMnemonic('c');
        this.add(boton5);
   }

    //Metodo que modela los eventos
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == boton1) {
            GUIJuego ventana = new GUIJuego(true, etiqueta1.getText(), "CPU", "cuatroBrazos.jpg", "ultraT.jpg");
        }

        if(e.getSource() == boton2) {
            GUIJuego ventana = new GUIJuego(false, etiqueta1.getText(), etiqueta2.getText(), "planta.jpg", "xrl8.jpg");
        }

        if(e.getSource() == boton3) {
            JOptionPane.showMessageDialog(null,"\tIntrucciones\n1. El jugador1 se mueve con las teclas 'w' y 's'\n2. El jugador2 se mueve con las flechas arriba y abajo\n3. Para salir en cualquier momento del juego puede precionar\nla combinacion de teclas 'Alt + c'");
        }

        if(e.getSource() == boton5) {
            System.exit(0);
        }
    }
}