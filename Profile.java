import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * The profile class holds various information about the profile.
 * 
 */
public class Profile {
    private String name;
    private int unlockLevel;
    private long nextDaily = System.currentTimeMillis() + 86400;

    public String getName() {
        return name;
    }

    public int getUnlockLevel() {
        return unlockLevel;
    }

    public long getNextDaily() {
        return nextDaily;
    }

    public void setName(String n) {
        this.name = n;
    }

    public void raiseUnlockLevel(){
        this.unlockLevel++;
    }

    public void setUnlockLevel(int add) {
        this.unlockLevel += add;
    }

    public boolean isNextDay() {
        return System.currentTimeMillis() > nextDaily;
    }

    public void updateNextDay() {
        nextDaily = System.currentTimeMillis() + 86400;
    }

    public void smartUpdateDaily() {
        if (System.currentTimeMillis() > nextDaily) {
            unlockLevel++;
            System.out.println("Welcome back! Your unlock level was raised from " + (unlockLevel - 1) + " to " + (unlockLevel + 1) + ". Visit once every 24 hours to unlock something new!");
        }
    }

    public Profile(File f) throws FileNotFoundException {
        Scanner sc = new Scanner(f);
        this.name = sc.next();
        this.unlockLevel = sc.nextInt();
        this.nextDaily = sc.nextLong();
        sc.close();
    }

    public Profile(String n) {
        this.name = n;
        this.unlockLevel = 0;
        this.nextDaily = System.currentTimeMillis() + 86400;
    }

    @Override
    public String toString() {
        return("Name: " + name + "\nUnlock Level:" + unlockLevel + "\nNext Unlock Level Increase" + nextDaily);
    }

    public static void updateProfileFile(File f, Profile p) throws IOException {
        PrintWriter fw = new PrintWriter(f);
        fw.print(""); // Clear out the file to prepare to write new data to it.

        fw.write(p.name + "\n");
        fw.write(p.unlockLevel + "\n");
        fw.write(Long.toString(p.nextDaily));

        fw.close();

    }
}
