package Homework23_Database.common.solutions.dbConnectors;

import java.sql.Connection;
import java.sql.SQLException;

public interface Connectible {

    String USERNAME = "postgres";
    String PASSWORD = "karate24";
    String URL = "jdbc:postgresql://localhost:5432/epam";
    String DRIVER_CLASS = "org.postgresql.Driver";

    Connection getConnection() throws SQLException;

    void disconnect() throws Exception;
}
