import controllers.MedicineController;
import data.interfaces.IDBManager;
import repositories.MedicineRepository;
import repositories.interfaces.IMedicineRepository;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        IDBManager dbManager = new IDBManager() {
            @Override
            public Connection getConnection() {
                return null;
            }
        };
        IMedicineRepository medicineRepository = new MedicineRepository(dbManager);
        MedicineController medicineController = new MedicineController(medicineRepository);
        MyApplication myApplication = new MyApplication(medicineController);
        myApplication.begin();
    }
}
