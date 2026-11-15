public class BrainTestScene extends PlayScene {
    @Override
    public void loop() {
        PlayScene subscene = new ArithmeticDrill();

    }

    @Override
    public double getScore() {
        return 0;
    }
    
}
