
class Mammal extends Animal {
    int leg;

    public Mammal(String name, int size, type food, int leg) {
        super(name, size, food);
        this.leg = leg;
    }

    public int getLeg() {
        return this.leg;
    }

    public void setLeg(int leg) {
        this.leg = leg;
    }

    public void display() {
        System.out.println("=== MAMMAL ===");
        System.out.println("Name: " + getName());
        System.out.println("Size: " + getSize());
        System.out.println("Type: " + getFood());
        System.out.println("Number of Leg: " + getLeg());

    }
}
