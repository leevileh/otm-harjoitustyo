
package cargame.dao;

import cargame.domain.Track;
import cargame.dao.Database;
import cargame.domain.TrackMaterial;
import cargame.ui.CarGameUi;
import java.util.*;
import java.sql.*;

public class DbTrackDao {

    private Database database;
    
    public DbTrackDao(Database database) {
        this.database = database;
    }
    
    /**
     * Saves each coordinate of a track, together with its material
     * @param track which is saved
     * @param material in coordinate (EMPTY is classified as material)
     * @throws SQLException 
     */
    
    public void save(Track track, TrackMaterial material) throws SQLException {        
        for (int i = 0; i < track.getWidth(); i++) {
            for (int j = 0; j < track.getHeigth(); j++) {
                if (track.content(i, j) == material) {
                    saveCoordinate(i, j, 1, material.ordinal() + 1);
                }
            }
        }
    }
    
    /**
     * Saves an individual coordinate into the database
     * @param x
     * @param y
     * @param trackId is used to recognize coordinates from different tracks
     * @param materialId is used to encode different materials
     * @throws SQLException 
     */
    
    private void saveCoordinate(int x, int y, int trackId, int materialId) throws SQLException {
        Connection conn = database.getConnection();
        PreparedStatement stmt = conn.prepareStatement("INSERT INTO coordinate"
                + "(xCoordinate, yCoordinate, track_id, material_id)"
                + " VALUES (?, ?, ?, ?)");
        stmt.setInt(1, x);
        stmt.setInt(2, y);
        stmt.setInt(3, trackId);
        stmt.setInt(4, materialId);        
        stmt.executeUpdate();
        stmt.close(); 
        conn.close();
    }
    
    /**
     * Finds all coordinates of a track
     * @return Track with all materials set
     * @throws SQLException 
     */
    
    public Track findTrack() throws SQLException {
        Track foundTrack = new Track(CarGameUi.WIDTH, CarGameUi.HEIGHT, "DbTrack");
        Connection conn = database.getConnection();
        PreparedStatement stmt = conn.prepareStatement("Select * FROM coordinate");        
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {            
            if (rs.getInt("material_id") == 3 && foundTrack.content(rs.getInt("xCoordinate"), rs.getInt("yCoordinate")) == TrackMaterial.EMPTY) {
                foundTrack.add(rs.getInt("xCoordinate"), rs.getInt("yCoordinate"), TrackMaterial.CHECK1);
            }
            if (rs.getInt("material_id") == 4 && foundTrack.content(rs.getInt("xCoordinate"), rs.getInt("yCoordinate")) == TrackMaterial.EMPTY) {
                foundTrack.add(rs.getInt("xCoordinate"), rs.getInt("yCoordinate"), TrackMaterial.CHECK2);
            }
            if (rs.getInt("material_id") == 5 && foundTrack.content(rs.getInt("xCoordinate"), rs.getInt("yCoordinate")) == TrackMaterial.EMPTY) {
                foundTrack.add(rs.getInt("xCoordinate"), rs.getInt("yCoordinate"), TrackMaterial.CHECK3);
            }
            if (rs.getInt("material_id") == 2) {
                foundTrack.add(rs.getInt("xCoordinate"), rs.getInt("yCoordinate"), TrackMaterial.WALL);
            }
        }
        stmt.close();
        rs.close();
        conn.close();         
        return foundTrack;
    }
}


