package fr.ensea.projet2A;

import java.awt.*;

public class Ellipse extends Figure{
    protected int semiAxisX;
    protected int semiAxisY;

    public Ellipse(){
        semiAxisX=0;
        semiAxisY=0;
        super.c=Color.gray;
    }

    public Ellipse(Color c, Point p){
        super(c,p);
    }

    @Override
    public void setBoundingBox(int heightBB, int widthBB) {
        this.semiAxisX=widthBB/2;
        this.semiAxisY=heightBB/2;
    }

    @Override
    protected void setBoundingBox(Point origin, Point end) {

    }

    @Override
    public void draw(Graphics g) {
        g.setColor(c);
        if(isFilledFigure()) {
            g.fillOval(origin.getX(), origin.getY(), this.semiAxisX * 2, this.semiAxisY * 2);
        }
        else{
            g.drawOval(origin.getX(), origin.getY(), this.semiAxisX * 2, this.semiAxisY * 2);
        }
    }

    @Override
    public String toString() {
        return "Ellipse{" +
                "semiAxisX=" + semiAxisX +
                ", semiAxisY=" + semiAxisY +
                ", c=" + c +
                ", origin=" + origin +
                '}';
    }

    public void setSemiAxisX(int semiAxisX) {
        this.semiAxisX = semiAxisX;
    }

    public void setSemiAxisY(int semiAxisY) {
        this.semiAxisY = semiAxisY;
    }

    public int getSemiAxisX() {
        return semiAxisX;
    }

    public int getSemiAxisY() {
        return semiAxisY;
    }

    public double getSurface(){
        return Math.PI*semiAxisY*semiAxisX;
    }

    public double getPerimeter(){
        double a = this.semiAxisY;
        double b = this.semiAxisY;
        double product = (3*a+b)*(a+3*b);

        return Math.PI *( 3*(a+b) - Math.sqrt(product));
    }
}
