
package cargame.domain;

import cargame.domain.Track;
import cargame.domain.TrackMaterial;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class TrackTest {
    
    Track testTrack;
    
    
    @Before
    public void setUp() {
        testTrack = new Track(10,10, "TestTrack");
    }

    @Test
    public void trackMapContainsEmptyMaterial() {        
        assertEquals(TrackMaterial.EMPTY, testTrack.content(5, 5));
    }
    
    @Test
    public void outsideTrackIsWall() {
        assertEquals(TrackMaterial.WALL, testTrack.content(15, 15));
    }
    
    @Test
    public void addingMaterialWorks() {
        testTrack.add(1, 1, TrackMaterial.CHECK1);
        assertEquals(TrackMaterial.CHECK1, testTrack.content(1, 1));
    }
}
