
public class Raqueta{
private int x,y;
private final int ancho =10, alto=25
public class Raqueta (int x, int y){
this.x=x;
this.y=y;
}
public Rectangle2D getRaqueta(){
  return new Rectangle2D.Double(x, y,ancho ,alto )
}
}
