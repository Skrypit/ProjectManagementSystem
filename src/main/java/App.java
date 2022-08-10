import cli.CliFSM;
import storage.ConnectionProvider;
import storage.DatabaseInitService;

import java.sql.SQLException;

public class App {

    public static void main(String[] args) throws SQLException {

        new DatabaseInitService().initDb();

        ConnectionProvider connectionProvider = new ConnectionProvider();

        new CliFSM(connectionProvider);

        connectionProvider.close();

    }
}
/*
*    Developer
* create +
* show +
* delete +
* 5 +
* 6 +
* 7 +
*   Project
*
*   Company
*
*   Customer
*
* */
