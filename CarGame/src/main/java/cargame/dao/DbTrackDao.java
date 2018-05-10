
package cargame.dao;

import cargame.domain.Track;
import cargame.dao.Database;
import cargame.domain.TrackMaterial;
import cargame.ui.CarGameUi;
import java.util.*;
import java.sql.*;

public class DbTrackDao implements TrackDao<Track, Integer> {

    private Database database;
    
    public DbTrackDao(Database database) {
        this.database = database;
    }
    
    public void save(Track track, TrackMaterial material) throws SQLException {        
        for (int i = 0; i < track.getWidth(); i++) {
            for (int j = 0; j < track.getHeigth(); j++) {
                if (track.content(i, j) == material) {
                    saveCoordinate(i, j, 1, material.ordinal() + 1);
                }
            }
        }
    }
    
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
    }
    
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


