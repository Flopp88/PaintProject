package fr.ensea.projet2A;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Window extends JFrame implements ActionListener{
    protected Drawing drawPanel=new Drawing();

    public Window(String Title,int x,int y) {
        super(Title);
        this.setSize(x, y);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contentPanel = this.getContentPane();

        JMenuBar m = new JMenuBar();

        JMenu File = new JMenu("File");
        JMenuItem Open = new JMenuItem("Open");
        JMenuItem New = new JMenuItem("New");
        JMenuItem Save= new JMenuItem("Save");
        Save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
        JMenuItem Quit= new JMenuItem("Quit");
        Quit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, InputEvent.ALT_DOWN_MASK));

        File.add(Open);
        File.addSeparator();
        File.add(New);
        File.add(Save);
        File.addSeparator();
        File.add(Quit);

        JMenu About= new JMenu("About");
        JMenuItem Authors= new JMenuItem("Author");

        About.add(Authors);

        JMenu Options= new JMenu("Options");
        JMenuItem Undo= new JMenuItem("Undo");
        Undo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, InputEvent.CTRL_DOWN_MASK));
        JMenuItem Clear= new JMenuItem("Clear");
        Clear.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.CTRL_DOWN_MASK));

        Options.add(Undo);
        Options.add(Clear);

        m.add(File);
        m.add(About);
        m.add(Options);

        JButton Green= new JButton("Green");
        Green.setBackground(Color.green);
        JButton Blue= new JButton("Blue");
        Blue.setForeground(Color.white);
        Blue.setBackground(Color.blue);
        JButton Orange= new JButton("Orange");
        Orange.setBackground(Color.orange);
        JButton Black= new JButton("Black");
        Black.setBackground(Color.black);
        Black.setForeground(Color.white);
        JButton Yellow= new JButton("Yellow");
        Yellow.setBackground(Color.yellow);
        JButton Red= new JButton("Red");
        Red.setBackground(Color.red);
        JButton Magenta= new JButton("Magenta");
        Magenta.setBackground(Color.magenta);
        JButton Pink= new JButton("Pink");
        Pink.setBackground(Color.pink);

        JButton Square= new JButton("Square");
        JButton Rectangle= new JButton("Rectangle");
        JButton Circle= new JButton("Circle");
        JButton Ellipse= new JButton("Ellipse");
        JButton Line= new JButton("Line");
        JCheckBox Fill= new JCheckBox("Fill");

        JPanel Panel=new JPanel();
        JPanel FigurePanel=new JPanel();
        JPanel ColorPanel=new JPanel();


        Panel.setLayout(new GridLayout(1,2));
        FigurePanel.setLayout(new GridLayout(2,2));
        ColorPanel.setLayout(new GridLayout(2,4));

        ColorPanel.add(Green);
        ColorPanel.add(Blue);
        ColorPanel.add(Black);
        ColorPanel.add(Orange);
        ColorPanel.add(Yellow);
        ColorPanel.add(Red);
        ColorPanel.add(Magenta);
        ColorPanel.add(Pink);


        FigurePanel.add(Rectangle);
        FigurePanel.add(Ellipse);
        FigurePanel.add(Line);
        FigurePanel.add(Square);
        FigurePanel.add(Circle);
        FigurePanel.add(Fill);

        contentPanel.add(Panel,"South");
        Panel.add(ColorPanel);
        Panel.add(FigurePanel);
        contentPanel.add(drawPanel);

        Square.addActionListener(this);
        Rectangle.addActionListener(this);
        Circle.addActionListener(this);
        Ellipse.addActionListener(this);
        Line.addActionListener(this);
        Fill.addActionListener(this);

        Black.addActionListener(this);
        Blue.addActionListener(this);
        Red.addActionListener(this);
        Green.addActionListener(this);
        Yellow.addActionListener(this);
        Orange.addActionListener(this);
        Magenta.addActionListener(this);
        Pink.addActionListener(this);

        Open.addActionListener(this);
        New.addActionListener(this);
        Save.addActionListener(this);
        Undo.addActionListener(this);
        Clear.addActionListener(this);
        Authors.addActionListener(this);
        Quit.addActionListener(this);

        this.setJMenuBar(m);

        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        String cmd=e.getActionCommand();


        switch (cmd) {
            case "Square" -> drawPanel.setNameFigure("Square");
            case "Rectangle" -> drawPanel.setNameFigure("Rectangle");
            case "Circle" -> drawPanel.setNameFigure("Circle");
            case "Ellipse" -> drawPanel.setNameFigure("Ellipse");
            case "Line" -> drawPanel.setNameFigure("Line");
            case "Fill" -> drawPanel.FilledFigure=!drawPanel.FilledFigure;
            case "Black" -> drawPanel.setColor(Color.black);
            case "Blue" -> drawPanel.setColor(Color.blue);
            case "Red" -> drawPanel.setColor(Color.red);
            case "Green" -> drawPanel.setColor(Color.green);
            case "Yellow"-> drawPanel.setColor(Color.yellow);
            case "Orange" -> drawPanel.setColor(Color.orange);
            case "Magenta" -> drawPanel.setColor(Color.magenta);
            case "Pink" -> drawPanel.setColor(Color.pink);
            case "Quit" -> {
                if (JOptionPane.showConfirmDialog(null, "Close Paint?", "WARNING",
                        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    dispose();
                }
            }
            case "Authors" -> {
                JOptionPane info=new JOptionPane();
                JOptionPane.showInternalMessageDialog(info, "Author: POLSTER--PRIETO Florian", "Information",JOptionPane.INFORMATION_MESSAGE);
            }
            case "Undo" -> drawPanel.Undo();
            case "Clear" -> {
                if (JOptionPane.showConfirmDialog(null, "Delete your drawings?", "WARNING",
                        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    drawPanel.Clear();
                    drawPanel.setFilePicture(null);
                    drawPanel.paintComponent(drawPanel.getGraphics());
                }
            }
            case "Open" ->{
                BufferedImage pictureFile=null;
                try {
                    JFileChooser f=new JFileChooser();
                    f.setFileSelectionMode(JFileChooser.FILES_ONLY);
                    f.setFileFilter(new FileNameExtensionFilter("Image","jpg","png"));
                    f.showOpenDialog(null);

                    System.out.println("load");
                    pictureFile = ImageIO.read(new File(String.valueOf(f.getSelectedFile())));

                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                assert pictureFile != null;
                if(pictureFile.getHeight()>drawPanel.getHeight() | pictureFile.getWidth()>drawPanel.getWidth()) {
                    pictureFile= compressImage(pictureFile, BufferedImage.TYPE_INT_ARGB, drawPanel.getWidth(), drawPanel.getHeight());
                }
                drawPanel.Clear();
                this.drawPanel.setFilePicture(pictureFile);
                drawPanel.paintComponent(drawPanel.getGraphics());
            }
            case "New" -> new Window("Paint",800,600);
            case "Save" -> {
                Container cPanel = drawPanel;
                BufferedImage im = new BufferedImage(cPanel.getWidth(), cPanel.getHeight(), BufferedImage.TYPE_INT_ARGB);
                cPanel.paint(im.getGraphics());
                try {
                    JFileChooser f=new JFileChooser();
                    f.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
                    f.setFileFilter(new FileNameExtensionFilter("Image","jpg","png"));
                    f.showSaveDialog(null);

                    ImageIO.write(im, "PNG", new File(String.valueOf(f.getSelectedFile())));
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    private static BufferedImage compressImage(BufferedImage originalImage, int type, int width, int height) {
        BufferedImage resizedImage = new BufferedImage(width, height, type);
        Graphics2D g = resizedImage.createGraphics();
        g.drawImage(originalImage, 0, 0, width, height, null);
        g.dispose();/* w w w  .  ja  v  a2 s .c  o m*/

        return resizedImage;
    }
}