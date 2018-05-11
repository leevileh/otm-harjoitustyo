

package cargame.domain;


public class Timer {
    private int minutes;
    private int seconds;
    private int tenths;
    private Track track;
    
    public Timer(Track track) {
        this.track = track;
        this.minutes = 0;
        this.seconds = 0;
        this.tenths = 0;
    }
    
    /**
     * Increases timer by 1/10 of a second
     */
    
    public void increase() {
        this.tenths++;
        if (this.tenths == 10) {
            this.seconds++;
            this.tenths = 0;
        }
        if (this.seconds == 60) {
            this.minutes++;
            this.seconds = 0;
        }
    }
    
    /**
     * Time looks nicer in string format when the amount of characters doesn't change
     * @return time in string format
     */
    
    public String getTime() {
        if (seconds < 10) {
            return ("0" + minutes + ":" + "0" + seconds + ":" + tenths);
        } else {
            return ("0" + minutes + ":" + seconds + ":" + tenths);
        }        
    }
    
    /**
     * Used for comparing laptimes with each other
     * @return time as a sum of 1/10 seconds
     */
    
    public Integer getIntegerTime() {
        return (tenths + 10 * seconds + 600 * minutes);
    }
    
    public void reset() {
        this.minutes = 0;
        this.seconds = 0;
        this.tenths = 0;
    }    
}
