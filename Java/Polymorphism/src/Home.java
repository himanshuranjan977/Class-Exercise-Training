public class Home {
    public static void main(String[] args) {
        Animal animal1 = Animal.makeAnimal("cat");
        if (animal1 != null) {
            animal1.makeSound(); // Meow!
        }

        Animal animal2 = Animal.makeAnimal("dog");
        if (animal2 != null) {
            animal2.makeSound(); // Woof!
        }

        Animal animal3 = Animal.makeAnimal("cow");
        if (animal3 != null) {
            animal3.makeSound(); // Moo!
        }

        Animal animal4 = Animal.makeAnimal("tiger");
        if (animal4 != null) {
            animal4.makeSound();
        } else {
            System.out.println("Unknown animal type.");
       }
    }
}