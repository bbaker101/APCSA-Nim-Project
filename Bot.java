@SuppressWarnings("unused") public class Bot extends Player{
    
    public Bot() {
        super();
    }

    public int bozo(int remainPiece) {
        return Math.random()*remainPiece/2;
    }

    public int getReal(int remainPiece) {
        return -1;
    }
}