import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class SignFinder extends PlayScene {
    private double score = 0;
    private int questionCount;
    private int difficulty;
    private ArrayList<ArithmeticQuestion> questions = new ArrayList<>();
    private double startingTime;
    private double finalTime;
    private String userAnswer;

    public SignFinder(int questionCount, int difficulty) {
        for (int i = 0; i < questionCount; i++) {
            questions.add(generateRandomQuestion(difficulty));
        }

        this.questionCount = questionCount;
        this.difficulty = difficulty;
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
            startingTime = System.currentTimeMillis();
        } catch (InterruptedException e) {
            System.out.println("The game thread was interrupted!");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        // Main Loop
        while (questions.size() > 0) {
            ArithmeticQuestion thisQ = questions.getFirst();
            System.out.print(thisQ.getA() + " ? " + thisQ.getB() + " = " + thisQ.getAnswer());
            try {
                userAnswer = sc.next();
                if (new ArithmeticQuestion(thisQ.getA(), thisQ.getB(), userAnswer.charAt(0)).getAnswer() == thisQ.getAnswer()) { // Checks whether the signs equal by making a new arithmetic question and comparing its answer to the original answer. e.g. 2+2 = 2*2 = 4 but the user can't tell just by getting 2 ? 2 = 4
                    System.out.print(" ✓\n");
                } else {
                    System.out.print(" ✗ Time Penalty +5sec\n");
                    startingTime -= 5000;
                }
            } catch (InputMismatchException e) {
                System.out.println(" ✗ Time Penalty +5sec\n");
                startingTime -= 5000;
            }

            questions.remove(0);
        }

        // Post-loop
        finalTime = System.currentTimeMillis();
        score = (double)((finalTime - startingTime)/1000);

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
     * Generates a random arithmetic question based on the game difficulty.
     * @param difficulty The game difficulty to generate a question for.
     * @return An arithmetic question fit for the difficulty.
     */
    private ArithmeticQuestion generateRandomQuestion(int difficulty) {
        Random r = new Random();
        int a;
        int b;
        char sign;
        char[] signs = ArithmeticQuestion.SIGNS;
        
        switch (difficulty) {
            case 1: // Easy
                a = r.nextInt(10);
                b = r.nextInt(10);
                sign = signs[r.nextInt(2)]; // + or -
                return new ArithmeticQuestion(a, sign, b);

            case 2: // Normal
                a = r.nextInt(10);
                b = r.nextInt(10);
                sign = signs[r.nextInt(3)]; // + - or *
                return new ArithmeticQuestion(a, sign, b);

            case 3: // Hard
                b = r.nextInt(10) + 1;
                sign = signs[r.nextInt(4)]; // + - * or /
                if (sign == '/') { // Generate a whole number that can be divided into b
                    a = b * (r.nextInt(9) + 1);
                } else {
                    a = r.nextInt(10);
                }
                return new ArithmeticQuestion(a, sign, b);
        
            default:
                return new ArithmeticQuestion(1, '+', 2);
        }
    }


    /**
     * Returns the appropriate count index for the array in records based on the amount of questions.
     * @param count The amount of questions.
     * @return The appropriate index in the Records.arithmeticDrillRecords array.
     */
    private int getQuestionCountIndex(int count) {
        switch (count) {
            case 20:
                return 0;
            case 30:
                return 1;
            case 50:
                return 2;
            case 100:
                return 3;
        
            default:
                return 1;
        }
    }
}
