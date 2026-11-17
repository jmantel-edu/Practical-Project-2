import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors extends PlayScene {
    private double score = 0;
    private int difficulty;
    private ArrayList<RPSQuestion> questions = new ArrayList<>();
    private double questionsAnswered = 0;
    private double combo = 0;
    private double lives = 3;
    private String userAnswer;
    public RockPaperScissors () {
        for (int i = 0; i < 1000; i++) {
            Random r = new Random();
            final char[] MOVES = new char[]{'r', 'p', 's'};
            final char[] COMMANDS = new char[]{'w', 'l'};
            questions.add(new RPSQuestion(MOVES[r.nextInt(3)], COMMANDS[r.nextInt(2)])); // Selects a random move and random command (win or lose)
        }
    }

    @Override
    public double getScore() {
        return score;
    }

    @Override
    public void loop() {
        Scanner sc = Game.sc;
        // Countdown Section
        try {
            System.out.println("3...");
            Thread.sleep(1000);
            System.out.println("2...");
            Thread.sleep(1000);
            System.out.println("1...");
            Thread.sleep(1000);
            System.out.println("\n\n\n\n\n\n\n\n\n");
        } catch (InterruptedException e) {
            System.out.println("The game thread was interrupted!");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        // Main Loop
        while (lives > 0) {
            System.out.print(questions.getFirst() + " = ");
            try {
                userAnswer = sc.next();
                if (userAnswer.charAt(0) == questions.getFirst().getSolution()) {
                    System.out.print(" ✓\n");
                    questionsAnswered++;
                    combo++;
                    if (questionsAnswered % 50 == 0) {
                        System.out.println(questionsAnswered + "Qs answered\n1UP! " + lives + " lives remaining");
                        lives++;
                    }
                    if (combo % 10 == 0) {
                        System.out.println(combo + " combo!");
                    }
                } else {
                    System.out.print(" ✗ Life Lost (" + lives + " remaining)");
                    lives--;
                    combo = 0;
                }
            } catch (InputMismatchException e) {
                System.out.print(" ✗ Life Lost (" + lives + " remaining)");
                lives--;
                combo = 0;
            }

            questions.remove(0);
            if (questions.size() < 10) { // Refill question array if it's running low
                for (int i = 0; i < 1000; i++) {
                    questions.add(RPSQuestion.randomRpsQuestion());
                }
            }
        }

        // Post-loop
        

        System.out.println("\n\nFINISH!");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("The game thread was interrupted!");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        score = questionsAnswered;

    }

}

/**
 * RPSQuestion is an internal class used by the RockPaperScissors class only.
 */

class RPSQuestion {
    private char move;
    private char command;

    public RPSQuestion(char m, char command) {
        if (m != 'r' || m != 's' || m != 'p') {
            throw new IllegalArgumentException("Rock Paper Scissors moves can only be R, S, or P");
        }
        if (command != 'w' || command != 'l') {
            throw new IllegalArgumentException("Command can only be win (w) or lose (l)");
        }
        move = m;
    }

    public char getMove() {
        return move;
    }

    /**
     * Gets the winning move based on the sign
     * @return The winning move
     */
    public char getWinningMove() {
        switch (move) {
            case 'r': return 'p';
            case 's': return 'r';
            case 'p': return 's';
            default: return '-';
        }
    }

    /**
     * Gets the losing move based on the sign
     * @return The losing move
     */
    public char getLosingMove() {
        switch (move) {
            case 'r': return 's';
            case 's': return 'p';
            case 'p': return 'r';
            default: return '-';
        }
    }

    /**
     * Gets the solution to the problem based on the sign and command
     * @return The solution to the problem
     */
    public char getSolution() {
        if (command == 'w') {
            return getWinningMove();
        }
        if (command == 'l') {
            return getLosingMove();
        }

        return 'a';
    }

    @Override 
    public String toString() {
        if (command == 'w') {
            return move + "    Please Win";
        }
        if (command == 'l') {
            return move + "    Please Lose";
        }

        return "";

    }

    public static RPSQuestion randomRpsQuestion() {
        Random r = new Random();
        final char[] MOVES = new char[]{'r', 'p', 's'};
        final char[] COMMANDS = new char[]{'w', 'l'};
        return(new RPSQuestion(MOVES[r.nextInt(3)], COMMANDS[r.nextInt(2)])); // Selects a random move and random command (win or lose)
    }
}
