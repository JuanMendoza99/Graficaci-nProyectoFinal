import java.awt.Color;
import java.awt.Point;
import java.awt.geom.Point2D;

/*
 * @author Juan José Mendoza Camacho
 */

public class Cuadrado extends Figura{
    Point puntoA;
    Point puntoB;
    Point puntoC;
    Point puntoD;
    Cuadrado(Point p1, Point p2,Point p3, Point p4, Color _color){
    puntoA=new Point(p1.x,p1.y);
    puntoB=new Point(p2.x,p2.y);
    puntoC=new Point(p3.x,p3.y);
    puntoD=new Point(p4.x,p4.y);
    color=_color;
    }
}
