import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Drawing extends JPanel implements MouseMotionListener,MouseListener {

    private Color color;
    private ArrayList<Figure> list_fig;
    private String nameFigure;
    private int current = -1;
    private float size_lines = 1;
    private BufferedImage filePicture;
    private int x;
    private int y;

    public Drawing(){
        super();
        this.list_fig = new ArrayList<>();
        this.setBackground(Color.WHITE);
        this.color = Color.BLACK;
        this.nameFigure = "Rectangle";
    }

    public void setColor(Color color) { this.color = color; }

    public Color getColor() { return this.color; }

    public void setSize_lines(float size) { this.size_lines = size;}

    public void setNameFigure(String name) { this.nameFigure = name; }
    
    public void setFilePicture(BufferedImage filePicture) { this.filePicture = filePicture; }

    public void clear(){
        // Clears every figure
        this.list_fig.clear();
        this.current = -1;
        this.repaint();
    }

    public void undo(){
        // Deletes the last figure
        if (current >= 0) {
            this.list_fig.remove(current);
            this.current -= 1;
            this.repaint();
        }
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        //We draw the background image if there is one
        g.drawImage(this.filePicture,0,0,null);

        //Here we initialize a graphics 2D to adjust some parameters
        //Like the width of the basic strokes used to draw the shapes.
        Graphics2D g2d = (Graphics2D)g.create();

        for (Figure figure:list_fig){
            figure.draw(g2d);
        }

        g2d.dispose();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        // Defines the figure drawn when the mouse is dragged

        int width = e.getX() - this.x;
        int height = e.getY() - this.y;

        int heightBB = Math.abs(height);
        int widthBB = Math.abs(width);

        //We adjust the code to get a square or a circle by using sides to simplify
        //the calculus needed. Otherwise we just consider the distances
        switch (nameFigure){
            case "Line" -> this.list_fig.get(current).setBoundingBox(e.getY(), e.getX());

            case "Square", "Circle" -> {
                int side = Math.min(widthBB, heightBB);

                if (width < 0 & height > 0) {
                    this.list_fig.get(current).origin.setX(this.x - side);
                    this.list_fig.get(current).origin.setY(this.y);
                }
                else if (width > 0 & height < 0){
                    this.list_fig.get(current).origin.setX(this.x);
                    this.list_fig.get(current).origin.setY(this.y - side);
                }
                else if (width < 0 & height < 0){
                    this.list_fig.get(current).origin.setX(this.x - side);
                    this.list_fig.get(current).origin.setY(this.y - side);
                }
                this.list_fig.get(current).setBoundingBox(heightBB, widthBB);
            }

            default -> {
                if (width < 0 & height > 0){
                    this.list_fig.get(current).origin.setX(width + this.x);
                }
                else if (width > 0 & height < 0){
                    this.list_fig.get(current).origin.setY(height + this.y);
                }
                else if (width < 0 & height < 0){
                    this.list_fig.get(current).origin.setX(width + this.x);
                    this.list_fig.get(current).origin.setY(height + this.y);
                }
                this.list_fig.get(current).setBoundingBox(heightBB, widthBB);
            }
        }
        this.repaint();

    }

    @Override
    public void mousePressed(MouseEvent e) {
        //Adds a figure to the list when the mouse is pressed

        this.x = e.getX();
        this.y = e.getY();

        switch (nameFigure) {
            case "Rectangle" -> list_fig.add(new Rectangle(this.color, this.x, this.y, this.size_lines));
            case "Square" -> list_fig.add(new Square(this.color, this.x, this.y, this.size_lines));
            case "Circle" -> list_fig.add(new Circle(this.color, this.x, this.y, this.size_lines));
            case "Ellipse" -> list_fig.add(new Ellipse(this.color, this.x, this.y, this.size_lines));
            case "Line" -> list_fig.add(new Line(this.color, this.x, this.y, this.size_lines));
        }
        this.current +=1;
    }


    @Override
    public void mouseMoved(MouseEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

}
