package fr.ensea.projet2A;

public class Point {
    private int X;
    private int Y;

    public int getX() {
        return this.X;
    }

    public int getY() {
        return this.Y;
    }

    public void setX(int x) {
        this.X = x;
    }

    public void setY(int y) {
        this.Y = y;
    }
    public Point(){
        this.X=0;
        this.Y=0;
    }

    public Point(int x, int y){
        this.X=x;
        this.Y=y;
    }

    @Override
    public String toString() {
        return "Point[" +
                "X=" + X +
                ", Y=" + Y +
                ']';
    }
}
