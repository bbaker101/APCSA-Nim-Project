import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

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

    public ArrayList<String> inputPlayerTextArea(JTextArea area) {
        AraryList<String> ret = new ArrayList<String>();
        area.addKeyListener(new KeyListener() {
            // @Override
            // public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    if(!area.getText().equals("") || !area.getText().equals(" ")) {
                        System.out.println("Player Entered: " + area.getText());
                        ret.add(new Player(area.getText()));
                        area.setText("");
                    } else {
                        System.out.println("All Players Entered");
                        return ret;
                    }
            }

            // @Override
            // public void keyReleased(KeyEvent e) {}
        }
        });
    }

    public Player[] differPlayers(ArrayList<String> input) {
        Player[] ret = new Player[input.size()];
        for(int i=0; i<input.size();i++) {
            if(input.get(i).getName().indexOf("CPU") != -1) {

                ret[i] = new Bot(input.get(i).getName());

            } else {
                ret[i] = input.get(i);
            }
        }
        return ret;
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
