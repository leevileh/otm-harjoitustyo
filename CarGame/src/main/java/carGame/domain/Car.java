

package carGame.domain;

import javafx.geometry.Point2D;
import javafx.scene.shape.Polygon;

public class Car {

    private Polygon car;
    private Point2D movement;
    public Track track;
    
    public Car(int x, int y, Track track) {
        this.car = new Polygon(0,0, 20,0, 25,5, 20,10, 0,10);
        this.car.setTranslateX(x);
        this.car.setTranslateY(y);
        
        this.track = track;
        
        this.movement = new Point2D(0, 0);
    }   
    
    public Polygon getCar() {
        return car;
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
        this.car.setRotate(this.car.getRotate() -5);
    }
    
    public void move() {
        if(this.track.content(this.car.getTranslateX(), this.car.getTranslateY()) == TrackMaterial.WALL) {
            this.car.setTranslateX(this.car.getTranslateX() - 5*this.movement.getX());
            this.car.setTranslateY(this.car.getTranslateY() - 5*this.movement.getY());            
        } else {
            this.car.setTranslateX(this.car.getTranslateX() + this.movement.getX());
            this.car.setTranslateY(this.car.getTranslateY() + this.movement.getY());
        }
    }
    
    public void accelerate() {
        double xChange = Math.cos(Math.toRadians(this.car.getRotate()));
        double yChange = Math.sin(Math.toRadians(this.car.getRotate()));
        
        xChange *= 0.05;
        yChange *= 0.05;
        
        this.movement = this.movement.add(xChange, yChange);
    }
    
    public void reverse() {
        double xChange = Math.cos(Math.toRadians(this.car.getRotate()));
        double yChange = Math.sin(Math.toRadians(this.car.getRotate()));
        
        xChange *= 0.05;
        yChange *= 0.05;
        
        this.movement = this.movement.add(-xChange, -yChange);
    }
    
    public void decelerate() {
        this.movement = this.movement.multiply(0.98);
    }

}
