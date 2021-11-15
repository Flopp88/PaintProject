import java.awt.*;

public class Line extends Figure{
    protected int y_end;
    protected int x_end;

    public Line(){
        super();
    }

    public Line(Color c, int px, int py, float size){
        super(c, new Point(px, py), size);
    }


    @Override
    public void setBoundingBox(int y_end, int x_end) {
        this.x_end = x_end;
        this.y_end = y_end;
    }

    @Override
    public void draw(Graphics2D g2d) {
        g2d.setColor(this.color);
        g2d.setStroke(new BasicStroke(this.line_size));
        g2d.drawLine(this.origin.getX(), this.origin.getY(), this.x_end, this.y_end);
    }
}