class Aves extends Animal {
    boolean fly;

    public Aves(String name, int size, type food, boolean fly) {
        super(name, size, food);
        fly = fly;
    }

    public boolean getFly() {
        return fly;
    }

    public void setFly(boolean fly) {
        this.fly = fly;
    }

    public void display() {
        System.out.println("=== AVES ===");
        System.out.println("Name: " + getName());
        System.out.println("Size: " + getSize());
        System.out.println("Type: " + getFood());
        System.out.println("Fly: " + getFly());
    }
}
