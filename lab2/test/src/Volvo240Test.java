package src;

import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.geom.Point2D;

import static org.junit.jupiter.api.Assertions.*;

class Volvo240Test {
    private Volvo240 volvo;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        volvo = new Volvo240();
    }

    @org.junit.jupiter.api.Test
    void getNrDoors() {
        assertEquals(4, volvo.getNrDoors());
    }

    @org.junit.jupiter.api.Test
    void getEnginePower() {
        assertEquals(100, volvo.getEnginePower());
    }

    @org.junit.jupiter.api.Test
    void getCurrentSpeed() {
        assertEquals(volvo.getCurrentSpeed(), volvo.currentSpeed);
    }

    @org.junit.jupiter.api.Test
    void getColor() {
        assertEquals(volvo.getColor(), Color.BLACK);
    }

    @org.junit.jupiter.api.Test
    void setColor() {
        volvo.setColor(Color.BLUE);
        assertEquals(volvo.getColor(), Color.BLUE);
    }

    @org.junit.jupiter.api.Test
    void startEngine() {
        volvo.startEngine();
        assertEquals(volvo.getCurrentSpeed(), 0.1);
    }

    @org.junit.jupiter.api.Test
    void stopEngine() {
        volvo.startEngine();
        volvo.stopEngine();
        assertEquals(volvo.getCurrentSpeed(), 0);
    }

    @org.junit.jupiter.api.Test
    void move() {
        Point2D tmp1 = new Point2D.Double(volvo.getpoint().getX(), volvo.getpoint().getY());
        volvo.startEngine();
        volvo.move();
        assertNotEquals(volvo.getpoint(), tmp1);
    }

    @org.junit.jupiter.api.Test
    void turnLeft() {
        Point tmp1 = new Point(volvo.getDirection().x, volvo.getDirection().y);
        volvo.turnLeft();
        Point turnedtmp1 = new Point(-tmp1.y, tmp1.x);
        assertEquals(turnedtmp1, volvo.getDirection());
    }

    @org.junit.jupiter.api.Test
    void turnRight() {
        Point tmp1 = new Point(volvo.getDirection().x, volvo.getDirection().y);
        volvo.turnRight();
        Point turnedtmp1 = new Point(tmp1.y, -tmp1.x);
        assertEquals(turnedtmp1, volvo.getDirection());
    }

    @org.junit.jupiter.api.Test
    void incrementSpeed() {
        double tmp1 = volvo.getCurrentSpeed();
        volvo.incrementSpeed(1);
        assertNotEquals(tmp1, volvo.getCurrentSpeed());
    }

    @org.junit.jupiter.api.Test
    void decrementSpeed() {
        volvo.startEngine();
        double tmp1 = volvo.getCurrentSpeed();
        volvo.decrementSpeed(1);
        assertNotEquals(tmp1, volvo.getCurrentSpeed());
    }
    @org.junit.jupiter.api.Test
    void brake() {
        volvo.startEngine();
        double tmp1 = volvo.getCurrentSpeed();
        volvo.brake(0.5);
        assertNotEquals(tmp1, volvo.getCurrentSpeed());

    }
    @org.junit.jupiter.api.Test
    void gas() {
        volvo.startEngine();
        double tmp1 = volvo.getCurrentSpeed();
        volvo.gas(0.5);
        assertNotEquals(tmp1, volvo.getCurrentSpeed());
    }
    @org.junit.jupiter.api.Test
    void gasexc() {
        Exception y = assertThrows(RuntimeException.class, ()-> volvo.gas(1.5));
        assertEquals(y.getMessage(), "Fucking idiot");
    }

    @org.junit.jupiter.api.Test
    void brakeexc() {
        Exception y = assertThrows(RuntimeException.class, ()-> volvo.brake(1.5));
        assertEquals(y.getMessage(), "Fucking idiot");
    }
}
