import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("unused") public class Board {
    public static int remainPiece;
    private JFrame frame;
    private int pieces;
    private String option;

    public Board(JFrame frame, int pieces, String option) {
        this.frame = frame;
        this.pieces = pieces;
        this.option = option;

        if(option.equals("")) {
            System.out.println("No optional settings.");
        }
    }

    
}