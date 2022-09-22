public class Main {
    public static void main(String[] args) {
        System.out.println("===== Kelompok 4 - OOP 01 ====");
        System.out.println("Albertus Timothy Gunawan");
        System.out.println("Fatima Khairunnisa");
        System.out.println("Najwa Fathiadisa");
        System.out.println("Stefan Gusto Hutapea\n\n");
        Mammal cat = new Mammal("cat", 2, Animal.type.Carnivore, 4);
        Aves chicken = new Aves("Chicken", 2, Animal.type.Omnivore, false);
        cat.display();
        System.out.printf("\n");
        chicken.display();
    }
}
