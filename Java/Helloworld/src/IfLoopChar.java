public class IfLoopChar {
    public static void main(String[] args) {
        char animal ='A';
        char bird ='B';
        if(animal==bird){
            System.out.println("Animals and Bird are the same character");
        }
        else{
            System.out.println("ANimals come after the Bird in the ASCII table");
        }
        int ascii =(int) animal;
        System.out.println(ascii);
    }

}
