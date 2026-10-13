interface Notifier {
    void send(String message);
}

interface Urgent {

}

class UrgentNotifier implements Notifier, Urgent {
    private Notifier notifier;

    UrgentNotifier(Notifier notifier) {
        this.notifier = notifier;
    }

    public void send(String message) {
        notifier.send(message);
    }
}

class NotificationDemo {
    public static void main(String[] args) {

        Notifier email = message -> {
            System.out.println("Email :" + message);
        };
        Notifier sms = message -> {
            System.out.println("SMS :" + message);
        };
        Notifier[] notifiers = {
                email,
                sms
        };
        for (Notifier notify : notifiers) {
            notify.send("Hello");
        }

        Notifier urgentsms = new UrgentNotifier(sms);
        Notifier[] urgent = {
                email,
                urgentsms
        };
        for (Notifier notify : urgent) {
            notify.send("Hello");
            if (notify instanceof Urgent) {
                notify.send("Hello");
            }
        }
    }

}
