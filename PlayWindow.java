import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

// This code modified from:
// https://www.geeksforgeeks.org/java/what-is-java-awt-graphics/
public class PlayWindow extends Frame implements KeyListener {
    
    public boolean isRunning = true;
    public Scene scene = new TitleScene();

    public PlayWindow()
    {
        
        setSize(480, 640);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e)
            {
                System.exit(0);
            }
        });
    }
    
    @Override
    public void paint(Graphics g) {
        g.drawRect(100, 100, 100, 50);
        g.drawString(Long.toString(System.currentTimeMillis()), 50, 50);
    }

    public void myRepaint(long tm, int x, int y, int width, int height) {
        repaint(tm, x, y, width, height);
    }

    public void createWindow() {
        setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("Key typed: " + e.toString());
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("Key pressed: " + e.toString());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("Key released: " + e.toString());
    }



    
}

class Rectangle {
    public Rectangle(int x, int y, int w, int h) {

    }
}