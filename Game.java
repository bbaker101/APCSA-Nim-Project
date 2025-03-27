import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

@SuppressWarnings("unused") public class Game {
    private JFrame frame;
    private JTextArea textArea;
    private Player[] playerList;

    // public ArrayList<String> inputPlayer() {
    //     ArrayList<String> ret = new ArrayList<String>();
    //     Scanner scanner = new Scanner(System.in);
    //     System.out.print("input name, separate w/ comma");
    //     String initial = scanner.nextLine();
    //     scanner.close();
    //     int buffer = 0;
    //     while(initial.indexOf(",") != -1) {
    //         ret.add(initial.substring(buffer, initial.indexOf(",")));
    //         buffer = initial.indexOf(",");
    //         initial = initial.substring(buffer, initial.length);
    //     }
    //     return ret;
    // }

    public String inputPlayerTextArea(TextArea area, KeyEvent e) {
        // ArrayList<String> ret = new ArrayList<String>();
        // boolean stop = false;
        // while(true) {
        // area.addKeyListener(new KeyListener() {
        //     // @Override
        //     // public void keyTyped(KeyEvent e) {}
            
        //     @Override
        //     public void keyPressed(KeyEvent e) {
        //         if (e.getKeyCode() == KeyEvent.VK_ENTER) {
        //             if(!area.getText().equals("") || !area.getText().equals(" ")) {
        //                 System.out.println("Player Entered: " + area.getText());
        //                 ret.add(new Player(area.getText()));
        //                 area.setText("");
        //             } else {
        //                 System.out.println("All Players Entered");
        //                 stop = true;
        //             }
        //     }
        //     // @Override
        //     // public void keyReleased(KeyEvent e) {}
        // }
        // });
        // if(stop) {return ret;}
        String ret;
        int keyCode = e.getkeyCode();
        if(keyCode = KeyEvent.VK_ENTER) {
            ret = area.getText();
            area.setText("");
        }
        return ret;
    }

    public String[] compileNameList(TextArea area, KeyEvent e) {
        boolean stop = false;
        ArrayList<String> buffer = new ArrayList<String>();

        while(!stop) {
            if(!(inputPlayerTextArea(area, e).equals(""))) {
                buffer.add(inputPlayerTextArea(area, e));
            } else if (inputPlayerTextArea(area, e).equals("")) {
                stop = true;
            }
        }

        String[] ret = new String[buffer.size()];

        for(int i=0;i<buffer.size();i++) {
            ret[i] = buffer.get(i);
        }

        return ret;
    }

    public Player[] differPlayers(ArrayList<String> input) {
        Player[] ret = new Player[input.size()];
        for(int i=0; i<input.size();i++) {
            if(input.get(i).getName().indexOf("CPU") != -1) {

                ret[i] = new Bot(input.get(i));

            } else {
                ret[i] = new Player(input.get(i));
            }
        }
        return ret;
    }

    public Game() {
        frame = new JFrame("Nim");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 300);

        JPanel initPanel = new JPanel(new FlowLayout());
        JButton finishCharInpButton = new JButton("Finish");
        textArea = new JTextArea();
        textArea.setLineWrap(true);
        panel.add(textArea);
        frame.add(textArea);

        playerList = differPlayers(inputPlayerTextArea(textArea));

        MouseListener charInputStop = new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {

            }
        };
        finishCharInpButton.addMouseListener(charInputStop);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Game();
    }
}
