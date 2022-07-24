import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AppTest {

    private static Connection connection;
    @Before
    public void init() throws SQLException {
        connection = getNewConnection();
    }
    @After
    public void close() throws SQLException {
        connection.close();
    }

    private Connection getNewConnection() throws SQLException {
        String dbUrl = "jdbc:h2:./test";
        String dbUser = "sa";
        String dbPassword = "";
        return DriverManager.getConnection(dbUrl, dbUser, dbPassword);
    }
    @Test
    public void shouldGetJdbcConnection() throws SQLException {
        try(Connection connection = getNewConnection()) {
            assertTrue(connection.isValid(1));
            assertFalse(connection.isClosed());
        }
    }
}
