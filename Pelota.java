import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

public class Pelota {
    private int x;
    private int y;
    private  int dx=1, dy=1;
    private  int ancho=15,alto=15;

    //Constructor
    public Pelota(int x, int y){
        this.x=x;
        this.y=y;
    }

    //Getter
    public Rectangle2D getPelota(){
        return new Rectangle2D.Double(x,y,ancho,alto);
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    //Metodos
    public void mover(Rectangle limites, boolean choqueR1, boolean choqueR2, Usuario j1, Usuario j2){
       x+=dx;
       y+=dy;
       
       //Choque con las raquetas
       if(choqueR1){
         dx=-dx;
         x=50;
       }
       if(choqueR2){
         dx=-dx;
         x=1240;
       }

        //Rebotar al tocar un limite
       if(x >= (limites.getMaxX()-ancho)){
           dx=-dx;
           j1.setPunto(j1.getPunto()+1);
           x=650;
       }
       if(y >= (limites.getMaxY()-alto)){
           dy=-dy;
       }
       if(x<0){
           dx=-dx;
           j2.setPunto(j2.getPunto()+1);
           x=650;
       }
       if(y<130){
           dy=-dy;
       }
    }
}