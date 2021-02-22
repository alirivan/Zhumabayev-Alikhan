package data;

import data.interfaces.IDBManager;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBManager implements IDBManager {
    @Override
    public Connection getConnection() {

        try {
            Class.forName("org.postgresql.Driver");

            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost;5432/Java_Ass3", "postgreSQL", "Alik1234");
            return connection;
        }

        catch (Exception e) {
            e.printStackTrace();
        }

        return getConnection();
    }
}

