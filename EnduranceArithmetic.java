import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class EnduranceArithmetic extends PlayScene {
    private double score = 0;
    private int difficulty;
    private ArrayList<ArithmeticQuestion> questions = new ArrayList<>();
    private double questionsAnswered = 0;
    private double combo = 0;
    private double lives = 3;
    private int userAnswer;
    public EnduranceArithmetic(int difficulty) {
        for (int i = 0; i < 1000; i++) {
            questions.add(generateRandomQuestion(difficulty));
        }

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
        } catch (InterruptedException e) {
            System.out.println("The game thread was interrupted!");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        // Main Loop
        while (lives > 0) {
            System.out.print(questions.getFirst() + " = ");
            try {
                userAnswer = sc.nextInt();
                if (userAnswer == questions.getFirst().getAnswer()) {
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
                    questions.add(generateRandomQuestion(difficulty));
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
}
