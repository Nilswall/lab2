package src;

import java.awt.*;
import java.awt.geom.Point2D;

import static java.lang.System.out;
import static org.junit.jupiter.api.Assertions.*;

class Saab95Test {
    private Saab95 saab;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        saab = new Saab95();
    }

    @org.junit.jupiter.api.Test
    void getNrDoors() {
        assertEquals(2, saab.getNrDoors());
    }

    @org.junit.jupiter.api.Test
    void getEnginePower() {
        assertEquals(125, saab.getEnginePower());
    }

    @org.junit.jupiter.api.Test
    void getCurrentSpeed() {
        assertEquals(saab.getCurrentSpeed(), saab.currentSpeed);
    }

    @org.junit.jupiter.api.Test
    void getColor() {
        assertEquals(saab.getColor(), Color.RED);
    }

    @org.junit.jupiter.api.Test
    void setColor() {
        saab.setColor(Color.BLUE);
        assertEquals(saab.getColor(), Color.BLUE);
    }

    @org.junit.jupiter.api.Test
    void startEngine() {
        saab.startEngine();
        assertEquals(saab.getCurrentSpeed(), 0.1);
    }

    @org.junit.jupiter.api.Test
    void stopEngine() {
        saab.startEngine();
        saab.stopEngine();
        assertEquals(saab.getCurrentSpeed(), 0);
    }

    @org.junit.jupiter.api.Test
    void move() {
        Point2D tmp1 = new Point2D.Double(saab.getpoint().getX(), saab.getpoint().getY());
        saab.startEngine();
        saab.move();
        assertNotEquals(saab.getpoint(), tmp1);
    }

    @org.junit.jupiter.api.Test
    void turnLeft() {
        Point tmp1 = new Point(saab.getDirection().x, saab.getDirection().y);
        saab.turnLeft();
        Point turnedtmp1 = new Point(-tmp1.y, tmp1.x);
        assertEquals(turnedtmp1, saab.getDirection());
    }

    @org.junit.jupiter.api.Test
    void turnRight() {
        Point tmp1 = new Point(saab.getDirection().x, saab.getDirection().y);
        saab.turnRight();
        Point turnedtmp1 = new Point(tmp1.y, -tmp1.x);
        assertEquals(turnedtmp1, saab.getDirection());
    }

    @org.junit.jupiter.api.Test
    void incrementSpeed() {
        double tmp1 = saab.getCurrentSpeed();
        saab.incrementSpeed(1);
        assertNotEquals(tmp1, saab.getCurrentSpeed());
    }

    @org.junit.jupiter.api.Test
    void decrementSpeed() {
        saab.startEngine();
        double tmp1 = saab.getCurrentSpeed();
        saab.decrementSpeed(1);
        assertNotEquals(tmp1, saab.getCurrentSpeed());
    }
    @org.junit.jupiter.api.Test
    void setTurbo() {
        boolean thebool = saab.turboOn;
        saab.setTurboOn();
        assertNotEquals(saab.turboOn, thebool);
    }
    @org.junit.jupiter.api.Test
    void setTurbooff() {
        saab.setTurboOn();
        boolean thebool = saab.turboOn;
        saab.setTurboOff();
        assertNotEquals(thebool, saab.turboOn);
    }
    @org.junit.jupiter.api.Test
    void brake() {
        saab.startEngine();
        double tmp1 = saab.getCurrentSpeed();
        saab.brake(0.5);
        assertNotEquals(tmp1, saab.getCurrentSpeed());

}
    @org.junit.jupiter.api.Test
    void gas() {
        saab.startEngine();
        double tmp1 = saab.getCurrentSpeed();
        saab.gas(0.5);
        assertNotEquals(tmp1, saab.getCurrentSpeed());
}
    @org.junit.jupiter.api.Test
    void gasexc() {
        Exception y = assertThrows(RuntimeException.class, () -> saab.gas(1.5));
        assertEquals(y.getMessage(), "Fucking idiot");
    }
    @org.junit.jupiter.api.Test
    void brakeexc() {
        Exception y = assertThrows(RuntimeException.class, () -> saab.brake(1.5));
        assertEquals(y.getMessage(), "Fucking idiot");
    }
}
