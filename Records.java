import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Records {
    private static double[][] arithmeticDrillRecord = new double[3][4]; // Easy/Normal/Hard, 20/30/50/100 Qs
    private static double[] recallGridRecord = new double[5]; // Easy/Normal/Hard/Crazy/Beyond
    private static double[][] signFinderRecord = new double[3][4]; // Easy/Normal/Hard, 20/30/50/100 Qs
    private static double rockPaperScissorsRecord;
    private static double[] repeatSubtractionRecord = new double[4]; // Easy/Normal/Hard/Crazy
    private static double[] boxOrderRecord = new double[4]; // Easy/Normal/Hard/Crazy
    private static double enduranceArithmeticRecord;


    /**
     * Saves records to the records.txt file.
     * @throws FileNotFoundException
     * @throws NullPointerException
     */
    public static void saveRecords() throws FileNotFoundException, NullPointerException {
        File f = new File(".\\records\\records.txt");

        // This code borrowed from:
        // https://www.baeldung.com/java-delete-file-contents
        PrintWriter w = new PrintWriter(f);
        w.print(""); // Clear the file to prepare to write new data to it

        // Arithmetic Drill
        for (double[] row : arithmeticDrillRecord) {
            for (double item : row) {
                w.write(Double.toString(item) + " ");
            }
        }
        w.write("\n");

        // Recall Grid
        for (double item : recallGridRecord) {
            w.write(Double.toString(item) + " ");
        }
        w.write("\n");

        // Sign Finder
        for (double[] row : signFinderRecord) {
            for (double item : row) {
                w.write(Double.toString(item) + " ");
            }
        }
        w.write("\n");

        // Rock Paper Scissors
        w.write(Double.toString(rockPaperScissorsRecord) + "\n");

        // Repeat Subtraction
        for (double item : repeatSubtractionRecord) {
            w.write(Double.toString(item) + " ");
        }
        w.write("\n");

        // Box Order
        for (double item : boxOrderRecord) {
            w.write(Double.toString(item) + " ");
        }
        w.write("\n");

        // Endurance Arithmetic & End of file
        w.write(Double.toString(enduranceArithmeticRecord));

        w.close();
    }

    public void getSavedRecords() throws FileNotFoundException, NoSuchElementException {
        File f = new File(".\\records\\records.txt");
        Scanner sc = new Scanner(f);

        while (sc.hasNextDouble()) {

            // Arithmetic Drill
            for (int row = 0; row < 3; row++) {
                for (int item = 0; item < 3; item++) {
                    arithmeticDrillRecord[row][item] = sc.nextDouble();
                }
            }

            // Recall Grid
            for (int item = 0; item < 5; item++) {
                recallGridRecord[item] = sc.nextDouble();
            }

            // Sign Finder
            for (int row = 0; row < 3; row++) {
                for (int item = 0; item < 4; item++) {
                    signFinderRecord[row][item] = sc.nextDouble();
                }
            }

            // Rock Paper Scissors
            rockPaperScissorsRecord = sc.nextDouble();

            // Repeat Subtraction
            for (int item = 0; item < 4; item++) {
                repeatSubtractionRecord[item] = sc.nextDouble();
            }

            // Box Order
            for (int item = 0; item < 4; item++) {
                boxOrderRecord[item] = sc.nextDouble();
            }

            // Endurance Arithmetic
            enduranceArithmeticRecord = sc.nextDouble();

        }

        sc.close();
    }

    
    /*
    =====
    Getters & Setters
    =====

    For arrays, methods ending in "At" get/set one value; methods that don't end in "At" get/set the whole array
    */

    public static double[][] getArithmeticDrillRecord() {
        return arithmeticDrillRecord;
    }

    public static double getArithmeticDrillRecordAt(int difficulty, int questionCount) {
        return arithmeticDrillRecord[difficulty][questionCount];
    }

    public static void setArithmeticDrillRecord(double[][] arithmeticDrillRecord) {
        Records.arithmeticDrillRecord = arithmeticDrillRecord;
    }

    public static void setArithmeticDrillRecordAt(int difficulty, int questionCount, double newValue) {
        Records.arithmeticDrillRecord[difficulty][questionCount] = newValue;
    }




    public static double[] getRecallGridRecord() {
        return recallGridRecord;
    }

    public static double getRecallGridRecordAt(int difficulty) {
        return recallGridRecord[difficulty];
    }

    public static void setRecallGridRecord(double[] recallGridRecord) {
        Records.recallGridRecord = recallGridRecord;
    }

    public static void setRecallGridRecordAt(int difficulty, double newValue) {
        Records.recallGridRecord[difficulty] = newValue;
    }


    
    
    public static double getRockPaperScissorsRecord() {
        return rockPaperScissorsRecord;
    }

    public static void setRockPaperScissorsRecord(double rockPaperScissorsRecord) {
        Records.rockPaperScissorsRecord = rockPaperScissorsRecord;
    }




    public static double[][] getSignFinderRecord() {
        return signFinderRecord;
    }

    public static double getSignFinderRecordAt(int difficulty, int questionCount) {
        return signFinderRecord[difficulty][questionCount];
    }

    public static void setSignFinderRecord(double[][] signFinderRecord) {
        Records.signFinderRecord = signFinderRecord;
    }

    public static void setSignFinderRecordAt(int difficulty, int questionCount, double newValue) {
        Records.signFinderRecord[difficulty][questionCount] = newValue;
    }




    public static double[] getRepeatSubtractionRecord() {
        return repeatSubtractionRecord;
    }

    public static double getRepeatSubtractionRecordAt(int difficulty) {
        return repeatSubtractionRecord[difficulty];
    }

    public static void setRepeatSubtractionRecord(double[] repeatSubtractionRecord) {
        Records.repeatSubtractionRecord = repeatSubtractionRecord;
    }

    public static void setRepeatSubtractionRecordAt(int difficulty, double newValue) {
        Records.repeatSubtractionRecord[difficulty] = newValue;
    }




    public static double[] getBoxOrderRecord() {
        return boxOrderRecord;
    }

    public static void setBoxOrderRecord(double[] boxOrderRecord) {
        Records.boxOrderRecord = boxOrderRecord;
    }
    
    public static double getBoxOrderRecordAt(int difficulty) {
        return boxOrderRecord[difficulty];
    }

    public static void setBoxOrderRecordAt(int difficulty, double newValue) {
        Records.boxOrderRecord[difficulty] = newValue;
    }




    public static double getEnduranceArithmeticRecord() {
        return enduranceArithmeticRecord;
    }

    public static void setEnduranceArithmeticRecord(double enduranceArithmeticRecord) {
        Records.enduranceArithmeticRecord = enduranceArithmeticRecord;
    }
}
