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
    Player testPlayer;
    
    @Before
    public void setUp() {
        testTrack = new Track(100,100, "testTrack");
        testTimer = new Timer(testTrack);
        testPlayer = new Player();
        testCar = new Car(25, 25, testTrack, testTimer, testPlayer);
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
    
    @Test
    public void canNotMoveThroughWall() {
        testTrack.add(30, 25, TrackMaterial.WALL);
        testCar.setMovement(new Point2D(2, 0));
        for (int i = 0; i < 10; i++) {
            testCar.move();
        }
        assertTrue(testCar.getCar().getTranslateX() < 35);
    }
    
    @Test
    public void acceleratingMovesCar() {
        testCar.accelerate(1);
        for (int i = 0; i < 10; i++) {
            testCar.move();
        }
        assertTrue(testCar.getCar().getTranslateX() > 26);
    }
    
    @Test
    public void completedLapIsSavedOnCheck1() {
        testTrack.add(26, 25, TrackMaterial.CHECK2);
        testTrack.add(28, 25, TrackMaterial.CHECK3);
        testCar.accelerate(0.5);
        for (int i = 0; i < 10; i++) {
            testCar.getTimer().increase();
            testCar.move();
        }
        testCar.check1();
        testCar.getTimer().increase();
        assertEquals("00:01:0" , testCar.getPlayer().getLap());        
    }
    
    @Test
    public void uncompletedLapIsNotSavedOnCheck1() {
        testCar.check1();
        testCar.getTimer().increase();
        assertEquals(null , testCar.getPlayer().getLap()); 
        assertEquals("00:00:1" , testTimer.getTime());
    }
}
