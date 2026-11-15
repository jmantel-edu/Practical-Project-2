public class BrainTestScene extends PlayScene {
    @Override
    public void loop() {
        double brainAge = 20;
        double scoreHolder = 0;
        PlayScene subscene;

        // Repeat Subtraction
        subscene = new ArithmeticDrill(30, 1);
        System.out.println("1ST TEST: ARITHMETIC DRILL\nSolve 30 Questions as fast as possible. Good luck!");
        sleep(2000);
        
        subscene.loop();
        scoreHolder = subscene.getScore();
        if (scoreHolder <= 25) {
            System.out.println("Excellent result!");
        } else {
            brainAge += 0.15 * (scoreHolder - 30);
        }

        System.out.println("2ND TEST: REPEATED SUBTRACTION\nKeep subtracting a number from the given number until reaching 0.");
        sleep(2000);
        subscene = new RepeatSubtraction(2);
        subscene.loop();
        scoreHolder = subscene.getScore();
        if (scoreHolder <= 30) {
            System.out.println("Excellent result!");
        } else {
            brainAge += 0.15 * (scoreHolder - 30);
        }

        System.out.println("FINAL TEST: SIGN FINDER\nFind the sign that makes the equation true.");
        sleep(2000);
        subscene = new SignFinder();
        subscene.loop();
        scoreHolder = subscene.getScore();
        if (scoreHolder <= 30) {
            System.out.println("Excellent result!");
        } else {
            brainAge += 0.15 * (scoreHolder - 30);
        }

    }

    @Override
    public double getScore() {
        return 0;
    }
    
    /**
     * A sleep method with a prewritten try-catch block to avoid repetitiveness
     * @param m The amount of milliseconds to sleep for.
     */
    private static void sleep(int m) {
        try {
            Thread.sleep(m);
        } catch (InterruptedException e) {
            System.out.println("The thread was interrupted!");
            e.printStackTrace();
        }
    }
}
