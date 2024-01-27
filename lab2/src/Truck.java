package src;

import java.awt.*;
import java.awt.geom.Point2D;

public abstract class Truck extends Car{
    public int angle;

    public Truck(int nrDoors, double enginePower, double currentSpeed, Color color, String modelName, Point2D point, Point direction, int angle){
        super(nrDoors, enginePower, currentSpeed, color, modelName, point, direction);
        this.angle = angle;
    }
    public int getAngle(){
        return angle;
    }
    @Override
    public void startEngine() {
        if (getAngle() == 0) {
            this.currentSpeed = 0.1;
        } else {
            throw new RuntimeException("Cant start if flaks angle not 0");
        }
    }
    public abstract void changeAngle(int angle);

    @Override
    public double speedFactor() {
        return 1;
    }

}
