public class Anim extends LivingBeing {
    public String foodHabit;
    public int noOfLegs;

    public Anim(String name, String color, String foodHabit, int noOfLegs) {
        super(name, color);  // call LivingBeing constructor
        this.foodHabit = foodHabit;
        this.noOfLegs = noOfLegs;
    }
    

    public void displayAnimalInfo() {
        System.out.println("Animal Info:");
        System.out.println("Name: " + name);
        System.out.println("Color: " + color);
        System.out.println("Food Habit: " + foodHabit);
        System.out.println("No. of Legs: " + noOfLegs);
        System.out.println("Breath Count : " + getbreathCount());
    }
}