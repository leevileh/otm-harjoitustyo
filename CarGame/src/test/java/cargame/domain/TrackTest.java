
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
    
    public TrackTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void trackMapContainsEmptyMaterial() {
        Track testTrack = new Track(10,10);
        assertEquals(TrackMaterial.EMPTY, testTrack.content(5, 5));
    }
}
