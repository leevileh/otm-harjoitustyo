

package carGame.domain;

import javafx.geometry.Point2D;
import javafx.scene.shape.Polygon;

public class Car {

    private Polygon car;
    private Point2D movement;
    
    public Car(int x, int y) {
        this.car = new Polygon(0,0, 20,0, 25,5, 20,10, 0,10);
        this.car.setTranslateX(x);
        this.car.setTranslateY(y);
    }
    
    public Polygon getCar() {
        return car;
    }
}
