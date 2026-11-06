



/*
I have only used resources indicated that are allowable.
The work submitted is my, and only my work.
Signature: Jordan Mantel
Date: Thursday, November 5th, 2026 */

public class Main {
    public static void main(String[] args) throws InterruptedException {
        PlayWindow f = new PlayWindow();
        f.createWindow();
        f.addKeyListener(f);        
        
        while (PlayWindow.isRunning && f.isVisible()) {
            long nextTick = System.currentTimeMillis() + 17;
            f.myRepaint(0, 0, 0, f.getWidth(), f.getHeight());
            long timeToNextTick = nextTick - System.currentTimeMillis();
            Thread.sleep((timeToNextTick > 0 ? timeToNextTick : 0)); // Sleep until the next frame if there's time remaining, otherwise immediately proceed to the next frame
        }
    }
}

