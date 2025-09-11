public class Animal {
    public void makeSound() {
        System.out.println("Animal makes sound");
    }

    // Factory method
    public static Animal makeAnimal(String type) {
        if (type.equalsIgnoreCase("cat")) {
            return new Cat();
        } else if (type.equalsIgnoreCase("dog")) {
            return new Dog();
        } else if (type.equalsIgnoreCase("cow")) {
            return new Cow();
        } else {
            return null;
        }
    }
}
