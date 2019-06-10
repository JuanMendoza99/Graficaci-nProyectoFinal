import java.awt.Color;
import java.awt.Point;
import java.awt.geom.Point2D;

/*
 * @author Juan José Mendoza Camacho
 */

public class Linea extends Figura {
    Point2D puntoA;
    Point2D puntoB;
    
    Linea(Point _p1, Point _p2, Color _color) {
        puntoA = new Point(_p1.x,_p1.y);
        puntoB = new Point(_p2.x,_p2.y);
        color  = _color;
    }    
}
