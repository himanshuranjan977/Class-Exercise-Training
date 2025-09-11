public class EcoSystem {
    public static void main(String[] args) {
        Anim lion = new Anim("Lion", "Golden", "Carnivore", 4);
        Human human = new Human("Himanshu Ranjan", "Brown", 22);
        //System.out.println("Breaths per minite: " + human.getbreathCount());

        lion.displayAnimalInfo();
        System.out.println("---------------------------------------------");
        human.displayHumanInfo();
    }
}
