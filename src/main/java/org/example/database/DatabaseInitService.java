package org.example.database;

import org.example.prefs.Prefs;
import org.flywaydb.core.Flyway;


public class DatabaseInitService {
    public void initDB(){
        String connectionUrl = new Prefs().getPref(Prefs.DB_JDBC_CONNECTION_URL);

        Flyway flyway = Flyway
                .configure()
                .dataSource(connectionUrl, null, null)
                .load();

        flyway.migrate();

    }
}
