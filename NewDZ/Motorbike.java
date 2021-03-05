public class Motorbike implements Vehicle, Signal {

    private String brand;

    public Motorbike(String škoda) {

    }



    @Override
    public String getBrand() {
        return brand;
    }

    @Override
    public String speedUp() {
        return "The car is speeding up.";
    }

    @Override
    public String slowDown() {
        return "The car is slowing down.";
    }

    @Override
    public boolean turnSignalOn() {
        // custom implementation
        return false;
    }

    @Override
    public boolean turnSignalOff() {
        // custom implementation
        return false;
    }

    @Override
    public String turnAlarmOn() {
        String s = new StringBuilder().append(Vehicle.super.turnSignalOn()).append(" ").append(Signal.super.turnSignalOn()).toString();
        return s;
    }

    @Override
    public String turnAlarmOff() {
        String s = new StringBuilder().append(Vehicle.super.turnSignalOff()).append(" ").append(Signal.super.turnSignalOff()).toString();
        return s;
    }
}
