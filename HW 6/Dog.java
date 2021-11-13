public class Dog extends Pet {
    private double droolRate;
    private static final double DEFAULT_DROOLRATE = .5;

    // Constructors
    public Dog(String name, double health, int painLevel) {
        super(name, health, painLevel);
        this.droolRate = DEFAULT_DROOLRATE;
    }

    public Dog(String name, double health, int painLevel, double droolRate) {
        super(name, health, painLevel);
        if (droolRate <= 0) {
            this.droolRate = .5;
        }
    }

    // Methods
    public int treat() {
        heal();
        if (droolRate < 3.5) {
            return (int)Math.floor((double)(getPainLevel() * 2) / getHealth());
        } else if (droolRate >= 3.5 && droolRate <= 7.5) {
            return (int)Math.floor((double)getPainLevel() / getHealth());
        } else {
            return (int)Math.floor((double)getPainLevel() / (getHealth() * 2));
        }
    }

    public void speak() {
        super.speak();
        String message = "";
        for (int i = 0; i < getPainLevel(); i++) {
            message = message.concat("bark ");
        }
        if (getPainLevel() > 5) {
            System.out.println(message.toUpperCase());
        } else {
            System.out.println(message);
        }
    }

    public boolean equals(Object o) {
        return (super.equals(o) && this.droolRate == ((Dog)o).getDroolRate());
    }

    public double getDroolRate() {
        return this.droolRate;
    }
}
