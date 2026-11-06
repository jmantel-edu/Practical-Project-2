
import java.awt.Graphics;

public class TitleScene implements Scene {

    @Override
    public void initialize() {
        
    }

    @Override
    public void loop(Graphics g) {
        g.drawString("Hello World", 20, 20);
        System.out.println("Loop method called");
    }

    @Override
    public void terminate() {
        
    }
    
}
