import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("unused") public class Game {
    private JFrame frame;
    private JTextArea textArea;



    public Game() {
        frame = new JFrame("Nim");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 300);

        //JPanel panel = new JPanel(new FlowLayout());
        textArea = new JTextArea();
        textArea.setLineWrap(true);
        //panel.add(textArea);
        frame.add(textArea);


        textArea.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {}
        });
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Game();
    }
}
