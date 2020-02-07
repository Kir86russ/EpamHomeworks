package Homework23_Database.common.solutions.dbConnectors;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class Connector implements Connectible {

    private static final Connector INSTANCE = new Connector();

    private Connector() {
    }

    public static Connector getInstance() {
        return INSTANCE;
    }

    private Connection conn = null;

    @Override
    public Connection getConnection() {
        try {
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Database connection successful");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    @Override
    public void disconnect() {
        try {
            if (conn != null) {
                conn.close();
                System.out.println("Database disconnection successful");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}