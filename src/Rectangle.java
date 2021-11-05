import java.awt.*;

public class Rectangle extends Figure{
    protected int length;
    protected int width;

    public Rectangle(int length, int width, Color c){
        this.length=length;
        this.width=width;
        super.c=c;
    }

    public Rectangle(Color c, Point p){
        super(c,p);
    }

    public Rectangle(){
        this.length=0;
        this.width=0;
        super.c=Color.gray;
    }
    @Override
    public void draw(Graphics g) {
        g.setColor(c);
        if(isFilledFigure()) {
            g.fillRect(origin.getX(), origin.getY(), this.width, this.length);
        }
        else{
            g.drawRect(origin.getX(), origin.getY(), this.width, this.length);
        }
    }

    @Override
    public void setBoundingBox(int heightBB, int widthBB) {
        this.length=heightBB;
        this.width=widthBB;
    }

    @Override
    protected void setBoundingBox(Point origin, Point end) {

    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "c=" + c +
                ", origin=" + origin +
                ", length=" + length +
                ", width=" + width +
                '}';
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public int getPerimeter(){
        return 2*length+2*width;
    }

    public int getSurface(){
        return length*width;
    }
}
