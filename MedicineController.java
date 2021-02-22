package controllers;
import entities.Medicine;
import repositories.interfaces.IMedicineRepository;
import java.time.LocalDate;

public class MedicineController {
    private final IMedicineRepository medicineRepository;

    public MedicineController(IMedicineRepository medicineRepository) {
        this.medicineRepository = medicineRepository;
    }

    public String searchMedicineByName(String name) {

        return medicineRepository.searchMedicineByName(name).toString();
    }

    public String getMedicineById(int id) {

        return medicineRepository.getMedicineById(id).toString();
    }

    public String addMedicine(String name, double price, String manufacturer) {
        LocalDate expirationDate = LocalDate.now();
        boolean added = medicineRepository.addMedicine(new Medicine(name, price, expirationDate, manufacturer));

        if (added) {
            return "Drug is added";
        }
        else {
            return "Drug is not added, we apologize";
        }
    }

    public String removeMedicineById(int id) {
        boolean removed = medicineRepository.removeMedicineById(id);

        if (removed) {
            return "Drug was removed and not longer exists";
        }
        else {
            return "Drug exists";
        }
    }
}
