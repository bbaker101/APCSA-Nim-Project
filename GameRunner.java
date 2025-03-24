import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BChecker {
    private JFrame frame;
    private JTextArea textArea;
    //private JLabel counterLabel;
    private String[] AC;

    public BChecker() { //later: make triple box area that renders the choices for autocomplete and spellcheck
        //                          also remember to have spellcheck markup unrecognized words with change, method(?)
        frame = new JFrame("B Checker");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 300);

        JPanel panel = new JPanel(new FlowLayout());
        textArea = new JTextArea();
        textArea.setLineWrap(true);



        frame.add(textArea);


        textArea.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {}

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new BChecker();
    }
}