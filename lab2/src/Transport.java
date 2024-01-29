package src;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.Stack;

import static java.lang.Math.sqrt;

public class Transport extends Truck implements Loading{
    private Stack<Car> cargo;
    private int maxsize;
    public Transport() {
        super(2, 200, 0, Color.YELLOW, "Superyellowbigtruck", new Point2D.Double(0, 0), new Point(1, 0), 0);
        this.cargo = new Stack<>();
        this.maxsize = 6;
    }

    public void changeAngle(int new_angle) {
        if (new_angle != 90 || new_angle != 0){
            throw new RuntimeException("Angle can only be up or down");
        }
        else if (getCurrentSpeed() == 0){
            this.angle = new_angle;
        }
        else {
            throw new RuntimeException("Cant change angle while driving");
        }
    }

    public double avståndsFormeln(Point2D point1, Point2D point2){
        double dx = point2.getX() - point1.getX();
        double dy = point2.getY()- point1.getY();
        return sqrt(dx*dx+dy*dy);
    } // TODO ta bort och ha endast i Loading??

    public void loadCargo(Car car) {
        if (getCurrentSpeed() != 0) {
            throw new RuntimeException("Cant load while driving");
        }
        else if (this.cargo.size() == this.maxsize) {
            throw new RuntimeException("Transport full");
        }
        else if (avståndsFormeln(car.getpoint(), this.getpoint()) > 8) {
            throw new RuntimeException("Cargo not at transport");

        }
        else if (getAngle() != 0) {
            throw new RuntimeException("Cant load without ramp down");
        }
        else {
            this.cargo.push(car);
            car.setPos(this.getpoint());
        }
    }

    public void offLoadCargo(){
        if (getCurrentSpeed() != 0){
            throw new RuntimeException("Cant offload while driving");
        }
        else if (this.getAngle() != 0){
            throw new RuntimeException("Cant offload without ramp down");
        }
        else {
            Car a_car = this.cargo.pop();
            Point2D point1 = new Point2D.Double(this.getpoint().getX()-2, this.getpoint().getY()-2);
            a_car.setPos(point1);
            // Eventuellt göra position publci ifall att cars position inte uppdateras kontinuerligt
        }
    }
}
