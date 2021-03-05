import java.lang.reflect.Method;
import java.lang.reflect.Field;
import java.lang.reflect.Constructor;


public class Main {
    static int product(int a, int b)
    {
        return a * b;
    }
    static int summa(int a, int b)
    {
        return a + b;
    }

    public static void main(String[] args) {
        Vehicle car = new Motorbike("Škoda");
        System.out.println(car.getBrand());
        System.out.println(car.speedUp());
        System.out.println(car.slowDown());
        System.out.println(car.turnSignalOn());
        System.out.println(car.turnSignalOff());

        int p = product(15, 100);
        int s = summa(59, 945);

        // print product
        System.out.println("Sum of Product " + p);

        // print sum
        System.out.println("Sum of Summa: " + s);
    }


}
