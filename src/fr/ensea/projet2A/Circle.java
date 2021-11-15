import java.awt.Color;

public class Circle extends Ellipse{

    public Circle(){
        super();
    }

    public Circle(Color c, int px, int py, float size){
        super(c, px, py, size);
    }

    @Override
    public void setBoundingBox(int heightBB, int widthBB) {
        int m = Math.min(heightBB, widthBB);
        this.semiAxisX = m;
        this.semiAxisY = m;
    }

}
