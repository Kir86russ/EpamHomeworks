package Homework23_Database.common.solutions.dbConnectors;

import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class PoolConnector implements Connectible {

    private static final PoolConnector INSTANCE = new PoolConnector();

    public PoolConnector() {
    }

    public static PoolConnector getInstance() {
        return INSTANCE;
    }

    private Connection conn = null;
    private static BasicDataSource dataSource;

    static {

        dataSource = new BasicDataSource();
        dataSource.setDriverClassName((DRIVER_CLASS));
        dataSource.setUrl(URL);
        dataSource.setUsername(USERNAME);
        dataSource.setPassword(PASSWORD);

        dataSource.setMinIdle(100);
        dataSource.setMaxIdle(1000);

    }

    public DataSource getDataSource() {
        return dataSource;
    }

    @Override
    public Connection getConnection() {
        try {
            conn = getDataSource().getConnection(); // DataSource's method
            System.out.println("Database connection successful (from connection-pool)");
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
                System.out.println("Database disconnection successful (in connection-pool)");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
