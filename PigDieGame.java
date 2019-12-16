import java.util.Scanner;

public class PigDieGame {
    PigDiePlayer player1;
    PigDiePlayer player2;
    PigDie die;
    Scanner scan;

    public PigDieGame(){
        player1 = new PigDiePlayer();
        player2 = new PigDiePlayer();
        die = new PigDie();
        scan = new Scanner(System.in);
    }

    public void start(){
        while (player1.getScore() < 100 && player2.getScore() < 100){
            System.out.println("Player 1's turn:");
            playerTurn(player1);
            System.out.println("Player 2's turn:");
            playerTurn(player2);

        }

        if (player1.getScore() >= 100) {
            System.out.println("Player 1 wins!");
        } else {
            System.out.println("Player 2 wins");
        }

    }

    private void playerTurn(PigDiePlayer player){
        String answer = "r";
        int newScore = 0;
        while(answer.equals("r")){
            System.out.println("Would you like to roll or pass? (r/p)");
            answer = scan.nextLine();
            if (answer.equals("r")) {
                int roll1 = die.roll();
                System.out.println("Roll 1: " + roll1);
                int roll2 = die.roll();
                System.out.println("Roll 2: " + roll2);

                if (roll1 == 1 && roll2 == 1) {
                    System.out.println("Yikes! Snake Eyes. Total score reset.");
                    newScore = 0;
                    answer = "p";
                }
                else if (roll1 == 1 || roll2 == 1){
                    System.out.println("Uh oh you rolled a one. Round score reset.");
                    newScore = player.getScore();
                    answer = "p";
                }
                else {
                    newScore = player.getScore() + roll1 + roll2;
                }
            }
        }
        if (newScore > player.getScore()) {
            System.out.println("Rolls added to score");
        }
        player.setScore(newScore);
    }
}