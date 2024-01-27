package src;

import static org.junit.jupiter.api.Assertions.*;

class ScaniaTest {
    private Scania scania;
    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        scania = new Scania();
    }

    @org.junit.jupiter.api.Test
    void speedFactor() {
        assertEquals(1, scania.speedFactor());
    }

    @org.junit.jupiter.api.Test
    void getAngle() {
        assertEquals(0, scania.getAngle());
    }

    @org.junit.jupiter.api.Test
    void changeAngle() {
        int tmp1 = scania.getAngle();
        scania.changeAngle(10);
        assertNotEquals(tmp1, scania.getAngle());
    }
    @org.junit.jupiter.api.Test
    void angleLimit(){
        Exception y = assertThrows(RuntimeException.class, () -> scania.changeAngle(80));
        assertEquals(y.getMessage(), "Angle can only be between 0 and 70");
    }

    @org.junit.jupiter.api.Test
    void changeAngleWhileDriving(){
        scania.startEngine();
        Exception y = assertThrows(RuntimeException.class, () -> scania.changeAngle(10));
        assertEquals(y.getMessage(), "Cant change angle while driving");
    }

    @org.junit.jupiter.api.Test
    void startDriveWithAngle() {
        scania.changeAngle(10);
        Exception y = assertThrows(RuntimeException.class, () -> scania.startEngine());
        assertEquals(y.getMessage(), "Cant start if flaks angle not 0");
    }
}