package storage;

import lombok.Data;
import prefs.Prefs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

@Data
public class Storage {

    private static final Storage INSTANCE = new Storage();

    private Connection conn;

    private Storage() {
        try {

            String dbUrl = new Prefs().getString(Prefs.DB_JDBC_CONNECTION_URL);
            String dbUser = new Prefs().getString(Prefs.DB_JDBC_USERNAME);
            String dbPassword = new Prefs().getString(Prefs.DB_JDBC_PASSWORD);

            conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Storage getInstance() {
        return INSTANCE;
    }

    public Connection getConnection() {
        return conn;
    }

    public int executeUpdate(String sql) {
        try (Statement st = conn.createStatement()) {
            return st.executeUpdate(sql);
        } catch (Exception ex) {
            ex.printStackTrace();
            return -1;
        }
    }

    public void close() {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
