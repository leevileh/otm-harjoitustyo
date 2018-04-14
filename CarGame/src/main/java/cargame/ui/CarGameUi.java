

package cargame.ui;

import cargame.domain.Car;
import cargame.domain.Track;
import cargame.domain.TrackMaterial;
import java.util.HashMap;
import java.util.Map;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class CarGameUi extends Application{
    
    public static int WIDTH = 900;
    public static int HEIGHT = 600;
    
    @Override
    public void start(Stage stage) throws Exception {
        Pane gamePane = new Pane();
        gamePane.setPrefSize(WIDTH, HEIGHT);
        
        Canvas gameCanvas = new Canvas(WIDTH, HEIGHT);
        GraphicsContext plotter = gameCanvas.getGraphicsContext2D();
        plotter.setFill(Color.BLACK);
        
        gamePane.getChildren().add(gameCanvas);
        
        Car car = new Car(WIDTH/5, HEIGHT/5, new Track(WIDTH, HEIGHT));
        
        gameCanvas.setOnMouseDragged((event) -> {
            int coordinateX = (int) event.getX();
            int coordinateY = (int) event.getY();
            plotter.fillRect(coordinateX, coordinateY, 5, 5);
            for(int i = 0; i < 5; i++){
                for(int j = 0; j < 5; j++){
                    car.track.add(coordinateX - i-8, coordinateY - j, TrackMaterial.WALL);
                }
            }
        });
        
        
        
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
                
                if((pressedKeys.getOrDefault(KeyCode.UP, false)) == false){
                    car.decelerate();
                }
                
                if(pressedKeys.getOrDefault(KeyCode.DOWN, false)) {
                    car.reverse();
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
