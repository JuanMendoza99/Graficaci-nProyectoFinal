import java.awt.Color;
import java.awt.Point;
import java.awt.geom.Point2D;
import java.util.HashSet;
import java.util.Set;

/*
 * @author Juan José Mendoza Camacho
 */

public class Circulo extends Figura {
    Point2D puntoC;
    Point2D puntoR;
    
     Circulo(Point pc,Point pr, Color _color){
         puntoC= new Point(pc.x,pc.y);
         puntoR= new Point(pr.x,pr.y);
         color=_color;
     }

}
