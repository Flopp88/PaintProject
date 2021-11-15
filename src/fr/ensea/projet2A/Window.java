import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.security.Key;
import java.util.Hashtable;

public class Window extends JFrame implements ActionListener, ChangeListener {

        protected Drawing draw = new Drawing();


        public Window(String Title, int x, int y) {
                super(Title);
                this.setSize(x, y);
                //this.setPreferredSize(new Dimension(x, y));
                this.setVisible(true);
                this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                Container contentPanel = this.getContentPane();


                //Here we set the menu and submenus
                JMenuBar MenuBar = new JMenuBar();

                JMenu menu1 = new JMenu("File");
                JMenuItem New = new JMenuItem("New");
                New.addActionListener(this);
                New.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));
                menu1.add(New);
                menu1.addSeparator();
                JMenuItem Open = new JMenuItem("Open");
                JMenuItem Save = new JMenuItem("Save");
                Open.addActionListener(this);
                Save.addActionListener(this);
                Save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
                Open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_DOWN_MASK));
                menu1.add(Open);
                menu1.add(Save);
                menu1.addSeparator();
                JMenuItem Quit = new JMenuItem("Quit");
                Quit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_DOWN_MASK));
                Quit.addActionListener(this);
                menu1.add(Quit);

                JMenu menu2 = new JMenu("Edit");
                JMenuItem Undo =  new JMenuItem("Undo");
                Undo.addActionListener(this);
                Undo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, InputEvent.CTRL_DOWN_MASK));
                menu2.add(Undo);

                JMenu menu3 = new JMenu("About");
                JMenuItem Author = new JMenuItem("Author");
                Author.addActionListener(this);
                menu3.add(Author);

                MenuBar.add(menu1);
                MenuBar.add(menu2);
                MenuBar.add(menu3);

                JSlider set_size = new JSlider(JSlider.HORIZONTAL, 1, 6, 1);
                set_size.setMinorTickSpacing(1);

                //Create the label table for the slider
                Hashtable<Integer, JLabel> labelTable = new Hashtable<>();
                labelTable.put( 1, new JLabel("1") );
                labelTable.put( 3, new JLabel("<- Size of the brush ->") );
                labelTable.put( 5, new JLabel("5") );
                labelTable.put( 6, new JLabel("Fill") );
                set_size.setLabelTable( labelTable );

                set_size.setPaintTicks(true);
                set_size.setPaintLabels(true);
                set_size.addChangeListener(this);

                //We add here the panels and buttons of our Paint
                //First the panel with colors
                JPanel southPanel1 = new JPanel();
                southPanel1.setLayout(new GridLayout(2, 4));

                JButton Black = new JButton("Black");
                Black.setBackground(Color.BLACK);
                Black.setForeground(Color.WHITE);
                Black.addActionListener(this);
                southPanel1.add(Black);

                JButton Yellow = new JButton("Yellow");
                Yellow.setBackground(Color.YELLOW);
                Yellow.addActionListener(this);
                southPanel1.add(Yellow);

                JButton Red = new JButton("Red");
                Red.setBackground(Color.RED);
                Red.addActionListener(this);
                southPanel1.add(Red);

                JButton Pink = new JButton("Pink");
                Pink.setBackground(Color.PINK);
                Pink.addActionListener(this);
                southPanel1.add(Pink);

                JButton Green = new JButton("Green");
                Green.setBackground(Color.GREEN);
                Green.addActionListener(this);
                southPanel1.add(Green);

                JButton Magenta = new JButton("Magenta");
                Magenta.setBackground(Color.MAGENTA);
                Magenta.addActionListener(this);
                southPanel1.add(Magenta);

                JButton Blue = new JButton("Blue");
                Blue.setBackground(Color.BLUE);
                Blue.addActionListener(this);
                southPanel1.add(Blue);

                JButton Orange = new JButton("Orange");
                Orange.setBackground(Color.ORANGE);
                Orange.addActionListener(this);
                southPanel1.add(Orange);

                JButton White = new JButton("White");
                White.setBackground(Color.WHITE);
                White.addActionListener(this);

                //Then the one with figures
                JPanel southPanel2 = new JPanel();
                southPanel2.setLayout(new GridLayout(2, 2));

                JButton ellipse = new JButton("Ellipse");
                ellipse.addActionListener(this);
                southPanel2.add(ellipse);

                JButton circle = new JButton("Circle");
                circle.addActionListener(this);
                southPanel2.add(circle);

                JButton rectangle = new JButton("Rectangle");
                rectangle.addActionListener(this);
                southPanel2.add(rectangle);

                JButton square = new JButton("Square");
                square.addActionListener(this);
                southPanel2.add(square);

                JButton line = new JButton("Line");
                line.addActionListener(this);

                JPanel southPanel3_1 = new JPanel();
                southPanel3_1.setLayout(new GridLayout(1,2));

                southPanel3_1.add(White);
                southPanel3_1.add(line);

                JPanel southPanel3 = new JPanel();
                southPanel3.setLayout(new GridLayout(2,1));

                southPanel3.add(southPanel3_1, "North");
                southPanel3.add(set_size, "South");

                JPanel southPanel = new JPanel();
                southPanel.setLayout(new GridLayout(1, 2));

                //We then put every panel in the south panel
                contentPanel.add(southPanel, "South");
                southPanel.add(southPanel1, "West");
                southPanel.add(southPanel3, "South");
                southPanel.add(southPanel2, "East");


                //Here are defined the mouse listener called when we draw figures
                draw.addMouseListener(new MouseAdapter() {

                        @Override
                        public void mousePressed(MouseEvent e) {
                                draw.mousePressed(e);
                        }

                });

                draw.addMouseMotionListener(new MouseAdapter() {
                        @Override
                        public void mouseDragged(MouseEvent e) {
                                draw.mouseDragged(e);
                        }
                });

                contentPanel.add(draw);

                this.setJMenuBar(MenuBar);
                this.setVisible(true);
                //this.pack();

        }

        public BufferedImage resize(BufferedImage originalImage, int type, int width, int height) {
                //Resize the image to fit the screen
                BufferedImage resizedImage = new BufferedImage(width, height, type);
                Graphics2D g2d = resizedImage.createGraphics();
                g2d.drawImage(originalImage, 0, 0, width, height, null);
                g2d.dispose();

                return resizedImage;
        }

        public void open(){
                //Open an image and set it as the background
                BufferedImage pictureFile=null;
                try {
                        JFileChooser file = new JFileChooser();
                        file.setFileSelectionMode(JFileChooser.FILES_ONLY);
                        file.setFileFilter(new FileNameExtensionFilter("Image","jpg","png"));
                        int result = file.showOpenDialog(null);

                        //We check here that the result of the selector is a picture
                        if (result == 0) {
                                pictureFile = ImageIO.read(new File(String.valueOf(file.getSelectedFile())));
                                if (pictureFile.getHeight() > draw.getHeight()){
                                        pictureFile = resize(pictureFile, BufferedImage.TYPE_INT_ARGB,
                                                pictureFile.getWidth(), draw.getHeight());
                                }
                                if (pictureFile.getWidth() > draw.getWidth()){
                                        pictureFile = resize(pictureFile, BufferedImage.TYPE_INT_ARGB, draw.getWidth(),
                                                pictureFile.getHeight());
                                }
                                draw.clear();
                                this.draw.setFilePicture(pictureFile);
                                draw.paintComponent(draw.getGraphics());
                        }

                } catch (IOException ex) {
                        ex.printStackTrace();
                }

        }

        public void save(Container cPanel) {
                BufferedImage im = new BufferedImage(cPanel.getWidth(), cPanel.getHeight(), BufferedImage.TYPE_INT_ARGB);
                cPanel.paint(im.getGraphics());

                //Launch a file selector
                try {
                        JFileChooser file_chosen = new JFileChooser();
                        file_chosen.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
                        file_chosen.setFileFilter(new FileNameExtensionFilter("Image", "jpg", "png"));
                        file_chosen.showSaveDialog(null);
                        ImageIO.write(im, "PNG", new File(file_chosen.getSelectedFile() + ".png"));
                }
                //If there is an error, print it.
                catch (IOException error) {
                        error.printStackTrace();
                }
        }

        public void actionPerformed(ActionEvent e) {
                String cmd = e.getActionCommand();
                switch (cmd) {
                        case "Black" -> draw.setColor(Color.BLACK);
                        case "Yellow" -> draw.setColor(Color.YELLOW);
                        case "Red" -> draw.setColor(Color.RED);
                        case "Pink" -> draw.setColor(Color.PINK);
                        case "Green" -> draw.setColor(Color.GREEN);
                        case "Magenta" -> draw.setColor(Color.MAGENTA);
                        case "Blue" -> draw.setColor(Color.BLUE);
                        case "Orange" -> draw.setColor(Color.ORANGE);
                        case "White" -> draw.setColor(Color.WHITE);
                        case "Circle", "Square", "Ellipse", "Rectangle", "Line" -> draw.setNameFigure(cmd);
                        case "Undo" -> this.draw.undo();
                        case "Author" -> {
                                JOptionPane info = new JOptionPane();
                                JOptionPane.showInternalMessageDialog(info, "Paint Lookalike by Loïc BOUCHERY",
                                        "Information", JOptionPane.INFORMATION_MESSAGE);
                        }
                        case "New" -> {
                                if (JOptionPane.showConfirmDialog(null,
                                        "Do you really want to start anew ?",
                                        "New", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                                        draw.clear();
                                }
                        }
                        case "Open" -> this.open();
                        case "Save" -> this.save(this.draw);
                        case "Quit" -> {
                                if (JOptionPane.showConfirmDialog(null,
                                        "Do you want to save before closing ?",
                                        "Exit", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                                        this.save(this.draw);
                                }

                                this.dispose();
                        }
                }
        }

        @Override
        public void stateChanged(ChangeEvent e) {
                JSlider source = (JSlider) e.getSource();
                if (!source.getValueIsAdjusting()) {
                        int size = (int) source.getValue();
                        draw.setSize_lines(size);
                }
        }
}
