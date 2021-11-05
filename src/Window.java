import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

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
        JMenuItem Authors= new JMenuItem("Authors");

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

        FigurePanel.add(Square);
        FigurePanel.add(Rectangle);
        FigurePanel.add(Circle);
        FigurePanel.add(Ellipse);
        FigurePanel.add(Line);
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
                    System.exit(0);
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
                }
            }
            case "Save" -> drawPanel.Save();
        }
    }
}