import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


// This code borrowed from:
// https://www.geeksforgeeks.org/java/what-is-java-awt-graphics/
public class MyFrame extends Frame {
    public MyFrame()
    {
        setVisible(true);
        setSize(300, 200);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e)
            {
                System.exit(0);
            }
        });
    }
    
    @Override
    public void paint(Graphics g)
    {
        g.drawRect(100, 100, 100, 50);
    }
}