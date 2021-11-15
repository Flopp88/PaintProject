import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Rectangle extends Figure{
    protected int length;
    protected int width;

    public Rectangle(){
        super(Color.BLACK, new Point(), 1);
        this.length = 0;
        this.width = 0;
    }

    public Rectangle(Color c){
        super(c, new Point(), 1);
        this.length = 0;
        this.width = 0;
    }

    public Rectangle(Color c, int px, int py, float size){
        super(c, new Point(px, py), size);
        this.length = 0;
        this.width = 0;
    }

    @Override
    public void setBoundingBox(int heightBB, int widthBB) {
        this.length = heightBB;
        this.width = widthBB;
    }

    public void draw(Graphics2D g2d) {
        g2d.setColor(this.color);

        if (this.line_size == 6) {
            g2d.fill(new Rectangle2D.Float(this.origin.getX(), this.origin.getY(), this.width, this.length));
        }
        else {
            g2d.setStroke(new BasicStroke(this.line_size));
            g2d.draw(new Rectangle2D.Float(this.origin.getX(), this.origin.getY(), this.width, this.length));
        }

    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public int getPerimeter(){
        return 2*(this.length + this.width);
    }

    public int getSurface(){
        return this.length * this.width;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setColor(Color c){ this.color = c; }

    @Override
    public String toString() {
        return "Rectangle{" +
                "length=" + length +
                ", width=" + width +
                '}';
    }
}
