public interface Vehicle {

    String getBrand();

    String speedUp();

    String slowDown();

    default boolean turnSignalOn() {
        return "Turning the vehicle alarm on.";
    }

    default boolean turnSignalOff() {
        return "Turning the vehicle alarm off.";


    }


}

