


package cargame.domain;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class TimerTest {
    
    Timer testTimer;
    Track testTrack;
    
    @Before
    public void setUp() {
        testTrack = new Track(10, 10, "TestTrack");
        testTimer = new Timer(testTrack);
    }

    @Test
    public void SixHundredTenthsIsOneMinute() {
        for (int i = 0; i < 600; i++) {
            testTimer.increase();
        }
        assertEquals("01:00:0",testTimer.getTime());
    }

}
