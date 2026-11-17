import java.util.Scanner;

public class SelectScene implements Scene {

    @Override
    public void loop() {
        String command;
        Scanner sc = Game.sc;
        PlayScene subscene;
        System.out.println("Enter an item...");
        System.out.println("1. Arithmetic Drill\n2. Repeated Subtraction\n3. Sign Finder");
        System.out.println(Game.p.getUnlockLevel() > 1 ? "4. Endurance Arithmetic" : "4. ??? (Req. Unlock Level 2)");
        System.out.println(Game.p.getUnlockLevel() > 3 ? "5. Rock Paper Scissors" : "5. ??? (Req. Unlock Level 4)");
        System.out.println(Game.p.getUnlockLevel() > 5 ? "6. Box Order" : "6. ??? (Req. Unlock Level 6)");
        System.out.println(Game.p.getUnlockLevel() > 9 ? "7. Recall Grid" : "7. ??? (Req. Unlock Level 10)");
        System.out.println("9. Exit");

        command = sc.next();

        int difficulty;
        int questions;
        switch (command) {
            
            case "1":
                

                System.out.println("Enter the amount of questions:\n1. 20Q\n2. 30Q\n3. 50Q\n4. 100Q");
                command = sc.next();
                if (command.equals("1")) {
                    questions = 20;
                } else if (command.equals("2")) {
                    questions = 30;
                } else if (command.equals("3")) {
                    questions = 50;
                } else if (command.equals("4")) {
                    questions = 100;
                } else {
                    System.out.println("Invalid input.");
                    break;
                }

                System.out.println("Enter the difficulty:\n1. Easy (+ and - only)\n2. Normal (+ - and *)\n3. Hard (+ - * and /)");
                command = sc.next();
                if (command.equals("1")) {
                    difficulty = 1;
                } else if (command.equals("2")) {
                    difficulty = 2;
                } else if (command.equals("3")) {
                    difficulty = 3;
                } else {
                    System.out.println("Invalid input.");
                    break;
                }
                subscene = new ArithmeticDrill(questions, difficulty);
                
                subscene.loop();
                break;

            case "2":

            System.out.println("Enter the difficulty:\n1. Easy (+ and - only)\n2. Normal (+ - and *)\n3. Hard (+ - * and /)");
                command = sc.next();
                if (command.equals("1")) {
                    difficulty = 1;
                } else if (command.equals("2")) {
                    difficulty = 2;
                } else if (command.equals("3")) {
                    difficulty = 3;
                } else if (command.equals("4")) {
                    difficulty = 4;
                } else {
                    System.out.println("Invalid input.");
                    break;
                }
                subscene = new RepeatSubtraction(difficulty);
                
                subscene.loop();
                break;

            case "3":

                System.out.println("Enter the amount of questions:\n1. 20Q\n2. 30Q\n3. 50Q\n4. 100Q");
                command = sc.next();
                if (command.equals("1")) {
                    questions = 20;
                } else if (command.equals("2")) {
                    questions = 30;
                } else if (command.equals("3")) {
                    questions = 50;
                } else if (command.equals("4")) {
                    questions = 100;
                } else {
                    System.out.println("Invalid input.");
                    break;
                }

            System.out.println("Enter the difficulty:\n1. Easy (+ and - only)\n2. Normal (+ - and *)\n3. Hard (+ - * and /)");
                command = sc.next();
                if (command.equals("1")) {
                    difficulty = 1;
                } else if (command.equals("2")) {
                    difficulty = 2;
                } else if (command.equals("3")) {
                    difficulty = 3;
                } else {
                    System.out.println("Invalid input.");
                    break;
                }
                subscene = new SignFinder(questions, difficulty);
                
                subscene.loop();
                break;

            case "4":
                System.out.println("Enter the difficulty:\n1. Easy (+ and - only)\n2. Normal (+ - and *)\n3. Hard (+ - * and /)");
                command = sc.next();
                if (command.equals("1")) {
                    difficulty = 1;
                } else if (command.equals("2")) {
                    difficulty = 2;
                } else if (command.equals("3")) {
                    difficulty = 3;
                } else {
                    System.out.println("Invalid input.");
                    break;
                }
                subscene = new EnduranceArithmetic(difficulty);
                
                subscene.loop();
                break;

            case "5":
                subscene = new RockPaperScissors();
                
                subscene.loop();
                break;

            case "6":
                System.out.println("Not implemented due to time constraints.");
                break;
            
            case "7":
                System.out.println("Not implemented due to time constraints.");
                break;



        
            default:
                break;
        }

        // Reset the scanner and close it immediately to prevent causing errors by just assuming the scanner will be open at the end of the loop

    }

    @Override
    public double getScore() {
        throw new UnsupportedOperationException("Not supported in this scene.");
    }
    
}
