import java.awt.Color;
import java.awt.Point;
import java.awt.geom.Point2D;

/*
 * @author Juan José Mendoza Camacho
 */

public class Elipse extends Figura {
    Point2D puntoC;
    Point2D puntoR;
    Point2D puntoA;
    
     Elipse(Point pc,Point pr,Point pa, Color _color){
         puntoC=new Point(pc.x,pc.y);
         puntoR=new Point(pr.x,pr.y);
         puntoA=new Point (pa.x,pa.y);
         color=_color;
     }

}
