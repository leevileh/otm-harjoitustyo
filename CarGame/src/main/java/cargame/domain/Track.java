

package cargame.domain;

import java.util.HashMap;
import java.util.Map;

public class Track {
    private Map<Integer, HashMap<Integer, TrackMaterial>> trackMap;
    private int width;
    private int height;
    private String name;
    
    public Track(int width, int height, String name) {
        this.trackMap = new HashMap<>();
        this.width = width;
        this.height = height;
        this.name = name;
        
        for (int i = 0; i <= width; i++) {
            this.trackMap.putIfAbsent(i, new HashMap<>());
            
            for (int j = 0; j <= height; j++) {
                this.trackMap.get(i).putIfAbsent(j, TrackMaterial.EMPTY);
            }
        }
    }
    
    /**
     * Adds a certain material to a certain coordinate
     * @param x
     * @param y
     * @param material 
     */
    
    public void add(int x, int y, TrackMaterial material) {
        if (x > 0 && x < this.width && y > 0 && y < this.height) {
            this.trackMap.get(x).put(y, material);
        }
    }
    
    /**
     * Finds which material a coordinate contains
     * @param x
     * @param y
     * @return 
     */
    
    public TrackMaterial content(double x, double y) {
        if (x <= 0 || y <= 0 || x > width || y > height) {
            return TrackMaterial.WALL;
        } else {
            return trackMap.get((int) x).get((int) y);
        }
        
    }
    
    public Integer getWidth() {
        return this.width;
    }
    
    public Integer getHeigth() {
        return this.height;
    }
    
    public String getName() {
        return this.name;
    }
}
