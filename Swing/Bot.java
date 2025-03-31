@SuppressWarnings("unused") public class Bot extends Player{
    String difficulty ;
    
    public Bot(String name, String d) {
        super(name);

        difficulty = d;
    }

    public int getMove(int left) {
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
}