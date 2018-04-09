

package carGame.ui;

import carGame.domain.Car;
import java.util.HashMap;
import java.util.Map;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class CarGameUi extends Application{
    
    public static int WIDTH = 900;
    public static int HEIGHT = 600;
    
    @Override
    public void start(Stage stage) throws Exception {
        Pane gamePane = new Pane();
        gamePane.setPrefSize(WIDTH, HEIGHT);
        
        Car car = new Car(WIDTH/5, HEIGHT/5);
        
        gamePane.getChildren().add(car.getCar());
        
        Scene scene = new Scene(gamePane);
        
        Map<KeyCode, Boolean> pressedKeys = new HashMap<>();
        
        scene.setOnKeyPressed(event -> {
            pressedKeys.put(event.getCode(), Boolean.TRUE);
        });
        
        scene.setOnKeyReleased(event -> {
            pressedKeys.put(event.getCode(), Boolean.FALSE);
        });
        
        new AnimationTimer() {
            @Override
            public void handle(long now){
                if(pressedKeys.getOrDefault(KeyCode.LEFT, false)){
                    car.turnLeft();
                }
                
                if(pressedKeys.getOrDefault(KeyCode.RIGHT, false)){
                    car.turnRight();
                }
                
                if(pressedKeys.getOrDefault(KeyCode.UP, false)){
                    car.accelerate();
                }
                
                car.move();
            }
        }.start();
        
        stage.setTitle("Let's Play!");
        stage.setScene(scene);
        stage.show();
    }
    
    public static void main(String[] args) {
        System.out.println("The game is running...");
        launch(args);
    }    
    
}
