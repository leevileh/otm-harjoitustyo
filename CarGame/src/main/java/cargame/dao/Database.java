
package cargame.dao;

import java.sql.*;

public class Database {

    private String databaseAddress;
    
    /**
     * Sets the database with correct database address
     * @param databaseAddress database address to be used
     * @throws ClassNotFoundException 
     */
    
    public Database(String databaseAddress) throws ClassNotFoundException {
        this.databaseAddress = databaseAddress;
        
        try {
            Connection conn = DriverManager.getConnection(this.databaseAddress);
            Statement stmt = conn.createStatement();
            stmt.execute("CREATE TABLE IF NOT EXISTS Laptimes"
                    + "(id integer PRIMARY KEY,"
                    + "laptime varchar(20),"
                    + "intTime integer,"
                    + "playerName varchar(20)"
                    + ");");
        } catch (Exception e) {
            
        }
    }

    /**
     * Creates DriverManager connection with correct database address
     * @return Connection
     * @throws SQLException 
     */
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(databaseAddress);
    }
}