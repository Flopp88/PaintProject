package fr.ensea.projet2A;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Objects;

public class Drawing extends JPanel implements MouseListener,MouseMotionListener {
    private Color c;
    private int x;
    private int y;
    private String nameFigure;
    private ArrayList<Figure> list;
    private Figure figure;
    private Point Click;
    protected boolean FilledFigure;
    private BufferedImage FilePicture;


    public Drawing(){
        list= new ArrayList<>();
        this.setBackground(Color.white);
        this.c=Color.black;
        this.nameFigure="Rectangle";
        addMouseListener(this);
        addMouseMotionListener(this);
    }

    public void setColor(Color c) {
        this.c = c;
    }

    public void setNameFigure(String nameFigure) {
        this.nameFigure = nameFigure;
    }

    public void setList(ArrayList<Figure> list){
        this.list=list;
    }

    public void setFilePicture(BufferedImage filePicture) {
        FilePicture = filePicture;
    }

    @Override
    public String toString() {
        return "Drawing{" +
                "c=" + c +
                ", x=" + x +
                ", y=" + y +
                ", nameFigure='" + nameFigure + '\'' +
                ", list=" + list +
                '}';
    }

    public Color getC() {
        return c;
    }

    public ArrayList<Figure> getList() {
        return list;
    }

    public BufferedImage getFilePicture() {
        return FilePicture;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(FilePicture,0,0,null);
        for(Figure f:list){
            f.draw(g);
            this.repaint();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        this.x=e.getX();
        this.y=e.getY();
        Click=new Point(x,y);
        switch (nameFigure) {
            case "Rectangle" -> list.add(figure= new Rectangle(c, new Point(x, y)));
            case "Square" -> list.add(figure= new Square(c, new Point(x, y)));
            case "Circle" -> list.add(figure= new Circle(c,new Point(x, y)));
            case "Ellipse" -> list.add(figure= new Ellipse(c, new Point(x, y)));
            case "Line" -> list.add(figure= new Line(c, new Point(x,y)));
        }
        repaint();
        figure.setFilledFigure(FilledFigure);
        System.out.println("x="+ this.x + ",y=" +this.y + "Color=" + c + "Figure=" + nameFigure);
    }

    public void Clear(){
        this.list.clear();
    }

    public void Undo() {
        if (list.size() >= 1) {
            this.list.remove(list.size() - 1);
        }
    }

    public void Save(){
//        try{
//            FileOutputStream fos = new FileOutputStream("saveDrawing");
//            ObjectOutputStream oos = new ObjectOutputStream(fos);
//
//            oos.writeObject(list);
//            oos.close();
//            fos.close();
//            System.out.println("Saved");
//        }
//        catch (Exception e){
//            System.out.println("problem");
//        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        this.x = e.getX();
        this.y = e.getY();
        Point DraggedPoint = new Point(x, y);
        if(Objects.equals(nameFigure, "Line")) {
            figure.setBoundingBox(figure.origin, DraggedPoint);
            repaint();
        }
        else{
            if(DraggedPoint.getX() > Click.getX() & DraggedPoint.getY() > Click.getY() ){
                int heightBB = Math.abs(Click.getY() - DraggedPoint.getY());
                int widthBB = Math.abs(DraggedPoint.getX() - Click.getX());
                figure.setBoundingBox(heightBB, widthBB);
            }
            if(DraggedPoint.getX() < Click.getX() & DraggedPoint.getY() > Click.getY() ){
                figure.origin.setX(DraggedPoint.getX());
                int heightBB = Math.abs(Click.getY() - DraggedPoint.getY());
                int widthBB = Math.abs(DraggedPoint.getX() - Click.getX());
                if(heightBB<widthBB & (Objects.equals(nameFigure, "Square") | Objects.equals(nameFigure, "Circle"))){
                    figure.origin.setX(DraggedPoint.getX()+widthBB-heightBB);
                }
                figure.setBoundingBox(heightBB, widthBB);
            }
            if(DraggedPoint.getX() < Click.getX() & DraggedPoint.getY() < Click.getY() ){
                figure.origin.setX(DraggedPoint.getX());
                figure.origin.setY(DraggedPoint.getY());
                int heightBB = Math.abs(Click.getY() - DraggedPoint.getY());
                int widthBB = Math.abs(DraggedPoint.getX() - Click.getX());
                if(Objects.equals(nameFigure, "Square") | Objects.equals(nameFigure, "Circle")) {
                    if (heightBB > widthBB) {
                        figure.origin.setY(DraggedPoint.getY() + heightBB - widthBB);
                    }
                    else {
                        figure.origin.setX(DraggedPoint.getX() + widthBB - heightBB);
                    }
                }
                figure.setBoundingBox(heightBB, widthBB);
            }
            if(DraggedPoint.getX() > Click.getX() & DraggedPoint.getY() < Click.getY() ){
                figure.origin.setY(DraggedPoint.getY());
                int heightBB = Math.abs(Click.getY() - DraggedPoint.getY());
                int widthBB = Math.abs(DraggedPoint.getX() - Click.getX());
                if(heightBB>widthBB & (Objects.equals(nameFigure, "Square") | Objects.equals(nameFigure, "Circle"))){
                    figure.origin.setY(DraggedPoint.getY()+heightBB-widthBB);
                }
                figure.setBoundingBox(heightBB, widthBB);
            }
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }
}
