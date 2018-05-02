/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cargame.domain;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import javafx.geometry.Point2D;

/**
 *
 * @author leevileh
 */
public class CarTest {
    
    Car testCar;
    Track testTrack;
    Timer testTimer;
    
    @Before
    public void setUp() {
        testTrack = new Track(100,100, "testTrack");
        testTimer = new Timer(testTrack);
        testCar = new Car(25, 25, testTrack, testTimer);
    }

    @Test
    public void getCarWorks() {
        assertNotNull("method getCar() returns null", testCar.getCar());
    }
    
    @Test
    public void setAndGetMovementWorks() {
        testCar.setMovement(new Point2D(1, 1));
        assertEquals("Point2D [x = 1.0, y = 1.0]", testCar.getMovement().toString());
    }
    
    @Test
    public void turnRightWorks() {
        testCar.turnRight();
        double rotate = testCar.getCar().getRotate();
        assertEquals("5.0", Double.toString(rotate));
    }
    
    @Test
    public void turnLeftWorks() {
        testCar.turnLeft();
        double rotate = testCar.getCar().getRotate();
        assertEquals("-5.0", Double.toString(rotate));
    }
    
    @Test
    public void movingOnEmptyTrackWorks() {
        testCar.setMovement(new Point2D(1, 1));
        testCar.move();
        assertTrue(testCar.getCar().getTranslateX() == 25.98 
                && testCar.getCar().getTranslateY() == 25.98);
    }
    
//    @Test
//    public void canNotMoveThroughWall() {
//        testTrack.add(30, 25, TrackMaterial.WALL);
//        testCar.setMovement(new Point2D(5, 0));
//        for (int i = 0; i < 10; i++) {
//            testCar.move();
//        }
//        assertTrue(testCar.getCar().getTranslateX() < 26);
//    }
}
