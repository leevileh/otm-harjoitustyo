

package cargame.domain;

import java.util.ArrayList;
import java.util.List;
import javafx.geometry.Point2D;
import javafx.scene.shape.Polygon;

public class Car {

    private Polygon car;
    private Point2D movement;
    private Track track;
    private Timer carTimer;
    private Boolean check2;
    private Boolean check3;
    
    public Car(int x, int y, Track track, Timer carTimer) {
        this.car = new Polygon(0, 0, 20, 0, 25, 5, 20, 10, 0, 10);
        this.car.setTranslateX(x);
        this.car.setTranslateY(y);
        
        this.track = track;
        this.carTimer = carTimer;
        this.check2 = false;
        this.check3 = false;
        this.movement = new Point2D(0, 0);
    }   
    
    public Polygon getCar() {
        return this.car;
    }
    
    public Track getTrack() {
        return this.track;
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
    
    public void move() {
        this.movement = this.movement.multiply(0.98);
        //this.track.content(this.car.getTranslateX(), this.car.getTranslateY()) == TrackMaterial.WALL
        if (hitsMaterial(TrackMaterial.WALL)) {
            this.setMovement(this.getMovement().multiply(-1));
            this.car.setTranslateX(this.car.getTranslateX() + this.movement.getX());
            this.car.setTranslateY(this.car.getTranslateY() + this.movement.getY()); 
            this.setMovement(this.getMovement().multiply(0.5));            
        }
        if (hitsMaterial(TrackMaterial.CHECK1) && check2 == true && check3 == true) {
            carTimer.reset();
            check2 = false;
            check3 = false;
            System.out.println("Kierrosaika tallennetaan");
//        } else {
//            carTimer.reset();
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
    
    public void accelerate() {
        double xChange = Math.cos(Math.toRadians(this.car.getRotate()));
        double yChange = Math.sin(Math.toRadians(this.car.getRotate()));
        
        xChange *= 0.1;
        yChange *= 0.1;
        
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
    
    public boolean hitsMaterial(TrackMaterial material) {
        List carVertices = new ArrayList<>();
        carVertices = this.car.getPoints();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (this.track.content(this.car.getTranslateX() -2 + i, this.car.getTranslateY() - 2 + i) == material) {
                    return true;
                }
//System.out.println(carVertices.get(i).toString() + "'" + carVertices.get(i+1).toString());                    
            }
        }
        return false;
    }

}
