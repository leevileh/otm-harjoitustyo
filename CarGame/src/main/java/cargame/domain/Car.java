
package cargame.domain;

/**
 * Class that is responsible for the movement of the car
 */

import javafx.geometry.Point2D;
import javafx.scene.shape.Polygon;

public class Car {

    private Polygon car;
    private Point2D movement;
    private Track track;
    private Timer carTimer;
    private Boolean check2;
    private Boolean check3;
    private Player player;
    
    public Car(int x, int y, Track track, Timer carTimer, Player player) {
        this.car = new Polygon(0, 0, 20, 0, 25, 5, 20, 10, 0, 10);
        this.car.setTranslateX(x);
        this.car.setTranslateY(y);
        
        this.track = track;
        this.carTimer = carTimer;
        this.check2 = false;
        this.check3 = false;
        this.movement = new Point2D(0, 0);
        this.player = new Player();
    }   
    
    public Polygon getCar() {
        return this.car;
    }
    
    public Track getTrack() {
        return this.track;
    }
    
    public Player getPlayer() {
        return this.player;
    }
    
    public Timer getTimer() {
        return this.carTimer;
    }
    
    public void setMovement(Point2D movement) {
        this.movement = movement;
    }  
    
    public Point2D getMovement() {
        return movement;
    }
    
    public void turnRight() {
        this.car.setRotate(this.car.getRotate() + 5);
    }
    
    public void turnLeft() {
        this.car.setRotate(this.car.getRotate() - 5);
    }
    
    /**
     * What happens when the car moves and encounters different materials
     */
    
    public void move() {
        this.movement = this.movement.multiply(0.98);
        if (hitsMaterial(TrackMaterial.WALL)) {
            hitsWall();            
        }
        if (hitsMaterial(TrackMaterial.CHECK1)) {
            check1();
        }
        if (hitsMaterial(TrackMaterial.CHECK2)) {
            check2 = true;
        }
        if (hitsMaterial(TrackMaterial.CHECK3)) {
            check3 = true;
        }
        this.car.setTranslateX(this.car.getTranslateX() + this.movement.getX());
        this.car.setTranslateY(this.car.getTranslateY() + this.movement.getY());        
    }
    
    /**
     * Changing the speed of the car
     * @param factor gives the amount of acceleration, where positive amount is forward and negative backward
     */
    
    public void accelerate(double factor) {
        double xChange = Math.cos(Math.toRadians(this.car.getRotate()));
        double yChange = Math.sin(Math.toRadians(this.car.getRotate()));
        
        xChange *= factor;
        yChange *= factor;
        
        this.movement = this.movement.add(xChange, yChange);
    }
    
    /**
     * Makes the car slow down a bit like air resistance does in real life 
     */
    
    public void decelerate() {
        this.movement = this.movement.multiply(0.98);
    }
    
    /**
     * Gives a larger area than just a single point for the car to hit materials
     * @param material specifies which material the car should hit so that true is returned
     * @return true if the car hits the material specified
     */
    
    public boolean hitsMaterial(TrackMaterial material) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (this.track.content(this.car.getTranslateX() - 5 + i, this.car.getTranslateY() - 5 + i) == material) {
                    return true;
                }                   
            }
        }
        return false;
    }
    
    /**
     * Makes the car bump backwards when hitting a wall
     */
    
    public void hitsWall() {
        this.setMovement(this.getMovement().multiply(-1));
        this.car.setTranslateX(this.car.getTranslateX() + this.movement.getX());
        this.car.setTranslateY(this.car.getTranslateY() + this.movement.getY()); 
        this.setMovement(this.getMovement().multiply(0.2));
    }
    
    /**
     * Saves laptime and resets timer if lap has been driven through the checkpoints in the correct order 
     * Otherwise only resets timer
     */
    
    public void check1() {
        if (check2 == true && check3 == true) {
            check2 = false;
            check3 = false;
            this.player.setLap(carTimer.getTime());
            this.player.setIntLap(carTimer.getIntegerTime());
        }
        carTimer.reset();
    }

}
