import java.awt.Color.*;
import java.awt.Graphics.*;
import javax.swing.*;

public class Elemento extends Jpanel {
 Raqueta r1=new Raqueta (10,200);
 Raqueta r2=new Rqueta (10,200);
  public Elemento(){
    setBackground(Color.BLACK);
  }

  public void paintComponent (Graphics g){
    super.paintComponent(g);

    Graphics2D g2=(Graphics2D)g;
    g2.setColor(Color.YELLOW);
    g2.Fill(new rectangle2D.Double(0,0,20,20));
  }
  

}