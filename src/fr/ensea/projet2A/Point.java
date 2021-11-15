public class Point {
    private int X;
    private int Y;

    public Point() {
        this.X = 0;
        this.Y = 0;
    }

    public Point(int a, int b){
        this.X = a;
        this.Y = b;
    }

    public int getX() {
        return this.X;
    }

    public int getY() {
        return this.Y;
    }

    public void setX(int x){
        this.X = x;
    }

    public void setY(int y) {
        this.Y = y;
    }

    @Override
    public String toString() {
        return "(" + X +
                "," + Y +
                ')';
    }
}