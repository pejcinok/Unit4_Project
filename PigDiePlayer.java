public class PigDiePlayer{
    private int score;
    PigDie one;
    PigDie two;

    public PigDiePlayer(){
        score = 0;
        one = new PigDie();
        two = new PigDie();
    }

    public int getScore(){
        return score;
    }

    public int setScore(int value){
        score = value;
        return score;
    }

}