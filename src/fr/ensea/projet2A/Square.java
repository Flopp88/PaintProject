import java.awt.Color;

public class Square extends Rectangle{

    public Square(){
        super();
    }

    public Square(Color c, int px, int py, float size){
        super(c, px, py, size);
    }

    @Override
    public void setBoundingBox(int heightBB, int widthBB) {
        int m = Math.min(heightBB, widthBB);
        this.length = m;
        this.width = m;
    }

}
