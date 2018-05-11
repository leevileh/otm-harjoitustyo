

package cargame.domain;

import java.util.ArrayList;
import java.util.List;

public class Player {
    
    private String name;
    private String lap;
    private List<String> lapTimes;
    private List<Integer> intTimes;
    
    public Player() {
        this.lapTimes = new ArrayList<>();
        this.intTimes = new ArrayList<>();
    }
    
    public Player(String name) {
        this.name = name;
        this.lapTimes = new ArrayList<>();
        this.intTimes = new ArrayList<>();
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setLap(String lapTime) {
        this.lapTimes.add(lapTime);
        this.lap = lapTime;
    }
    
    public String getLap() {
        return this.lap;
    }
    
    public List<String> getLaps() {
        return this.lapTimes;
    }
    
    public void setIntLap(int intTime) {
        this.intTimes.add(intTime);
    }
    
    public List<Integer> getIntTimes() {
        return this.intTimes;
    }        
}
