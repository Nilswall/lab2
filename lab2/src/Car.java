package src;

import java.awt.*;
import java.awt.geom.Point2D;

public abstract class Car implements Movable {
    private final int nrDoors;
    private final double enginePower;
    public double currentSpeed;
    private Color color;
    private final String modelName;
    private Point2D point;
    private Point direction;
    public Car(int nrDoors, double enginePower, double currentSpeed, Color color, String modelName, Point2D point, Point direction){
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.currentSpeed = currentSpeed;
        this.color = color;
        this.modelName = modelName;
        this.point = point;
        this.direction = direction;
    }

    public int getNrDoors() {
        return this.nrDoors;
    }

    public double getEnginePower() {
        return this.enginePower;
    }

    public double getCurrentSpeed() {
        return this.currentSpeed;
    }

    public Color getColor() {
        return this.color;
    }

    public void setColor(Color clr) {
        this.color = clr;
    }

    public void startEngine() {
        this.currentSpeed = 0.1;
    }

    public void stopEngine() {
        this.currentSpeed = 0;
    }

    public Point2D getpoint() {
        return this.point;}

    public Point getDirection() {
        return this.direction;
    }

    @Override
    public void move() {
        this.point =  new Point2D.Double(this.point.getX() + this.direction.x*this.currentSpeed,
                this.point.getY()+this.direction.y*this.currentSpeed);
    }

    @Override
    public void turnLeft() {
        int tmp = this.direction.x;
        this.direction.x = - this.direction.y;
        this.direction.y = tmp;

    }

    @Override
    public void turnRight() {
        int tmp = this.direction.x;
        this.direction.x = this.direction.y;
        this.direction.y = -tmp;
    }
    public abstract double speedFactor();

    public void incrementSpeed(double amount){
        this.currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, getEnginePower());
    }
    public void decrementSpeed(double amount){
        this.currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0);
}
    public void gas(double amount) {
        if (0 <= amount && amount <= 1) {
            incrementSpeed(amount);
        } else {
            throw new RuntimeException("Fucking idiot");
        }}
    public void brake(double amount){
        if (0 <= amount && amount <= 1) {
            decrementSpeed(amount);
        } else {
            throw new RuntimeException("Fucking idiot");
        }
    }
    public void setPos(Point2D point){
        this.point = point;
    }
    public void updatePosition(Transport transport) {
        Point2D transportPosition = transport.getpoint();
        this.point = new Point2D.Double(transportPosition.getX(), transportPosition.getY());
    }
}

