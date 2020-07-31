import javax.swing.*;
import java.awt.*;

public class FondoPanel extends JPanel {
    //Atributo
    private Image imagen;

    //Metodo sobreescrito
    @Override
    public void paint (Graphics g) {
        //Obteniendo imagen
        imagen = new ImageIcon(getClass().getResource("/campo.jpg")).getImage();

        g.drawImage(imagen,0,0,getWidth(),getHeight(),this);
        setOpaque(false);
        super.paint(g);
    }
}
