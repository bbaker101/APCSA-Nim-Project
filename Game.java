import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;

@SuppressWarnings("unused") public class Game {
    private JFrame frame;
    private JTextArea textArea;

    public ArrayList<String> inputPlayer() {
        ArrayList<String> ret = new ArrayList<String>();
        Scanner scanner = new Scanner(System.in);
        System.out.print("input name, separate w/ comma");
        String initial = scanner.nextLine();
        scanner.close();
        int buffer = 0;
        while(initial.indexOf(",") != -1) {
            ret.add(initial.substring(buffer, initial.indexOf(",")));
            buffer = initial.indexOf(",");
            initial = initial.substring(buffer, initial.length);
        }
        return ret;
    }

    public Player[] differPlayers(ArrayList<String> input) {
        for(int i=0; i<input.size();i++) {
            
        }
    }

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
