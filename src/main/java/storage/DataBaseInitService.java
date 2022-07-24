package storage;

import prefs.Prefs;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class  DataBaseInitService {

    public void initDb(Storage storage) throws IOException {

        String initDbFilename = new Prefs().getString(Prefs.INIT_DB_SQL_FILE_PATH);
        String sql = String.join(
                "\n",
                Files.readAllLines(Paths.get(initDbFilename))
        );
        //storage.executeUpdate(sql);
    }

//        public void initDb(String connectionUrl) {
//            // Create the Flyway instance and point it to the database
//            Flyway flyway = Flyway
//                    .configure()
//                    .dataSource(connectionUrl, "sa", null)
//                    .load();
//
////        flyway.baseline();
//
//            // Start the migration
//            flyway.migrate();
//        }

}
