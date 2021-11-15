package fr.ensea.projet2A;

import java.awt.*;

public class Line extends Pen{

    public Line(){
        super.c=Color.black;
    }

    public Line(Color c, Point p){
        super(c,p);
        PenPoints.add(p);
        PenPoints.add(p); //The Array list has to contain 2 points initially to set the second Point to the mouse location
    }

    @Override
    protected void setBoundingBox(Point origin, Point end) {
        super.origin=origin;
        PenPoints.set(1,end);
    }

}
