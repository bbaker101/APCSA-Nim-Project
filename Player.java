@SuppressWarnings("unused") public class Player {
    private int wins=0;
    private int score=0;
    private String name;
    
    public Player(String name) {
        this.name = name;
    }

    public void incrementWins() {
        wins++;
    }

    public void setScore(int i) {
        score = i;
    }

    public void addScore(int i) {
        score += i;
    }

    public String getName() {
        return name;
    }

    public int getWins() {
        return wins;
    }

    public int getScore() {
        return score;
    }

}
