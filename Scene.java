
import java.awt.Graphics;

/**
 * Scene - The purpose of the Scene interface is to create an interface upon which game scenes can be created.
 * The game window can access a Scene's loop and run it, and switch between scenes at any time.
 */

public interface Scene {
    /**
     * Code to be ran that initializes the loop. Should be used to set up any required resources.
     */
    public void initialize();

    /**
     * Code that runs every frame after initialize(). 
     * @param g Allows graphics to be drawn by this method on the PlayWindow's Graphics.
     */
    public void loop(Graphics g);
    
    /**
     * Code to be ran that terminates the loop. Should be used to close / free up resources, especially those that might interfere with the next Scene.
     */
    public void terminate();
}
