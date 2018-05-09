package ru.asmi.ConnectionManager;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManagerJDBC implements ConnectionManager {

    private static ConnectionManager connectionManager;
    private final static Logger logger = Logger.getLogger(ConnectionManagerJDBC.class);

    public static ConnectionManager getInstance() {
        if(connectionManager == null)
            connectionManager = new ConnectionManagerJDBC();

        return connectionManager;
    }

    private ConnectionManagerJDBC() {}

    @Override
    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/StudentsSuccessfull", "root", "0805");
        } catch (ClassNotFoundException | SQLException e) {
            logger.error("Problem with connection with database");
        }
        return connection;
    }
}
