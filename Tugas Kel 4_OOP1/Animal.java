class Animal {
    String name;
    int size;

    enum type {
        Herbivore,
        Carnivore,
        Omnivore
    }
    type food;

    public Animal(String name, int size, type food) {
        this.name = name;
        this.size = size;
        this.food = food;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return this.size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public type getFood() {
        return food;
    }

    public void setFood(type food) {
        this.food= food;
    }
}
