package fr.ensea.projet2A;

import java.awt.*;

public class Circle extends Ellipse {

    public Circle(){
        super.semiAxisX=0;
        super.semiAxisY=0;
        super.c= Color.gray;
    }

    public Circle(Color c, Point p){
        super(c,p);
    }

    @Override
    public void setBoundingBox(int heightBB, int widthBB) {
        int min=Math.min(heightBB,widthBB);
        super.setBoundingBox(min, min);
    }

    @Override
    public void setSemiAxisX(int semiAxisX) {
        super.setSemiAxisX(semiAxisX);
    }

    @Override
    public void setSemiAxisY(int semiAxisY) {
        super.setSemiAxisY(semiAxisY);
    }


}
