import java.io.File;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.util.Scanner;

public class ProfileSetupScene implements Scene {
    
    @Override
    public void loop() {
        String name = " ";
        PlayScene g = new PlayScene(); // "g" for Game
        Scanner sc = new Scanner(System.in);
        System.out.println("First, can we get your name?\n* Your name must not contain spaces, and its length must not be more than 20 characters.");

        while (!name.toLowerCase().equals("records") || !name.contains(" ") || name.length() > 20) { // While the name is not valid
            name = sc.nextLine();

            if (name.toLowerCase().equals("records")) {
                System.out.println("Your name cannot be \"records\" because that is reserved for the Records file.");
            } else if (name.contains(" ")) {
                System.out.println("Your name cannot contain any spaces.");
            } else if (name.length() > 20) {
                System.out.println("Your name is too long! Keep it under 20 characters.");
            }

        }

        try {
            File f = new File(".\\profiles\\" + name + ".txt");
            f.createNewFile();
        } catch (FileAlreadyExistsException e) {
            System.out.println("There already exists a profile with that name! Please choose another name.");
        } catch (IOException e) {
            System.out.println("There was a system error while attempting to create the profile: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Something went wrong while attempting to create the profile:");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        
    }

    @Override
    public double getScore() {
        throw new UnsupportedOperationException("Not supported in this scene.");
    }
    
}
