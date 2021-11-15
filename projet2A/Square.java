package fr.ensea.projet2A;

import java.awt.*;

public class Square extends Rectangle{

    public Square(){
        super.length=0;
        super.width=0;
        super.c= Color.gray;
    }

    public Square(Color c, Point p){
        super(c,p);
    }

    @Override
    public void setBoundingBox(int heightBB,int widthBB) {
        int min=Math.min(heightBB,widthBB);
        super.setBoundingBox(min, min);
    }

    @Override
    public void setLength(int length) {
        super.setLength(length);
    }

    @Override
    public void setWidth(int width) {
        super.setWidth(width);
    }
}
