package src;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.geom.Point2D;

import static java.lang.Math.sqrt;
import static org.junit.jupiter.api.Assertions.*;

class TransportTest {
    private Transport transport;
    @BeforeEach
    void setUp() {
        transport = new Transport();
    }

    @org.junit.jupiter.api.Test
    void changeAngle() {
        transport.changeAngle(90);
        assertEquals(transport.getAngle(), 90);
    }

    @org.junit.jupiter.api.Test
    void angleException() {
        Exception y = assertThrows(RuntimeException.class, () -> transport.changeAngle(80));
        assertEquals(y.getMessage(), "Angle can only be up or down");
    }

    @org.junit.jupiter.api.Test
    void changeAngleWhileDriving(){
        transport.startEngine();
        Exception y = assertThrows(RuntimeException.class, () -> transport.changeAngle(90));
        assertEquals(y.getMessage(), "Cant change angle while driving");
    }

    @org.junit.jupiter.api.Test
    void startDriveWithAngle() {
        transport.changeAngle(90);
        Exception y = assertThrows(RuntimeException.class, () -> transport.startEngine());
        assertEquals(y.getMessage(), "Cant start if flaks angle not 0");
    }


    @Test
    void avståndsformeln() {
        Point2D point1 = new Point2D.Double(0, 0);
        Point2D point2 = new Point2D.Double(1, 1);
        double dist = transport.avståndsformeln(point1, point2);
        assertEquals(dist, sqrt(2));
    }

    @org.junit.jupiter.api.Test
    void loadCargoWhileDrive() {
        transport.startEngine();
        Car car = new Saab95();
        Exception y = assertThrows(RuntimeException.class, () -> transport.loadCargo(car));
        assertEquals(y.getMessage(), "Cant load while driving");
    }
    @org.junit.jupiter.api.Test
    void fullCargo() {
        Car car = new Saab95();
        transport.loadCargo(car);
        Car car1 = new Volvo240();
        Exception y = assertThrows(RuntimeException.class, () -> transport.loadCargo(car1));
        assertEquals(y.getMessage(), "Transport full");
    }
    @org.junit.jupiter.api.Test
    void loadCargoAngle(){
        transport.changeAngle(90);
        Car car = new Saab95();
        Exception y = assertThrows(RuntimeException.class, () -> transport.loadCargo(car));
        assertEquals(y.getMessage(), "Cant load without ramp down");
    }

    @org.junit.jupiter.api.Test
    void offLoadCargoWhileDrive() {
        Car car = new Saab95();
        transport.loadCargo(car);
        transport.startEngine();
        Exception y = assertThrows(RuntimeException.class, () -> transport.offLoadCargo());
        assertEquals(y.getMessage(), "Cant offload while driving");
    }

    @org.junit.jupiter.api.Test
    void offloadCargoWhileAngle() {
        Car car = new Saab95();
        transport.loadCargo(car);
        transport.changeAngle(90);
        Exception y = assertThrows(RuntimeException.class, () -> transport.offLoadCargo());
        assertEquals(y.getMessage(), "Cant offload without ramp down");
    }
}
