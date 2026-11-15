import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class RepeatSubtraction extends PlayScene {

    private int difficulty = 1;
    private double score = 0;

    public RepeatSubtraction(int d) {
        if (d < 1 || d > 4) {
            throw new IllegalArgumentException("Difficulty is out of bounds (Should be 1 to 4, got " + difficulty + ")");
        }

        difficulty = d;
    }

    @Override 
    public void loop() {
        long startingTime = System.currentTimeMillis();
        long finalTime;
        int number = generateAppropriateRandomNumber(difficulty);
        Scanner sc = new Scanner(System.in);
        int solution;
        int userAnswer;

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


        // Primary Game Loop
        while (gameStillInProgress(number, difficulty)) {
            solution = getNextSolution(number, difficulty);
            System.out.print(number + " - " + getSubtrahend(difficulty) + " = ");
            try {
                userAnswer = sc.nextInt();
                if (userAnswer == getNextSolution(number, difficulty)) {
                    System.out.println(" ✓\n");
                } else {
                    System.out.println(" ✗ Time Penalty +5sec\n");
                    startingTime -= 5000;
                }
            } catch (InputMismatchException e) {
                System.out.println(" ✗ Time Penalty +5sec\n");
                startingTime -= 5000;
            }
        }

        finalTime = System.currentTimeMillis();
        score = (double)(finalTime - startingTime)/1000;

        System.out.println("\n\nFINISH!");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("The game thread was interrupted!");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        

    }

    /**
     * Generates a random starting number fit for the chosen difficulty.
     * @param d
     */
    private static int generateAppropriateRandomNumber(int d) {
        Random r = new Random();
        switch (d) {
            case 1:
                return (3*20) + r.nextInt(3);
            case 2:
                return (7*20) + r.nextInt(7);
            case 3:
                return (13*20) + r.nextInt(13);
            case 4:
                return (19*20) + r.nextInt(19);
            
        
            default:
                return 30;
        }
    }

    /**
     * Checks whether the game can continue with the given number. The game cannot continue if subtracting from the current number will result in a negative number.
     * @param number The number which to check.
     * @param difficulty The difficulty of the game.
     * @return Whether the game can continue.
     */
    private boolean gameStillInProgress(int number, int difficulty) {
        switch (difficulty) {
            case 1:
                return number - 3 > 0;
            case 2:
                return number - 7 > 0;
            case 3:
                return number - 13 > 0;
            case 4:
                return number - 19 > 0;
            
        
            default:
                return false;
        }
    }

    /**
     * Get the solution to the next question in the game.
     * @param number The initial number.
     * @param difficulty The difficulty of the game.
     * @return The expected solution.
     */
    private static int getNextSolution(int number, int difficulty) {
        switch (difficulty) {
            case 1:
                return number - 3;
            case 2:
                return number - 7;
            case 3:
                return number - 13;
            case 4:
                return number - 19;
            
        
            default:
                return 0;
        }
    }

    /**
     * Get the subtrahend (i.e. the number which is taking away from the current number) based on the difficulty
     * https://en.wiktionary.org/wiki/subtrahend
     * @param difficulty The difficulty of the game
     * @return The appropriate subtrahend corresponding to the difficulty
     */
    private static int getSubtrahend(int difficulty) {
        switch (difficulty) {
            case 1:
                return 3;
            case 2:
                return 7;
            case 3:
                return 13;
            case 4:
                return 19;
            
        
            default:
                return 0;
        }
    }

    @Override
    public double getScore() {
        // TODO Auto-generated method stub
        return score;
    }
}
