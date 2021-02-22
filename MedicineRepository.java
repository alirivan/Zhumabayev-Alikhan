package repositories;

import data.interfaces.IDBManager;
import entities.Medicine;
import repositories.interfaces.IMedicineRepository;

import java.sql.*;
import java.util.ArrayList;

public class MedicineRepository implements IMedicineRepository {
    private final IDBManager dbManager;

    public MedicineRepository(IDBManager dbManager) {
        this.dbManager = dbManager;
    }

    @Override
    public ArrayList<Medicine> searchMedicineByName(String name) {
        Connection connection = null;

        try {
            connection = dbManager.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM medicines WHERE name LIKE'%" + name + "%'");

            ResultSet resultSet = preparedStatement.executeQuery();

            ArrayList<Medicine> medicines = new ArrayList<>();

            while (resultSet.next()) {
                Medicine medicine = new Medicine(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getDouble("price"), resultSet.getDate("expirationDate").toLocalDate(), resultSet.getString("manufacturer"));

                medicines.add(medicine);
            }

            return medicines;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Medicine getMedicineById(int id) {
        Connection connection = null;

        try {
            connection = dbManager.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM medicines WHERE id=?");

            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            Medicine medicine = new Medicine();

            if (resultSet.next()) {
                medicine.setId(resultSet.getInt("id"));
                medicine.setName(resultSet.getString("name"));
                medicine.setPrice(resultSet.getDouble("price"));
                medicine.setExpirationDate(resultSet.getDate("expirationDate").toLocalDate());
                medicine.setManufacturer(resultSet.getString("manufacturer"));
            }

            return medicine;
        }

        catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean addMedicine(Medicine medicine) {
        Connection connection = null;
        try {
            connection = dbManager.getConnection();

            try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO medicines (name, price, expirationDate, manufacturer) VALUES(?,?,?,?)")) {

                preparedStatement.setString(1, medicine.getName());
                preparedStatement.setDouble(2, medicine.getPrice());
                preparedStatement.setDate(3, Date.valueOf(medicine.getExpirationDate()));
                preparedStatement.setString(4, medicine.getManufacturer());

                preparedStatement.execute();
            }
            return true;
        }

        catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean removeMedicineById(int id) {
        Connection connection = null;
        try {
            connection = dbManager.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("DELETE * FROM medicines WHERE id=?");

            preparedStatement.setInt(1, id);
            preparedStatement.execute();

            return true;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}

