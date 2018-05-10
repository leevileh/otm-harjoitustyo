
package cargame.dao;

import cargame.domain.Player;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class DbPlayerDao {

    private Database database;
    
    public DbPlayerDao(Database database) {
        this.database = database;
    }
    
    public void savePlayersLaps(Player player) throws SQLException {
        List<String> laptimes = player.getLaps();
        List<Integer> intTimes = player.getIntTimes();        
        for (int i = 0; i < laptimes.size(); i++) {
            saveLapTime(laptimes.get(i), intTimes.get(i), player.getName());
        }
    }
    
    public void saveLapTime(String laptime, int intTime, String playerName) throws SQLException {
        Connection conn = database.getConnection();
        PreparedStatement stmt = conn.prepareStatement("INSERT INTO Laptimes"
                + "(laptime, intTime, playerName)"
                + " VALUES (?, ?, ?)");        
        stmt.setString(1, laptime);
        stmt.setInt(2, intTime);
        stmt.setString(3, playerName);
        stmt.executeUpdate();
        stmt.close();
    }
    
    public List<Player> findAll() throws SQLException {
        List<Player> foundList = new ArrayList<>();
        Connection conn = database.getConnection();
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Laptimes ORDER BY intTime");
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) { 
            String name = rs.getString("playerName");
            Player foundPlayer = new Player(name);
            String laptime = rs.getString("laptime");
            Integer intTime = rs.getInt("intTime");
           
            foundPlayer.setLap(laptime);
            foundList.add(foundPlayer);
        }
        return foundList;
    }    
}
