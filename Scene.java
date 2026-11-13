
/**
 * Scene
 * The scene interface provides a framework for scenes (i.e. "game loops") to be created.
 */
public interface Scene {
    /**
     * This will be executed upon a scene change. It is the loop of the scene.
     */
    public void loop();
    /**
     * Returns the "score" of the scene if applicable. 
     * @return The total score, whether that should be a time, a number of points, etc.
     */
    public double getScore();
}
