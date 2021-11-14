package fr.ensea.projet2A;

import java.awt.*;
import java.util.ArrayList;

public class Pen extends Figure{
    protected ArrayList<Point> PenPoints;

    public Pen(Color c, Point p){
        super(c,p);
        PenPoints= new ArrayList<>();
    }

    @Override
    public void appendPoint(Point p) {
        PenPoints.add(p);
    }

    @Override
    protected void setBoundingBox(int heightBB, int widthBB) {

    }

    @Override
    protected void setBoundingBox(Point origin, Point end) {

    }

    @Override
    public void draw(Graphics g) {
        g.setColor(c);
        int k;
        for(k=0;k<PenPoints.size()-1;k++){
            Point Begin= PenPoints.get(k);
            Point End= PenPoints.get(k+1);
            Graphics2D g2d = (Graphics2D) g;
            g2d.setStroke(new BasicStroke(Thickness));
            g2d.drawLine(Begin.getX(), Begin.getY(), End.getX(), End.getY());
        }

    }
}
