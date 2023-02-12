package org.example;

import org.example.database.Database;
import org.example.database.DatabaseInitService;
import org.example.service.ClientService;

import java.sql.SQLException;


public class Main {
    public static void main(String[] args) throws SQLException {
        Database database = Database.getInstance();
        new DatabaseInitService().initDB();
       ClientService clientService = new ClientService(database.getConnection());
    }
}