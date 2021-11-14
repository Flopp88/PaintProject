package fr.ensea.projet2A;

import java.awt.*;

public class Line extends Figure{
    protected int length;
    protected int width;
    protected Point end;

    public Line(){
        this.length=0;
        this.width=0;
        super.c=Color.gray;
        this.end=new Point();
    }

    public Line(Color c, Point p){
        super(c,p);
        this.end=p;
    }

    @Override
    public void appendPoint(Point p) {

    }


    @Override
    protected void setBoundingBox(int heightBB, int widthBB) {
        this.length=heightBB;
        this.width=widthBB;
    }

    @Override
    protected void setBoundingBox(Point origin, Point end) {
        super.origin=origin;
        this.end=end;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(c);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(Thickness));
        g.drawLine(origin.getX(),origin.getY(),end.getX(),end.getY());
    }

}
