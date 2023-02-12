package org.example.service;

import org.example.model.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientService {
    private final PreparedStatement createClient;
    private final PreparedStatement getByIdClient;
    private final PreparedStatement setNameClient;
    private final PreparedStatement deleteByIdClient;

    private final PreparedStatement allClients;
    private final PreparedStatement selectMaxIdSt;

    public ClientService(Connection connection) throws SQLException {
        this.createClient = connection
                .prepareStatement("INSERT INTO client (name) VALUES(?)");
        this.getByIdClient = connection
                .prepareStatement("SELECT name FROM client WHERE id = ?");
        this.setNameClient = connection
                .prepareStatement("UPDATE client SET name = ? WHERE id = ?");
        this.deleteByIdClient = connection
                .prepareStatement("DELETE FROM client WHERE id = ?");
        this.allClients = connection.prepareStatement("SELECT id, name FROM client");
        this.selectMaxIdSt = connection.prepareStatement("SELECT max(id) AS maxId FROM client");
    }


    public long create(String name) {
        long id = 0;
        try {
            createClient.setString(1, name);
            createClient.executeUpdate();

            ResultSet resultSet = selectMaxIdSt.executeQuery();
            resultSet.next();
            id = resultSet.getLong("maxId");
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    public String  getById(long id) {
        String name = "";
        try {
            getByIdClient.setLong(1, id);
            ResultSet resultSet = getByIdClient.executeQuery();
            resultSet.next();
            name = resultSet.getString("name");
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return name;
    }

    public void setNane(long id, String name) {
        try  {
            setNameClient.setString(1, name);
            setNameClient.setLong(2, id);
            setNameClient.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteById(long id) {
        try {
            deleteByIdClient.setLong(1, id);
            deleteByIdClient.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<Client> listAll(){
        ArrayList<Client> clients = new ArrayList<>();

        try(ResultSet resultSet = allClients.executeQuery()){
            while (resultSet.next()){
                clients.add(new Client(
                        resultSet.getLong("id"),
                        resultSet.getString("name")
                        ));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return clients;
    }
}
