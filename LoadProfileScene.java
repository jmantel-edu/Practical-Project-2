import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * This is a scene where a profile is loaded. It will attempt to keep loading profiles until it is performed successfully.
 */
public class LoadProfileScene implements Scene {

    @Override
    public void loop() {
        String command;
        Scanner sc = new Scanner(System.in);
        System.out.println("Which profile would you like to load? Enter its name (without -.txt)...");
        Game.printFiles(Game.PROFILES_DIRECTORY);
        command = sc.next();

        try {
            Game.setProfile(new Profile(new File(".\\profiles\\" + command + ".txt")));
        } catch (FileNotFoundException e) {
            System.out.println("Couldn't find that profile!");
        } catch (Exception e) {
            System.out.println("Couldn't load that profile for the following reason:\n" + e.getMessage());
        }

        sc.close();
    }

    @Override
    public double getScore() {
        throw new UnsupportedOperationException("Not supported in this scene.");
    }
    
}
