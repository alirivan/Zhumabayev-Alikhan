public interface Signal {
    default boolean turnSignalOn() {
        return "Turning the signal on.";
    }

    default boolean turnSignalOff() {
        return "Turning the signal off.";

    }


}
