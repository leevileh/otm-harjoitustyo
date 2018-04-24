

package cargame.ui;

import cargame.dao.Database;
import cargame.dao.DbTrackDao;
import cargame.domain.Car;
import cargame.domain.Track;
import cargame.domain.TrackMaterial;
import java.io.File;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class CarGameUi extends Application{
    
    public static int WIDTH = 900;
    public static int HEIGHT = 700;
    
    @Override
    public void start(Stage stage) throws Exception{
        
        File tiedosto = new File("db", "cargame.db");
        Database database = new Database("jdbc:sqlite:" + tiedosto.getAbsolutePath());
        
        DbTrackDao trackSaverDao = new DbTrackDao(database);
        
        // Starting view
        Label instructionText = new Label("Enter name of player:");
        TextField nameField = new TextField();
        Button startButton = new Button("Start!");
        
        GridPane startPane = new GridPane();
        
        startPane.add(instructionText, 0, 0);
        startPane.add(nameField, 0, 1);
        startPane.add(startButton, 0, 2);
        
        startPane.setPrefSize(WIDTH, HEIGHT);
        startPane.setAlignment(Pos.CENTER);
        startPane.setVgap(10);
        startPane.setHgap(10);
        startPane.setPadding(new Insets(20, 20, 20, 20));
        
        Scene startScene = new Scene(startPane);
        
        
        //Game view
        Pane gamePane = new Pane();
        gamePane.setPrefSize(WIDTH, HEIGHT);
        
        Canvas gameCanvas = new Canvas(WIDTH, HEIGHT - 100);
        GraphicsContext plotter = gameCanvas.getGraphicsContext2D();
        plotter.setFill(Color.BLACK);
        
        Button saveButton = new Button("Save track");
        
        gamePane.getChildren().add(gameCanvas);
//        gamePane.getChildren().add(saveButton);
        
        Track gameTrack = trackSaverDao.findTrack();
        Car car = new Car(WIDTH/5, (HEIGHT)/5, gameTrack);
        
        for(int i = 0; i < WIDTH; i++) {
            for(int j = 0; j < HEIGHT; j++) {
                if(gameTrack.content(i, j) == TrackMaterial.WALL) {
                    plotter.fillRect(i, j, 1, 1);
                }
            }
        }
        
        gameCanvas.setOnMouseDragged((event) -> {
            int coordinateX = (int) event.getX();
            int coordinateY = (int) event.getY();
            plotter.fillRect(coordinateX, coordinateY, 2, 2);
            
            for(int i = 0; i < 2; i++){
                for(int j = 0; j < 2; j++){
                    car.getTrack().add(coordinateX + i, coordinateY + j, TrackMaterial.WALL);
                }
            }
        });
        
        gamePane.getChildren().add(car.getCar());
        
        Scene gameScene = new Scene(gamePane);
        
        Map<KeyCode, Boolean> pressedKeys = new HashMap<>();
        
        gameScene.setOnKeyPressed(event -> {
            pressedKeys.put(event.getCode(), Boolean.TRUE);
        });
        
        gameScene.setOnKeyReleased(event -> {
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
        
        //Switching and starting scene
        
        startButton.setOnAction((event) -> {
            stage.setScene(gameScene);
        });
        
        saveButton.setOnAction((event) -> {
            try {
                trackSaverDao.save(gameTrack);
            } catch (SQLException ex) {
                Logger.getLogger(CarGameUi.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        
        stage.setTitle("Let's Play!");
        stage.setScene(startScene);
        stage.show();
    }
    
    public static void main(String[] args) throws ClassNotFoundException {
        File tiedosto = new File("db", "cargame.db");
        Database database = new Database("jdbc:sqlite:" + tiedosto.getAbsolutePath());
        
        DbTrackDao trackSaverDao = new DbTrackDao(database);
        
        System.out.println("The game is running...");
        launch(args);
    }    
    
}
