import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

public class Raqueta {
    private boolean cpu = false;
    private int x,y;
    private final int ancho=10, alto=55;

    //Constructores
    public Raqueta(int x,int y ){
        this.x= x;
        this.y= y;
    }

    public Raqueta(int x, int y, boolean cpu){
        this.x= x;
        this.y= y;
        this.cpu = cpu;
    }

    //Getter
    public boolean getCpu() {
        return cpu;
    }
    
    public Rectangle2D getRaqueta(){
        return new Rectangle2D.Double(x,y,ancho,alto);
    }
    
    public void moverR1(Rectangle limites){
        if(Movimiento.w && y>(limites.getMinY()+130)){
            y--;
        }
         if(Movimiento.s&&y<limites.getMaxY()-alto){
            y++;
        }
        
    }

    public void moverR2(Rectangle limites){
         if(Movimiento.up && y>(limites.getMinY()+130)){
            y--;
        }
          if(Movimiento.down&&y<limites.getMaxY()-alto){
            y++;
        }
    }

    public void moverR2(Rectangle limites, int corY, int corX) {
        if(corX >= 1100) {
            if((corY > y) && (y != limites.getMaxY()-alto)) {
                y++;
            }

            if(corY < y) {
                y--;
            }
        }
    }
}
