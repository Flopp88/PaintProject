package fr.ensea.projet2A;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Window extends JFrame implements ActionListener, ChangeListener {
    protected Drawing drawPanel=new Drawing();
    static final int MIN_Thickness=0;
    static final int MAX_Thickness=20;
    static final int INIT_Thickness=1;

    public Window(String Title,int x,int y) {
        super(Title);
        this.setSize(x, y);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contentPanel = this.getContentPane();

        JMenuBar m = new JMenuBar();

        JMenu File = new JMenu("File");
        JMenuItem Open = new JMenuItem("Open");
        Open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_DOWN_MASK));
        JMenuItem New = new JMenuItem("New");
        New.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));
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

        JMenu BackgroundSelection= new JMenu("Background Color");
        JRadioButton WhiteBackground= new JRadioButton("White ");
        JRadioButton BlackBackground= new JRadioButton("Black ");
        JRadioButton GreenBackground= new JRadioButton("Green ");
        JRadioButton BlueBackground= new JRadioButton("Blue ");
        JRadioButton RedBackground= new JRadioButton("Red ");
        JRadioButton YellowBackground= new JRadioButton("Yellow ");
        JRadioButton OrangeBackground= new JRadioButton("Orange ");
        JRadioButton MagentaBackground= new JRadioButton("Magenta ");
        JRadioButton PinkBackground= new JRadioButton("Pink ");

        ButtonGroup bg= new ButtonGroup();

        bg.add(WhiteBackground);
        bg.add(BlackBackground);
        bg.add(GreenBackground);
        bg.add(BlueBackground);
        bg.add(RedBackground);
        bg.add(YellowBackground);
        bg.add(OrangeBackground);
        bg.add(MagentaBackground);
        bg.add(PinkBackground);

        BackgroundSelection.add(WhiteBackground);
        BackgroundSelection.add(BlackBackground);
        BackgroundSelection.add(GreenBackground);
        BackgroundSelection.add(BlueBackground);
        BackgroundSelection.add(RedBackground);
        BackgroundSelection.add(YellowBackground);
        BackgroundSelection.add(OrangeBackground);
        BackgroundSelection.add(MagentaBackground);
        BackgroundSelection.add(PinkBackground);

        JCheckBox Fill= new JCheckBox("Filled Figures");

        JSlider Thickness=new JSlider(JSlider.HORIZONTAL,MIN_Thickness,MAX_Thickness,INIT_Thickness);
        Thickness.setMajorTickSpacing(10);
        Thickness.setMinorTickSpacing(1);
        Thickness.setPaintTicks(true);
        Thickness.setPaintLabels(true);

        JLabel title=new JLabel("Thickness");

        Options.add(title);
        Options.add(Thickness);
        Options.add(Fill);
        Options.add(BackgroundSelection);
        Options.addSeparator();
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
        JButton White= new JButton("White");
        White.setBackground(Color.white);


        JButton Square= new JButton("Square");
        JButton Rectangle= new JButton("Rectangle");
        JButton Circle= new JButton("Circle");
        JButton Ellipse= new JButton("Ellipse");
        JButton Line= new JButton("Line");
        JButton Pen= new JButton("Pen");



        JPanel Panel=new JPanel();
        JPanel FigurePanel=new JPanel();
        JPanel ColorPanel=new JPanel();


        Panel.setLayout(new GridLayout(1,2));
        FigurePanel.setLayout(new GridLayout(2,2));
        ColorPanel.setLayout(new GridLayout(3,3));

        ColorPanel.add(Green);
        ColorPanel.add(Blue);
        ColorPanel.add(Black);
        ColorPanel.add(Orange);
        ColorPanel.add(Yellow);
        ColorPanel.add(Red);
        ColorPanel.add(Magenta);
        ColorPanel.add(Pink);
        ColorPanel.add(White);


        FigurePanel.add(Rectangle);
        FigurePanel.add(Ellipse);
        FigurePanel.add(Line);
        FigurePanel.add(Square);
        FigurePanel.add(Circle);
        FigurePanel.add(Pen);

        contentPanel.add(Panel,"South");
        Panel.add(ColorPanel);
        Panel.add(FigurePanel);
        contentPanel.add(drawPanel);

        Square.addActionListener(this);
        Rectangle.addActionListener(this);
        Circle.addActionListener(this);
        Ellipse.addActionListener(this);
        Line.addActionListener(this);
        Pen.addActionListener(this);


        Black.addActionListener(this);
        Blue.addActionListener(this);
        Red.addActionListener(this);
        Green.addActionListener(this);
        Yellow.addActionListener(this);
        Orange.addActionListener(this);
        Magenta.addActionListener(this);
        Pink.addActionListener(this);
        White.addActionListener(this);

        BlackBackground.addActionListener(this);
        WhiteBackground.addActionListener(this);
        GreenBackground.addActionListener(this);
        BlueBackground.addActionListener(this);
        RedBackground.addActionListener(this);
        MagentaBackground.addActionListener(this);
        OrangeBackground.addActionListener(this);
        YellowBackground.addActionListener(this);
        PinkBackground.addActionListener(this);

        Open.addActionListener(this);
        New.addActionListener(this);
        Save.addActionListener(this);
        Undo.addActionListener(this);
        Clear.addActionListener(this);
        Authors.addActionListener(this);
        Quit.addActionListener(this);
        Fill.addActionListener(this);
        Thickness.addChangeListener(this);

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
            case "Pen" -> drawPanel.setNameFigure("Pen");
            case "Filled Figures" -> drawPanel.FilledFigure=!drawPanel.FilledFigure;

            case "Black" -> drawPanel.setColor(Color.black);
            case "White" -> drawPanel.setColor(Color.white);
            case "Blue" -> drawPanel.setColor(Color.blue);
            case "Red" -> drawPanel.setColor(Color.red);
            case "Green" -> drawPanel.setColor(Color.green);
            case "Yellow"-> drawPanel.setColor(Color.yellow);
            case "Orange" -> drawPanel.setColor(Color.orange);
            case "Magenta" -> drawPanel.setColor(Color.magenta);
            case "Pink" -> drawPanel.setColor(Color.pink);
            case "Quit" -> {
                if (JOptionPane.showConfirmDialog(null, "Close Paint?", "WARNING", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    dispose();
                }
            }
            case "Author" -> {
                JOptionPane info=new JOptionPane();
                JOptionPane.showInternalMessageDialog(info, "Author: POLSTER--PRIETO Florian", "Information",JOptionPane.INFORMATION_MESSAGE);
            }
            case "Black " -> this.drawPanel.setBackground(Color.black);
            case "White " -> this.drawPanel.setBackground(Color.white);
            case "Green " -> this.drawPanel.setBackground(Color.green);
            case "Blue " -> this.drawPanel.setBackground(Color.blue);
            case "Red " -> this.drawPanel.setBackground(Color.red);
            case "Yellow " -> this.drawPanel.setBackground(Color.yellow);
            case "Magenta " -> this.drawPanel.setBackground(Color.magenta);
            case "Pink " -> this.drawPanel.setBackground(Color.pink);
            case "Orange " -> this.drawPanel.setBackground(Color.orange);
            case "Undo" -> drawPanel.Undo();
            case "Clear" -> {
                if (JOptionPane.showConfirmDialog(null, "Delete your drawings?", "WARNING", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    drawPanel.setFilePicture(null);
                    drawPanel.setBackground(Color.white);
                    drawPanel.Clear();
                    drawPanel.paintComponent(drawPanel.getGraphics());
                }
            }
            case "Open" ->{
                BufferedImage pictureFile;
                try {
                    JFileChooser f = new JFileChooser();
                    f.setFileSelectionMode(JFileChooser.FILES_ONLY);
                    f.setFileFilter(new FileNameExtensionFilter("Image", "jpg", "png", "gif"));
                    int mode = f.showOpenDialog(null);

                    if (mode == JFileChooser.APPROVE_OPTION){ //to ensure nothing is opened if the cancel button is selected
                        pictureFile = ImageIO.read(new File(String.valueOf(f.getSelectedFile())));
                        if (pictureFile.getHeight() > drawPanel.getHeight()){
                            pictureFile = compressImage(pictureFile, BufferedImage.TYPE_INT_ARGB, pictureFile.getWidth(), drawPanel.getHeight());
                        }
                        if (pictureFile.getWidth() > drawPanel.getWidth()){
                            pictureFile = compressImage(pictureFile, BufferedImage.TYPE_INT_ARGB, drawPanel.getWidth(), pictureFile.getHeight());
                        }
                        drawPanel.Clear();
                        this.drawPanel.setFilePicture(pictureFile);
                        drawPanel.paintComponent(drawPanel.getGraphics());
                    }
                }
                catch (IOException ex){
                    ex.printStackTrace();
                }
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
                    int mode = f.showSaveDialog(null);

                    if(mode==JFileChooser.APPROVE_OPTION) {
                        if (String.valueOf(f.getSelectedFile()).endsWith(".png") | String.valueOf(f.getSelectedFile()).endsWith(".jpg")) {
                            ImageIO.write(im, "PNG", new File(String.valueOf(f.getSelectedFile())));
                        } else {
                            ImageIO.write(im, "PNG", new File(f.getSelectedFile() + ".png"));
                            //if the user forgets to specify the type of the file, we ensure it is saved as .png to be able to open it afterwards
                        }
                    }
                }
                catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    public void stateChanged(ChangeEvent e){
        JSlider source = (JSlider)e.getSource();
        if (!source.getValueIsAdjusting()) {
            drawPanel.Thickness = source.getValue();
        }
    }

    private BufferedImage compressImage(BufferedImage originalImage, int type, int width, int height) {
        BufferedImage resizedImage = new BufferedImage(width, height, type);
        Graphics2D g = resizedImage.createGraphics();
        g.drawImage(originalImage, 0, 0, width, height, null);
        g.dispose();

        return resizedImage;
    }
}