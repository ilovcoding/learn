package command;

import javax.swing.*;
import java.awt.event.*;

public class Main extends JFrame implements ActionListener {
    private MacroCommand history = new MacroCommand();
    private DrawCanvas canvas = new DrawCanvas(400,400,history);
    private JButton clearButton = new JButton("clear");

    public Main(String title) {
        super(title);

         addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        canvas.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                Command command = new DrawCommand(canvas,e.getPoint());
                history.appendCommand(command);
                command.execute();
            }
        });

        clearButton.addActionListener(this);
        Box buttonBox = new Box(BoxLayout.X_AXIS);
        buttonBox.add(clearButton);
        Box mainBox = new Box((BoxLayout.Y_AXIS));
        mainBox.add(buttonBox);
        mainBox.add(canvas);
        getContentPane().add(mainBox);
        pack();
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == clearButton){
            history.clear();
            canvas.repaint();
        }
    }

    public static void main(String[] args) {
        new Main("Command Pattern Sample");
    }
}
