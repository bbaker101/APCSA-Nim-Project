import java.util.*;

public class Nim {
    private int player1Score = 0;
    private int player2Score = 0;
    private int player1Wins = 0;
    private int player2Wins = 0;
    private int player1Streak = 0;
    private int player2Streak = 0;
    private Random random = new Random();
    private Scanner sc = new Scanner(System.in);

    /** Chooses which player goes first randomly. */
    public String chooseFirstPlayer(String player1, String player2) {
        return random.nextBoolean() ? player1 : player2;
    }

    /** Get the player's move between 1 and up to half of remaining elements */
    public int getPlayerMove(int left, String playerName) {
        int maxAllowed = Math.max(1, left / 2);  // Ensure at least 1 can be taken
        System.out.println(playerName + "'s move:");
        int move = sc.nextInt();
        sc.nextLine();

        while (move < 1 || move > maxAllowed) {
            System.out.println(move + " not allowed, choose between 1 and up to half of the remaining elements (" + maxAllowed + ").");
            move = sc.nextInt();
            sc.nextLine();
        }
        return move;
    }

    /** Get the computer's move with difficulty level */
    public int getComputerMove(int left, String difficulty) {
        int maxAllowed = Math.max(1, left / 2);  // Ensure at least 1 can be taken
        int move = 0;
    
        switch (difficulty.toLowerCase()) {
            case "easy":
                // Random move, can be any number between 1 and maxAllowed
                move = random.nextInt(maxAllowed) + 1;
                break;
    
            case "medium":
                // Try to leave 1 or 3 pieces for the player if possible
                if (left > 3 && left - 3 <= maxAllowed) {
                    move = left - 3;
                } else if (left > 1 && left - 1 <= maxAllowed) {
                    move = left - 1;
                } else {
                    // If no better move, choose randomly
                    move = random.nextInt(maxAllowed) + 1;
                }
                break;
    
            case "hard":
                // Try to leave the opponent in a losing position (using game theory)
                for (int i = 1; i <= maxAllowed; i++) {
                    if ((left - i) % (maxAllowed + 1) == 0) {
                        move = i;
                        break;
                    }
                }
                // If no perfect strategy move, pick randomly
                if (move == 0) {
                    move = random.nextInt(maxAllowed) + 1;
                }
                break;
    
            default:
                System.out.println("Invalid difficulty level.");
                move = random.nextInt(maxAllowed) + 1;
                break;
        }
    
        System.out.println("Computer's move: " + move);
        return move;
    }


   /** Plays the game between two players or player vs. computer. */
    public void playGame(String player1, String player2, boolean againstComputer) {
        int pileSize = random.nextInt(41) + 10; // Random pile size between 10 and 50
        System.out.println("The game starts with " + pileSize + " pieces.");
    
        // Ask for the difficulty level if playing against the computer
        String difficulty = "easy";  // Default difficulty
        if (againstComputer) {
            System.out.println("Choose difficulty (easy/medium/hard): ");
            difficulty = sc.nextLine().toLowerCase();
        }
    
        String currentPlayer = chooseFirstPlayer(player1, player2);
        String otherPlayer = currentPlayer.equals(player1) ? player2 : player1;
    
        while (pileSize > 0) {
            // Current player's turn
            int move = 0;
            if (againstComputer && currentPlayer.equals(player2)) {
                // Computer's turn with selected difficulty
                move = getComputerMove(pileSize, difficulty);
            } else {
                // Player's turn
                move = getPlayerMove(pileSize, currentPlayer);
            }
            pileSize -= move;
            System.out.println("Now there are " + pileSize + " left.");
    
            if (pileSize == 0) {
                // Last player to take a piece loses
                if (currentPlayer.equals(player1)) {
                    System.out.println(player1 + " loses! " + player2 + " wins!");
                    player2Score++;
                } else {
                    System.out.println(player2 + " loses! " + player1 + " wins!");
                    player1Score++;
                }
                return;
            }
    
            // Swap players
            String temp = currentPlayer;
            currentPlayer = otherPlayer;
            otherPlayer = temp;
        }
    }


    /** Ask if the players want to play again, and keep track of scores. */
    public void play() {
        System.out.println("Do you want to play against another player or the computer? (Enter 'player' or 'computer')");
        String gameMode = sc.nextLine().toLowerCase();

        if (gameMode.equals("player")) {
            System.out.println("Enter name for Player 1:");
            String player1 = sc.nextLine();
            System.out.println("Enter name for Player 2:");
            String player2 = sc.nextLine();

            String playAgain = "yes";
            while (playAgain.equalsIgnoreCase("yes")) {
                playGame(player1, player2, false);
                System.out.println(player1 + "'s score: " + player1Score);
                System.out.println(player2 + "'s score: " + player2Score);
                System.out.println("Do you want to play again? (yes/no)");
                playAgain = sc.nextLine();
            }

        } else if (gameMode.equals("computer")) {
            System.out.println("Enter your name:");
            String player1 = sc.nextLine();
            String player2 = "Computer";

            String playAgain = "yes";
            while (playAgain.equalsIgnoreCase("yes")) {
                playGame(player1, player2, true);
                System.out.println(player1 + "'s score: " + player1Score);
                System.out.println("Computer's score: " + player2Score);
                System.out.println("Do you want to play again? (yes/no)");
                playAgain = sc.nextLine();
            }

        } else {
            System.out.println("Invalid input. Please restart the game.");
        }
        System.out.println("Thanks for playing!");
    }

    public static void main(String[] args) {
        Nim nim = new Nim();
        nim.play();
    }
}
