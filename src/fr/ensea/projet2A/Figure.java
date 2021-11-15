import java.awt.*;

public abstract class Figure{

    protected Color color;
    protected Point origin;
    protected float line_size;

    public Figure(Color c, Point x, float size){
        this.color = c;
        this.origin = x;
        this.line_size = size;
    }

    public Figure(){
        this.color = Color.black;
        this.origin = new Point();
        this.line_size = 1;
    }

    public abstract void setBoundingBox (int heightBB, int widthBB);
    public abstract void draw (Graphics2D g2d);

    public Color getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Figure{" +
                "color=" + color +
                '}';
    }
}