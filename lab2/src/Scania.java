package src;
import java.awt.*;
import java.awt.geom.Point2D;
public class Scania extends Truck {

    public Scania() {
        super(2, 200, 0, Color.YELLOW, "Superyellowbigtruck", new Point2D.Double(0, 0), new Point(1, 0), 0);
    }

    public void changeAngle(int new_angle) {
        if (new_angle>70 || new_angle <0){
            throw new RuntimeException("Angle can only be between 0 and 70");
        }
        else if (getCurrentSpeed() == 0){
            this.angle = new_angle;
        }
        else {
            throw new RuntimeException("Cant change angle while driving");
        }
    }



}
