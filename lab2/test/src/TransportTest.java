package src;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
        Exception y = assertThrows(RuntimeException.class, () -> transport.changeAngle(10));
        assertEquals(y.getMessage(), "Cant change angle while driving");
    }

    @org.junit.jupiter.api.Test
    void startDriveWithAngle() {
        transport.changeAngle(10);
        Exception y = assertThrows(RuntimeException.class, () -> transport.startEngine());
        assertEquals(y.getMessage(), "Cant start if flaks angle not 0");
    }


    @Test
    void avståndsformeln() {
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

    @Test
    void offLoadCargo() {
    }
}