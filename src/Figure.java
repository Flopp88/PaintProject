import java.awt.*;

public abstract class Figure {
    protected Color c;
    protected Point origin;
    protected boolean FilledFigure=true;

    protected abstract void setBoundingBox(int heightBB, int widthBB);
    protected abstract void setBoundingBox(Point origin, Point end);


    public abstract void draw (Graphics g);

    public Figure(){
        this.c=Color.gray;
        this.origin=new Point();
    }
    public Figure(Color c,Point p){
        this.c=c;
        this.origin=p;
    }

    @Override
    public String toString() {
        return "Figure{" +
                "c=" + c +
                '}';
    }

    public boolean isFilledFigure() {
        return FilledFigure;
    }

    public void setFilledFigure(boolean filledFigure) {
        FilledFigure = filledFigure;
    }
}


