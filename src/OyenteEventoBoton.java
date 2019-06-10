import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;
import javax.swing.JButton;


/*
 * @author Juan José Mendoza Camacho
 */

public class OyenteEventoBoton implements ActionListener {

    private Pizarra panel;

    public OyenteEventoBoton(Pizarra panel) {

        this.panel = panel;

    }

    public void dibujarFiguras() {
        for (int i = 0; i < panel.aFiguras.size(); i++) {
            Figura f = panel.aFiguras.get(i);

            if (f instanceof Linea) {

                Linea l = (Linea) f;
                panel.dibujarLinea((Point) l.puntoA, (Point) l.puntoB, l.color, false);
            }
            
            if (f instanceof Cuadrado) {
                Cuadrado cd = (Cuadrado) f;
                panel.dibujarTriangulo(cd.puntoA, cd.puntoB, cd.puntoC,cd.color, false);
                panel.dibujarTriangulo(cd.puntoA, cd.puntoB, cd.puntoD,cd.color, false);
            }
            
            if (f instanceof Circulo) {
                Circulo cr = (Circulo) f;
                panel.dibujarCirculo((Point) cr.puntoC, (Point) cr.puntoR, cr.color, false);
            }
            
            if (f instanceof TrianguloR) {
                TrianguloR t = (TrianguloR) f;
                Point p1 = new Point();
                Point p2 = new Point();
                Point p3 = new Point();
                p1.setLocation(t.v[0].x, t.v[0].y);
                p2.setLocation(t.v[1].x, t.v[1].y);
                p3.setLocation(t.v[2].x, t.v[2].y);
                panel.dibujarTriangulo(p1, p2, p3, t.color, false);
            }
            
            if (f instanceof Elipse) {
                Elipse el = (Elipse) f;
                panel.dibujarElipse((Point) el.puntoC, (Point) el.puntoR, (Point) el.puntoA, el.color, false);
            }
            
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton origen = (JButton) e.getSource();

        if (origen.getName().equals("escalar")) {

            System.out.println("Escalar");
            int n = (Integer.parseInt(panel.textoNumeroFigura.getText())) - 1;

            Figura f = panel.aFiguras.get(n);

            if (f instanceof Linea) {
                Linea l = (Linea) f;
                panel.dibujarLinea((Point) l.puntoA, (Point) l.puntoB, Color.WHITE, false);
                double[] punto = new double[3];
                double[] punto2 = new double[3];
                int transX;
                int transY;
                double esc = Double.parseDouble(panel.textoEscalar.getText());

                transX = ((int) l.puntoA.getX() - panel.oX) * (-1);
                transY = ((int) l.puntoA.getY() - panel.oY) * (-1);

                punto[0] = l.puntoA.getX();
                punto[1] = l.puntoA.getY();
                punto[2] = 1;

                Matrix m = new Matrix();
                m.traslacion(transX, transY);
                punto[0] = l.puntoA.getX() - panel.oX;
                punto[1] = l.puntoA.getY() - panel.oY;
                punto[2] = 1;
                m.escalar(esc);
                m.traslacion(transX * (-1), transY * (-1));
                punto2 = m.pprima(punto);
                l.puntoA.setLocation(punto2[0] + panel.oX, punto2[1] + panel.oY);

                punto[0] = l.puntoB.getX();
                punto[1] = l.puntoB.getY();
                punto[2] = 1;

                Matrix m1 = new Matrix();
                m1.traslacion(transX, transY);
                punto[0] = l.puntoB.getX() - panel.oX;
                punto[1] = l.puntoB.getY() - panel.oY;
                punto[2] = 1;
                m1.escalar(esc);
                m1.traslacion(transX * (-1), transY * (-1));
                punto2 = m1.pprima(punto);
                l.puntoB.setLocation(punto2[0] + panel.oX, punto2[1] + panel.oY);

                dibujarFiguras();

            }

            if (f instanceof TrianguloR) {
                TrianguloR t = (TrianguloR) f;
                Point p1 = new Point();
                Point p2 = new Point();
                Point p3 = new Point();
                p1.setLocation(t.v[0].x, t.v[0].y);
                p2.setLocation(t.v[1].x, t.v[1].y);
                p3.setLocation(t.v[2].x, t.v[2].y);
                panel.dibujarTriangulo(p1, p2, p3, Color.WHITE, false);

                double[] punto = new double[3];
                double[] punto2 = new double[3];
                int transX;
                int transY;
                double esc = Double.parseDouble(panel.textoEscalar.getText());

                transX = ((int) p1.x - panel.oX) * (-1);
                transY = ((int) p1.y - panel.oY) * (-1);

                punto[0] = p1.getX();
                punto[1] = p1.getY();
                punto[2] = 1;

                Matrix m = new Matrix();
                m.traslacion(transX, transY);
                punto[0] = p1.getX() - panel.oX;
                punto[1] = p1.getY() - panel.oY;
                punto[2] = 1;
                m.escalar(esc);
                m.traslacion(transX * (-1), transY * (-1));
                punto2 = m.pprima(punto);
                p1.setLocation(punto2[0] + panel.oX, punto2[1] + panel.oY);

                punto[0] = p2.getX();
                punto[1] = p2.getY();
                punto[2] = 1;

                Matrix m1 = new Matrix();
                m1.traslacion(transX, transY);
                punto[0] = p2.getX() - panel.oX;
                punto[1] = p2.getY() - panel.oY;
                punto[2] = 1;
                m1.escalar(esc);
                m1.traslacion(transX * (-1), transY * (-1));
                punto2 = m1.pprima(punto);
                p2.setLocation(punto2[0] + panel.oX, punto2[1] + panel.oY);

                punto[0] = p3.getX();
                punto[1] = p3.getY();
                punto[2] = 1;

                Matrix m2 = new Matrix();
                m2.traslacion(transX, transY);
                punto[0] = p3.getX() - panel.oX;
                punto[1] = p3.getY() - panel.oY;
                punto[2] = 1;
                m2.escalar(esc);
                m2.traslacion(transX * (-1), transY * (-1));
                punto2 = m2.pprima(punto);
                p3.setLocation(punto2[0] + panel.oX, punto2[1] + panel.oY);

                Vertex2D v1 = new Vertex2D(p1.x, p1.y, t.color.getRGB());
                Vertex2D v2 = new Vertex2D(p2.x, p2.y, t.color.getRGB());
                Vertex2D v3 = new Vertex2D(p3.x, p3.y, t.color.getRGB());

                TrianguloR tri = new TrianguloR(v1, v2, v3, t.color);
                panel.aFiguras.set(n, tri);
                dibujarFiguras();
            }

            if (f instanceof Circulo) {
                Circulo cr = (Circulo) f;
                panel.dibujarCirculo((Point) cr.puntoC, (Point) cr.puntoR, Color.WHITE, false);
                System.out.println(cr.puntoC.getX() + "," + cr.puntoR.getX());
                double[] punto = new double[3];
                double[] punto2 = new double[3];
                int transX;
                int transY;
                double esc = Double.parseDouble(panel.textoEscalar.getText());

                transX = ((int) cr.puntoC.getX() - panel.oX) * (-1);
                transY = ((int) cr.puntoC.getY() - panel.oY) * (-1);

                punto[0] = cr.puntoC.getX();
                punto[1] = cr.puntoC.getY();
                punto[2] = 1;

                Matrix m = new Matrix();
                m.traslacion(transX, transY);
                punto[0] = cr.puntoC.getX() - panel.oX;
                punto[1] = cr.puntoC.getY() - panel.oY;
                punto[2] = 1;
                m.escalar(esc);
                m.traslacion(transX * (-1), transY * (-1));
                punto2 = m.pprima(punto);
                cr.puntoC.setLocation(punto2[0] + panel.oX, punto2[1] + panel.oY);

                punto[0] = cr.puntoR.getX();
                punto[1] = cr.puntoR.getY();
                punto[2] = 1;

                Matrix m1 = new Matrix();
                m1.traslacion(transX, transY);
                punto[0] = cr.puntoR.getX() - panel.oX;
                punto[1] = cr.puntoR.getY() - panel.oY;
                punto[2] = 1;
                m1.escalar(esc);
                m1.traslacion(transX * (-1), transY * (-1));
                punto2 = m1.pprima(punto);
                cr.puntoR.setLocation(punto2[0] + panel.oX, punto2[1] + panel.oY);

                dibujarFiguras();
            }

            if (f instanceof Cuadrado) {
                Cuadrado cd = (Cuadrado) f;
                panel.dibujarTriangulo(cd.puntoA, cd.puntoB, cd.puntoC,Color.WHITE, false);
                panel.dibujarTriangulo(cd.puntoA, cd.puntoB, cd.puntoD,Color.WHITE, false);
                double[] punto = new double[3];
                double[] punto2 = new double[3];
                int transX;
                int transY;
                int pxm = (int) ((int) cd.puntoA.getX() + cd.puntoB.getX()) / 2;
                int pym = (int) ((int) cd.puntoA.getY() + cd.puntoB.getY()) / 2;;
                double escalar = Double.parseDouble(panel.textoEscalar.getText());

                transX = (pxm - panel.oX) * (-1);
                transY = (pym - panel.oY) * (-1);

                punto[0] = cd.puntoA.getX();
                punto[1] = cd.puntoA.getY();
                punto[2] = 1;

                Matrix m = new Matrix();
                m.traslacion(transX, transY);
                punto[0] = cd.puntoA.getX() - panel.oX;
                punto[1] = cd.puntoA.getY() - panel.oY;
                punto[2] = 1;
                m.escalar(escalar);
                m.traslacion(transX * (-1), transY * (-1));
                punto2 = m.pprima(punto);
                cd.puntoA.setLocation(punto2[0] + panel.oX, punto2[1] + panel.oY);

                punto[0] = cd.puntoB.getX();
                punto[1] = cd.puntoB.getY();
                punto[2] = 1;

                Matrix m1 = new Matrix();
                m1.traslacion(transX, transY);
                punto[0] = cd.puntoB.getX() - panel.oX;
                punto[1] = cd.puntoB.getY() - panel.oY;
                punto[2] = 1;
                m1.escalar(escalar);
                m1.traslacion(transX * (-1), transY * (-1));
                punto2 = m1.pprima(punto);
                cd.puntoB.setLocation(punto2[0] + panel.oX, punto2[1] + panel.oY);
                
                punto[0] = cd.puntoC.getX();
                punto[1] = cd.puntoC.getY();
                punto[2] = 1;

                Matrix m2 = new Matrix();
                m2.traslacion(transX, transY);
                punto[0] = cd.puntoC.getX() - panel.oX;
                punto[1] = cd.puntoC.getY() - panel.oY;
                punto[2] = 1;
                m2.escalar(escalar);
                m2.traslacion(transX * (-1), transY * (-1));
                punto2 = m2.pprima(punto);
                cd.puntoC.setLocation(punto2[0] + panel.oX, punto2[1] + panel.oY);
                
                punto[0] = cd.puntoC.getX();
                punto[1] = cd.puntoC.getY();
                punto[2] = 1;

                Matrix m3 = new Matrix();
                m3.traslacion(transX, transY);
                punto[0] = cd.puntoD.getX() - panel.oX;
                punto[1] = cd.puntoD.getY() - panel.oY;
                punto[2] = 1;
                m3.escalar(escalar);
                m3.traslacion(transX * (-1), transY * (-1));
                punto2 = m3.pprima(punto);
                cd.puntoD.setLocation(punto2[0] + panel.oX, punto2[1] + panel.oY);

                dibujarFiguras();
            }
            if (f instanceof Elipse) {
                Elipse el = (Elipse) f;
                panel.dibujarElipse((Point) el.puntoC, (Point) el.puntoR,(Point)el.puntoA, Color.WHITE, false);
                double[] punto = new double[3];
                double[] punto2 = new double[3];
                int transX;
                int transY;
                double esc = Double.parseDouble(panel.textoEscalar.getText());

                transX = ((int) el.puntoC.getX() - panel.oX) * (-1);
                transY = ((int) el.puntoC.getY() - panel.oY) * (-1);

                punto[0] = el.puntoC.getX();
                punto[1] = el.puntoC.getY();
                punto[2] = 1;

                Matrix m = new Matrix();
                m.traslacion(transX, transY);
                punto[0] = el.puntoC.getX() - panel.oX;
                punto[1] = el.puntoC.getY() - panel.oY;
                punto[2] = 1;
                m.escalar(esc);
                m.traslacion(transX * (-1), transY * (-1));
                punto2 = m.pprima(punto);
                el.puntoC.setLocation(punto2[0] + panel.oX, punto2[1] + panel.oY);

                punto[0] = el.puntoR.getX();
                punto[1] = el.puntoR.getY();
                punto[2] = 1;

                Matrix m1 = new Matrix();
                m1.traslacion(transX, transY);
                punto[0] = el.puntoR.getX() - panel.oX;
                punto[1] = el.puntoR.getY() - panel.oY;
                punto[2] = 1;
                m1.escalar(esc);
                m1.traslacion(transX * (-1), transY * (-1));
                punto2 = m1.pprima(punto);
                el.puntoR.setLocation(punto2[0] + panel.oX, punto2[1] + panel.oY);
                
                Matrix m2 = new Matrix();
                m2.traslacion(transX, transY);
                punto[0] = el.puntoA.getX() - panel.oX;
                punto[1] = el.puntoA.getY() - panel.oY;
                punto[2] = 1;
                m2.escalar(esc);
                m2.traslacion(transX * (-1), transY * (-1));
                punto2 = m2.pprima(punto);
                el.puntoA.setLocation(punto2[0] + panel.oX, punto2[1] + panel.oY);

                dibujarFiguras();

            }

        } else if (origen.getName().equals("rotar") && panel.textoNumeroFigura.getText() != null) {

            System.out.println("Rotar");
            int n = Integer.parseInt(panel.textoNumeroFigura.getText()) - 1;
            Figura f = panel.aFiguras.get(n);

            if (f instanceof Linea) {
                Linea l = (Linea) f;
                panel.dibujarLinea((Point) l.puntoA, (Point) l.puntoB, Color.WHITE, false);
                double[] punto = new double[3];
                double[] punto2 = new double[3];
                int transX;
                int transY;
                int pmx = (int) ((int) (l.puntoA.getX() + l.puntoB.getX())) / 2;
                int pmy = (int) ((int) (l.puntoA.getY() + l.puntoB.getY())) / 2;
                int rotar = Integer.parseInt(panel.textoRotar.getText());

                transX = (pmx - panel.oX) * (-1);
                transY = (pmy - panel.oY) * (-1);

                Matrix m = new Matrix();
                m.traslacion(transX, transY);
                punto[0] = l.puntoA.getX() - panel.oX;
                punto[1] = l.puntoA.getY() - panel.oY;
                punto[2] = 1;
                m.rotacion(rotar);
                m.traslacion(transX * (-1), transY * (-1));
                punto2 = m.pprima(punto);
                l.puntoA.setLocation(punto2[0] + panel.oX, punto2[1] + panel.oY);

                punto[0] = l.puntoB.getX();
                punto[1] = l.puntoB.getY();
                punto[2] = 1;

                Matrix m1 = new Matrix();
                m1.traslacion(transX, transY);
                punto[0] = l.puntoB.getX() - panel.oX;
                punto[1] = l.puntoB.getY() - panel.oY;
                punto[2] = 1;
                m1.rotacion(rotar);
                m1.traslacion(transX * (-1), transY * (-1));
                punto2 = m1.pprima(punto);
                l.puntoB.setLocation(punto2[0] + panel.oX, punto2[1] + panel.oY);

                dibujarFiguras();
            }

            if (f instanceof TrianguloR) {
                TrianguloR t = (TrianguloR) f;
                Point p1 = new Point();
                Point p2 = new Point();
                Point p3 = new Point();
                p1.setLocation(t.v[0].x, t.v[0].y);
                p2.setLocation(t.v[1].x, t.v[1].y);
                p3.setLocation(t.v[2].x, t.v[2].y);
                panel.dibujarTriangulo(p1, p2, p3, Color.WHITE, false);

                double[] punto = new double[3];
                double[] punto2 = new double[3];
                int transX;
                int transY;
                int pmx = (p1.x + p2.x + p3.x) / 3;
                int pmy = (p1.y + p2.y + p3.y) / 3;
                int rotar = Integer.parseInt(panel.textoRotar.getText());

                transX = (pmx - panel.oX) * (-1);
                transY = (pmy - panel.oY) * (-1);

                punto[0] = p1.getX();
                punto[1] = p1.getY();
                punto[2] = 1;

                Matrix m = new Matrix();
                m.traslacion(transX, transY);
                punto[0] = p1.getX() - panel.oX;
                punto[1] = p1.getY() - panel.oY;
                punto[2] = 1;
                m.rotacion(rotar);
                m.traslacion(transX * (-1), transY * (-1));
                punto2 = m.pprima(punto);
                p1.setLocation(punto2[0] + panel.oX, punto2[1] + panel.oY);

                punto[0] = p2.getX();
                punto[1] = p2.getY();
                punto[2] = 1;

                Matrix m1 = new Matrix();
                m1.traslacion(transX, transY);
                punto[0] = p2.getX() - panel.oX;
                punto[1] = p2.getY() - panel.oY;
                punto[2] = 1;
                m1.rotacion(rotar);
                m1.traslacion(transX * (-1), transY * (-1));
                punto2 = m1.pprima(punto);
                p2.setLocation(punto2[0] + panel.oX, punto2[1] + panel.oY);

                punto[0] = p3.getX();
                punto[1] = p3.getY();
                punto[2] = 1;

                Matrix m2 = new Matrix();
                m2.traslacion(transX, transY);
                punto[0] = p3.getX() - panel.oX;
                punto[1] = p3.getY() - panel.oY;
                punto[2] = 1;
                m2.rotacion(rotar);
                m2.traslacion(transX * (-1), transY * (-1));
                punto2 = m2.pprima(punto);
                p3.setLocation(punto2[0] + panel.oX, punto2[1] + panel.oY);

                Vertex2D v1 = new Vertex2D(p1.x, p1.y, t.color.getRGB());
                Vertex2D v2 = new Vertex2D(p2.x, p2.y, t.color.getRGB());
                Vertex2D v3 = new Vertex2D(p3.x, p3.y, t.color.getRGB());

                TrianguloR tri = new TrianguloR(v1, v2, v3, t.color);
                panel.aFiguras.set(n, tri);
                dibujarFiguras();
            }

            if (f instanceof Circulo) {
                Circulo cr = (Circulo) f;
                dibujarFiguras();
            }

            if (f instanceof Cuadrado) {
                Cuadrado cd = (Cuadrado) f;
                panel.dibujarTriangulo(cd.puntoA, cd.puntoB, cd.puntoC,Color.WHITE, false);
                panel.dibujarTriangulo(cd.puntoA, cd.puntoB, cd.puntoD,Color.WHITE, false);
                double[] punto = new double[3];
                double[] punto2 = new double[3];
                int transX;
                int transY;
                int pxm = (int) ((int) cd.puntoA.getX() + cd.puntoB.getX()) / 2;
                int pym = (int) ((int) cd.puntoA.getY() + cd.puntoB.getY()) / 2;;
                int rotar = Integer.parseInt(panel.textoRotar.getText());

                transX = (pxm - panel.oX) * (-1);
                transY = (pym - panel.oY) * (-1);

                punto[0] = cd.puntoA.getX();
                punto[1] = cd.puntoA.getY();
                punto[2] = 1;

                Matrix m = new Matrix();
                m.traslacion(transX, transY);
                punto[0] = cd.puntoA.getX() - panel.oX;
                punto[1] = cd.puntoA.getY() - panel.oY;
                punto[2] = 1;
                m.rotacion(rotar);
                m.traslacion(transX * (-1), transY * (-1));
                punto2 = m.pprima(punto);
                cd.puntoA.setLocation(punto2[0] + panel.oX, punto2[1] + panel.oY);

                punto[0] = cd.puntoB.getX();
                punto[1] = cd.puntoB.getY();
                punto[2] = 1;

                Matrix m1 = new Matrix();
                m1.traslacion(transX, transY);
                punto[0] = cd.puntoB.getX() - panel.oX;
                punto[1] = cd.puntoB.getY() - panel.oY;
                punto[2] = 1;
                m1.rotacion(rotar);
                m1.traslacion(transX * (-1), transY * (-1));
                punto2 = m1.pprima(punto);
                cd.puntoB.setLocation(punto2[0] + panel.oX, punto2[1] + panel.oY);
                
                punto[0] = cd.puntoC.getX();
                punto[1] = cd.puntoC.getY();
                punto[2] = 1;

                Matrix m2 = new Matrix();
                m2.traslacion(transX, transY);
                punto[0] = cd.puntoC.getX() - panel.oX;
                punto[1] = cd.puntoC.getY() - panel.oY;
                punto[2] = 1;
                m2.rotacion(rotar);
                m2.traslacion(transX * (-1), transY * (-1));
                punto2 = m2.pprima(punto);
                cd.puntoC.setLocation(punto2[0] + panel.oX, punto2[1] + panel.oY);
                
                punto[0] = cd.puntoC.getX();
                punto[1] = cd.puntoC.getY();
                punto[2] = 1;

                Matrix m3 = new Matrix();
                m3.traslacion(transX, transY);
                punto[0] = cd.puntoD.getX() - panel.oX;
                punto[1] = cd.puntoD.getY() - panel.oY;
                punto[2] = 1;
                m3.rotacion(rotar);
                m3.traslacion(transX * (-1), transY * (-1));
                punto2 = m3.pprima(punto);
                cd.puntoD.setLocation(punto2[0] + panel.oX, punto2[1] + panel.oY);

                dibujarFiguras();
            }
            if (f instanceof Elipse) {
                Elipse el = (Elipse) f;
                panel.dibujarElipse((Point) el.puntoC, (Point) el.puntoR,(Point)el.puntoA, Color.WHITE, false);
                double[] punto = new double[3];
                double[] punto2 = new double[3];
                int transX;
                int transY;
                transX = ((int) el.puntoC.getX() - panel.oX) * (-1);
                transY = ((int) el.puntoC.getY() - panel.oY) * (-1);

                int rotar = Integer.parseInt(panel.textoRotar.getText());

                punto[0] = el.puntoR.getX();
                punto[1] = el.puntoR.getY();
                punto[2] = 1;

                Matrix m1 = new Matrix();
                m1.traslacion(transX, transY);
                punto[0] = el.puntoR.getX() - panel.oX;
                punto[1] = el.puntoR.getY() - panel.oY;
                punto[2] = 1;
                m1.rotacion(rotar);
                m1.traslacion(transX * (-1), transY * (-1));
                punto2 = m1.pprima(punto);
                el.puntoR.setLocation(punto2[0] + panel.oX, punto2[1] + panel.oY);
                
                punto[0] = el.puntoA.getX();
                punto[1] = el.puntoA.getY();
                punto[2] = 1;

                Matrix m2 = new Matrix();
                m2.traslacion(transX, transY);
                punto[0] = el.puntoA.getX() - panel.oX;
                punto[1] = el.puntoA.getY() - panel.oY;
                punto[2] = 1;
                m2.rotacion(rotar);
                m2.traslacion(transX * (-1), transY * (-1));
                punto2 = m2.pprima(punto);
                el.puntoA.setLocation(punto2[0] + panel.oX, punto2[1] + panel.oY);
                
                dibujarFiguras();
            }

        } else {

            System.out.println("Trasladar");
            int n = Integer.parseInt(panel.textoNumeroFigura.getText()) - 1;
            Figura f = panel.aFiguras.get(n);

            if (f instanceof Linea) {
                Linea l = (Linea) f;
                panel.dibujarLinea((Point) l.puntoA, (Point) l.puntoB, Color.WHITE, false);
                double[] punto = new double[3];
                double[] punto2 = new double[3];
                int transX = Integer.parseInt(panel.textoTrasladarX.getText());
                int transY = Integer.parseInt(panel.textoTrasladarY.getText());

                punto[0] = l.puntoA.getX();
                punto[1] = l.puntoA.getY();
                punto[2] = 1;

                Matrix m = new Matrix();
                m.traslacion(transX, transY * (-1));
                punto2 = m.pprima(punto);
                l.puntoA.setLocation(punto2[0], punto2[1]);

                punto[0] = l.puntoB.getX();
                punto[1] = l.puntoB.getY();
                punto[2] = 1;

                punto2 = new double[3];
                punto2 = m.pprima(punto);
                l.puntoB.setLocation(punto2[0], punto2[1]);

                dibujarFiguras();
            }

            if (f instanceof TrianguloR) {
                TrianguloR t = (TrianguloR) f;
                Point p1 = new Point();
                Point p2 = new Point();
                Point p3 = new Point();
                p1.setLocation(t.v[0].x, t.v[0].y);
                p2.setLocation(t.v[1].x, t.v[1].y);
                p3.setLocation(t.v[2].x, t.v[2].y);
                panel.dibujarTriangulo(p1, p2, p3, Color.WHITE, false);

                double[] punto = new double[3];
                double[] punto2 = new double[3];
                int transX = Integer.parseInt(panel.textoTrasladarX.getText());
                int transY = Integer.parseInt(panel.textoTrasladarY.getText());

                punto[0] = p1.getX();
                punto[1] = p1.getY();
                punto[2] = 1;

                Matrix m = new Matrix();
                m.traslacion(transX, transY * (-1));
                punto2 = m.pprima(punto);
                p1.setLocation(punto2[0], punto2[1]);

                punto[0] = p2.getX();
                punto[1] = p2.getY();
                punto[2] = 1;

                punto2 = new double[3];
                punto2 = m.pprima(punto);
                p2.setLocation(punto2[0], punto2[1]);

                punto[0] = p3.getX();
                punto[1] = p3.getY();
                punto[2] = 1;

                punto2 = new double[3];
                punto2 = m.pprima(punto);
                p3.setLocation(punto2[0], punto2[1]);

                Vertex2D v1 = new Vertex2D(p1.x, p1.y, t.color.getRGB());
                Vertex2D v2 = new Vertex2D(p2.x, p2.y, t.color.getRGB());
                Vertex2D v3 = new Vertex2D(p3.x, p3.y, t.color.getRGB());

                TrianguloR tri = new TrianguloR(v1, v2, v3, t.color);
                panel.aFiguras.set(n, tri);
                dibujarFiguras();
            }

            if (f instanceof Circulo) {
                Circulo cr = (Circulo) f;
                panel.dibujarCirculo((Point) cr.puntoC, (Point) cr.puntoR, Color.WHITE, false);
                double[] punto = new double[3];
                double[] punto2 = new double[3];
                int transX = Integer.parseInt(panel.textoTrasladarX.getText());
                int transY = Integer.parseInt(panel.textoTrasladarY.getText());

                punto[0] = cr.puntoC.getX();
                punto[1] = cr.puntoC.getY();
                punto[2] = 1;

                Matrix m = new Matrix();
                m.traslacion(transX, transY * (-1));
                punto2 = m.pprima(punto);
                cr.puntoC.setLocation(punto2[0], punto2[1]);

                punto[0] = cr.puntoR.getX();
                punto[1] = cr.puntoR.getY();
                punto[2] = 1;

                punto2 = new double[3];
                punto2 = m.pprima(punto);
                cr.puntoR.setLocation(punto2[0], punto2[1]);
                dibujarFiguras();

            }

            if (f instanceof Cuadrado) {
                Cuadrado cd = (Cuadrado) f;
                panel.dibujarTriangulo(cd.puntoA, cd.puntoB, cd.puntoC,Color.WHITE, false);
                panel.dibujarTriangulo(cd.puntoA, cd.puntoB, cd.puntoD,Color.WHITE, false);
                double[] punto = new double[3];
                double[] punto2 = new double[3];
                int transX = Integer.parseInt(panel.textoTrasladarX.getText());
                int transY = Integer.parseInt(panel.textoTrasladarY.getText());

                

                punto[0] = cd.puntoA.getX();
                punto[1] = cd.puntoA.getY();
                punto[2] = 1;

                Matrix m = new Matrix();
                m.traslacion(transX, transY* (-1));
                punto2 = m.pprima(punto);
                cd.puntoA.setLocation(punto2[0], punto2[1]);

                punto[0] = cd.puntoB.getX();
                punto[1] = cd.puntoB.getY();
                punto[2] = 1;

                Matrix m1 = new Matrix();
                m1.traslacion(transX, transY* (-1));
                punto2 = m1.pprima(punto);
                cd.puntoB.setLocation(punto2[0], punto2[1] );
                
                punto[0] = cd.puntoC.getX();
                punto[1] = cd.puntoC.getY();
                punto[2] = 1;

                Matrix m2 = new Matrix();
                m2.traslacion(transX, transY* (-1));
                punto2 = m2.pprima(punto);
                cd.puntoC.setLocation(punto2[0] , punto2[1] );
                
                punto[0] = cd.puntoD.getX();
                punto[1] = cd.puntoD.getY();
                punto[2] = 1;

                Matrix m3 = new Matrix();
                m3.traslacion(transX, transY* (-1));
                punto2 = m3.pprima(punto);
                cd.puntoD.setLocation(punto2[0] , punto2[1] );

                dibujarFiguras();
            }
            if (f instanceof Elipse) {
                Elipse el = (Elipse) f;
                panel.dibujarElipse((Point) el.puntoC, (Point) el.puntoR,(Point)el.puntoA, Color.WHITE, false);
                double[] punto = new double[3];
                double[] punto2 = new double[3];
                int transX = Integer.parseInt(panel.textoTrasladarX.getText());
                int transY = Integer.parseInt(panel.textoTrasladarY.getText());

                punto[0] = el.puntoC.getX();
                punto[1] = el.puntoC.getY();
                punto[2] = 1;

                Matrix m = new Matrix();
                m.traslacion(transX, transY* (-1));
                punto2 = m.pprima(punto);
                el.puntoC.setLocation(punto2[0], punto2[1]);

                punto[0] = el.puntoR.getX();
                punto[1] = el.puntoR.getY();
                punto[2] = 1;

                Matrix m1 = new Matrix();
                m1.traslacion(transX, transY* (-1));
                punto2 = m1.pprima(punto);
                el.puntoR.setLocation(punto2[0], punto2[1] );
                
                punto[0] = el.puntoA.getX();
                punto[1] = el.puntoA.getY();
                punto[2] = 1;

                Matrix m2 = new Matrix();
                m2.traslacion(transX, transY* (-1));
                punto2 = m2.pprima(punto);
                el.puntoA.setLocation(punto2[0] , punto2[1] );
                
                dibujarFiguras();
            }

        }
    }

}
