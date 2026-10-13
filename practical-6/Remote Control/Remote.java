interface Switchables {
    void on();
    void off();
    boolean isOn();
    default void toogle() {
        if(isOn()) {
            off();
        }
        else {
            on();
        }
    }
}
class Fan implements Switchables {
    private boolean isOn = false;

    public void on() {
        isOn = true;
        System.out.println("Fan is ON");
    }
    public void off() {
        isOn = false;
        System.out.println("Fan is OFF");
    }
    public boolean isOn() {
        return isOn;
    }
}
class Light implements Switchables {
    private boolean isOn = false;

    public void on() {
        isOn = true;
        System.out.println("Light is ON");
    }
    public void off() {
        isOn = false;
        System.out.println("Light is OFF");
    }
    public boolean isOn() {
        return isOn;
    }
}
class Remote {
    public static void main(String[] args) {
        Switchables[] devices = {
            new Fan(),
            new Light()
        };

        for(Switchables device : devices) {
            device.on();
            device.off();
            System.out.println("1st Toogle");
            device.toogle();
            System.out.println("2ns Toogle");
            device.toogle();
        }
    }
}