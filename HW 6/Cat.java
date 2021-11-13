public class Cat extends Pet {
    private int miceCaught;
    public static final int DEFAULT_MICECAUGHT = 0;

    // Constructors 
    public Cat(String name, double health, int painLevel) {
        super(name, health, painLevel);
        this.miceCaught = DEFAULT_MICECAUGHT;
    }

    public Cat(String name, double health, int painLevel, int miceCaught) {
        super(name, health, painLevel);
        this.miceCaught = miceCaught;
    }

    // Methods
    public int treat() {
        heal();
        if (miceCaught < 4) {
            return (int)Math.floor((double)(getPainLevel() * 2) / getHealth());
        } else if (miceCaught >= 4 && miceCaught <= 7) {
            return (int)Math.floor((double)getPainLevel() / getHealth());
        } else {
            return (int)Math.floor((double)getPainLevel() / (getHealth() * 2));
        }
    }

    public void speak() {
        super.speak();
        String message = "";
        for (int i = 0; i < miceCaught; i++) {
            message = message.concat("meow ");
        }
        if (getPainLevel() > 5) {
            System.out.println(message.toUpperCase());
        } else {
            System.out.println(message);
        }
    }

    public boolean equals(Object o) {
        return (super.equals(o) && this.miceCaught == ((Cat)o).getMiceCaught());
    }

    public int getMiceCaught() {
        return this.miceCaught;
    }
}
