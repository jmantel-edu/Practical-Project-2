public class PlayScene implements Scene {

    @Override
    public void loop() {
        throw new UnsupportedOperationException("Not supported in the PlayScene class.");
    }

    @Override
    public double getScore() {
        throw new UnsupportedOperationException("Not supported in the PlayScene class.");
    }
    

    /**
     * Returns the time since a given time in milliseconds.
     * @param epoch A value in milliseconds like the one returned from System.currentTimeMillis().
     * @return The time since epoch in milliseconds.
     */
    public static long timeSince(long epoch) {
        return System.currentTimeMillis() - epoch;
    }
}
