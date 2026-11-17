/*
I have only used resources indicated that are allowable.
The work submitted is my, and only my work.
Signature: Jordan Mantel
Date: 11/9/2026

*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Game {

    public static Scene s = new TitleScene();
    public static Profile p = null;
    public static final File PROFILES_DIRECTORY = new File(".\\profiles");
    public static final File[] ALL_PROFILES = PROFILES_DIRECTORY.listFiles();
    public static boolean isRunning = true;
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) { 

        
        String command = "";
        boolean isValid = false;
        boolean profileLoaded = false;

        System.out.println("Welcome to the Brain Trainer! What would you like to do?\n1. Create a new profile\n2. Load an existing profile\n0. Quit");

        while (!isValid) {
            command = sc.next();
            isValid = isValidCommand(command, new String[]{"1", "2", "0"});
        }

        // Try to load a profile
        if (command.equals("2")) {
            s = new LoadProfileScene();
            while (!profileLoaded) {
                s.loop();
                if (p != null) {
                    System.out.println("The selected profile was loaded.");
                    System.out.println(p.toString());
                    profileLoaded = true;
                }
            }
        }

        // Create a new profile
        if (command.equals("1")) {
            s = new ProfileSetupScene();
            while (!profileLoaded) {
                s.loop();
                if (p != null) {
                    System.out.println("The selected profile was loaded.");
                    System.out.println(p.toString());
                    profileLoaded = true;
                }
            }
            s = new BrainTestScene();
            s.loop();
        }

        

        while (isRunning) {
            s = new SelectScene();
            s.loop();
        }
        sc.close();

    }

    /**
     * Checks whether the command entered in the terminal is valid or not given the
     * command and a list of commands.
     * 
     * @param command The command to check
     * @param valid   The array of all valid commands
     * @return Whether the command is valid or not
     */
    public static boolean isValidCommand(String command, String[] valid) {
        for (String i : valid) {
            if (i.equals(command)) {
                return true;
            }
        }

        return false;
    }


    // This code borrowed from
    // https://www.baeldung.com/java-list-directory-files
    /**
     * Prints out all the files in a given directory.
     * @param directory The directory which to check.
     */
    public static void printFiles(File directory) {
        File[] listOfFiles = directory.listFiles();
        if (listOfFiles != null) {
            for (int i = 0; i < listOfFiles.length; i++) {
                if (listOfFiles[i].isFile() && !listOfFiles[i].getName().equals("records")) { // The records file is a special file and as such it should not be loaded as a profile
                    System.out.println("Profile: " + listOfFiles[i].getName());
                }
            }
        }

    
    }

    public static void setProfile(Profile profile) {
        p = profile;
    }

    public static Profile getProfile() {
        return p;
    }

    public static void stop() {
        isRunning = false;
    }
}
