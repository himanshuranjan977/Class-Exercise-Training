public class Human extends LivingBeing {
    public int age;

    public Human(String name, String color, int age) {
        super(name, color);  // call LivingBeing constructor
        this.age = age;
    }

    public void displayHumanInfo() {
        System.out.println("Human Info:");
        System.out.println("Name: " + name);
        System.out.println("Color: " + color);
        System.out.println("Age: " + age);
        System.out.println("Breath Count : " + getbreathCount());
    }
}
