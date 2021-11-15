import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class Ellipse extends Figure{
    protected int semiAxisY;
    protected int semiAxisX;
    protected Point p;

    public Ellipse(){
        super(Color.BLACK, new Point(), 1);
        this.semiAxisY = 0;
        this.semiAxisX = 0;
    }

    public Ellipse(Color c){
        super(c, new Point(), 1);
        this.semiAxisY = 0;
        this.semiAxisX = 0;
    }

    public Ellipse(Color c, int px, int py, float size){
        super(c, new Point(px, py), size);
        this.semiAxisY = 0;
        this.semiAxisX = 0;
    }

    @Override
    public void setBoundingBox(int heightBB, int semiAxisXBB) {
        this.semiAxisY = heightBB;
        this.semiAxisX = semiAxisXBB;
    }

    public void draw(Graphics2D g2d) {

        g2d.setColor(this.color);

        if (this.line_size == 6) {
            g2d.fill(new Ellipse2D.Float(this.origin.getX(), this.origin.getY(), this.semiAxisX, this.semiAxisY));
        }
        else {
            g2d.setStroke(new BasicStroke(this.line_size));
            g2d.draw(new Ellipse2D.Float(this.origin.getX(), this.origin.getY(), this.semiAxisX, this.semiAxisY));
        }
    }

    public int getSemiAxisY() {
        return this.semiAxisY;
    }

    public int getSemiAxisX() {
        return this.semiAxisX;
    }

    public double getPerimeter(){
        //As the perimeter of an ellipse cannot be calculated exactly, we use
        //Ramanujan's first formula to approximate it up to 0.01% error.

        double a = this.semiAxisY;
        double b = this.semiAxisY;
        double product = (3*a+b)*(a+3*b);

        return Math.PI *( 3*(a+b) - Math.sqrt(product));
    }

    public double getSurface(){
        return Math.PI * this.semiAxisY * this.semiAxisX;
    }

    public void setSemiAxisY(int semiAxisY) {
        this.semiAxisY = semiAxisY;
    }

    public void setSemiAxisX(int semiAxisX) {
        this.semiAxisX = semiAxisX;
    }

    @Override
    public String toString() {
        return "Ellipse{" +
                "semiAxisY=" + semiAxisY +
                ", semiAxisX=" + semiAxisX +
                ", p=" + p +
                '}';
    }
}

