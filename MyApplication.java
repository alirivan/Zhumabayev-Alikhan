import controllers.MedicineController;

import java.util.Scanner;

public class MyApplication {
    private final MedicineController medicineController;
    private final Scanner scanner;

    public MyApplication(MedicineController medicineController) {
        this.medicineController = medicineController;
        scanner = new Scanner(System.in);
    }

    public void begin() {
        while(true) {
            System.out.println("Choose an option:\n 1) Search for any medicine by name\n 2) Get the medicine by id\n 3) Add the medicine\n 4) Remove the medicine\n 0) Exit\n");
            int choice = scanner.nextInt();

            if (choice==1) {
                searchMedicineByNameMenu();
            }
            else if (choice==2) {
                searchMedicineByIdMenu();
            }
            else if (choice==3) {
                addMedicineMenu();
            }
            else if (choice==4) {
                removeMedicineByIdMenu();
            }
            else {
                break;
            }

            System.out.println("------------------");
        }
    }

    public void searchMedicineByNameMenu() {
        System.out.println("Name of the medicine");
        String name = scanner.next();
        String result = medicineController.searchMedicineByName(name);
        System.out.println(result);
    }

    public void searchMedicineByIdMenu() {
        System.out.println("ID of the medicine");
        int id = scanner.nextInt();
        String result = medicineController.getMedicineById(id);
        System.out.println(result);
    }

    public void addMedicineMenu() {
        System.out.println("Name of the medicine");
        String name = scanner.next();
        System.out.println("Price of the medicine");
        double price = scanner.nextDouble();
        System.out.println("Manufacturer of the medicine");
        String manufacturer = scanner.next();

        String result = medicineController.addMedicine(name, price, manufacturer);

        System.out.println(result);
    }

    public void removeMedicineByIdMenu() {
        System.out.println("Medicine ID to remove");
        int id = scanner.nextInt();

        String result = medicineController.removeMedicineById(id);

        System.out.println(result);
    }
}
