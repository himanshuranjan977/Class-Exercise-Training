public class StringFour {
    public static void main(String[] args) {
        String name = " Maths ";
        System.out.println(name);// Maths
        System.out.println(name.trim());//Math

        String sport = "Cricket";
        char[] CharArray =sport.toCharArray();

        for(char  c: CharArray ){
            System.out.print(c + " "); // c r i c k e t
        }
    }

}
