package src;

import java.awt.*;
import java.awt.geom.Point2D;

public class Volvo240 extends Car{
    private final static double trimFactor = 1.25; // Skapa getter metod istället för att ha denna public?
    public Volvo240(){
        super(4, 100, 0, Color.black, "Volvo240", new Point2D.Double(0, 0), new Point(1, 0));
        stopEngine();
    }
    public double speedFactor(){
        return getEnginePower() * 0.01 * trimFactor;
    }


}
