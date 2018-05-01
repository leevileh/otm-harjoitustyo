

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
    
    public String increase() {
        this.tenths ++;
        if (this.tenths == 10) {
            this.seconds ++;
            this.tenths = 0;
        }
        if (this.seconds == 59) {
            this.minutes ++;
            this.seconds = 0;
        }
        if (seconds < 10) {
            return("0" + minutes + ":" + "0" + seconds + ":" + tenths);
        } else {
            return(minutes + ":" + seconds + ":" + tenths);
        }
        
    }
    
    public void reset() {
        this.minutes = 0;
        this.seconds = 0;
        this.tenths = 0;
    }
    
}
