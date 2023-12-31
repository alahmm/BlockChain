package facade;

class ComputerFacadeTestDrive {
    public static void main(String[] args) {
        Processor processor = new Processor();
        Monitor monitor = new Monitor();
        Keyboard keyboard = new Keyboard();

        ComputerFacade computerFacade = new ComputerFacade(processor, monitor, keyboard);/* Write your code here */

        computerFacade.turnOnComputer();
        computerFacade.turnOffComputer();
    }
}

class ComputerFacade {
    private Processor processor;
    private Monitor monitor;
    private Keyboard keyboard;


    public ComputerFacade(Processor processor, Monitor monitor, Keyboard keyboard) {
        this.processor = processor;
        this.monitor = monitor;
        this.keyboard = keyboard;
    }

    public void turnOnComputer() {
        processor.on();
        monitor.on();
        keyboard.on();

    }

    public void turnOffComputer() {
        keyboard.off();
        monitor.off();
        processor.off();
    }
}

class Processor {
    private String description;

    Processor() {
        description = "Processor";
    }

    public void on() {
        System.out.println(description + " on");
    }

    public void off() {
        System.out.println(description + " off");
    }
}

class Monitor {
    private String description;

    Monitor() {
        description = "Monitor";
    }

    public void on() {
        System.out.println(description + " on");
    }

    public void off() {
        System.out.println(description + " off");
    }
}

class Keyboard {
    private String description;
    Keyboard() {
        description = "Keyboard";
    }

    public void on() {
        System.out.println(description + " on");
        turnOnBacklight();
    }

    public void off() {
        System.out.println(description + " off");
        turnOffBacklight();
    }

    private void turnOnBacklight() {
        System.out.println("Backlight is turned on");
    }

    private void turnOffBacklight() {
        System.out.println("Backlight is turned off");
    }
}