public abstract class Pet {
    private String name;
    // Percentage value from 0.0 to 1.0
    private double health;
    // Ranges from 1 to 10
    protected int painLevel;

    // Constructor
    public Pet(String name, double health, int painLevel) {
        this.name = name;
        if (health < 0) {
            this.health = 0.0;
        } else if (health > 1.0) {
            this.health = 1.0;
        } else {
            this.health = health;
        }
        if (painLevel < 1) {
            this.painLevel = 1;
        } else if (painLevel > 10) {
            this.painLevel = 10;
        } else {
            this.painLevel = painLevel;
        }
    }

    // Methods
    public abstract int treat();
    
    public void speak() {
        if (this.painLevel > 5) {
            System.out.println(("Hello! My name is " + this.getName()).toUpperCase());
        } else {
            System.out.println(("Hello! My name is " + this.getName()));
        }
    }

    // Problem set specifies there will not be pets of the same name.
    public boolean equals(Object o) {
        return this.name == ((Pet)o).getName();
    }

    // Doesn't specify that setter methods should be called here...
    protected void heal() {
        this.health = 1.0;
        this.painLevel = 1;
    }

    // Getters
    public String getName() {
        return this.name;
    }

    public double getHealth() {
        return this.health;
    }

    public int getPainLevel() {
        return this.painLevel;
    }

}