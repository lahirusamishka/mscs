/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.mscs.resource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author samishka
 */
public class DBConnection {

    private static DBConnection dBConnection;
    private static final int MAXCONNPOOL = 10;
    private ArrayList<Connection> idleConnection = new ArrayList<>();
    private ArrayList<Connection> usedConnection = new ArrayList<>();

    private DBConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            for (int i = 0; i < MAXCONNPOOL; i++) {
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "samishka");
                idleConnection.add(connection);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static DBConnection getInstance() {
        if (dBConnection == null) {
            dBConnection = new DBConnection();
        }
        return dBConnection;
    }

    public synchronized Connection getConnection() {
        try {
            wait();
        } catch (InterruptedException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        Connection connection = idleConnection.get(0);
        usedConnection.add(connection);
        return connection;
    }

    public synchronized void releaseConnection(Connection connection) {
        idleConnection.add(connection);
        usedConnection.remove(connection);
        notifyAll();
    }

    public synchronized void releaseAllConnection() {
        for (Connection connection : usedConnection) {
            idleConnection.add(connection);
        }
        usedConnection.removeAll(usedConnection);
        notifyAll();
    }
}
