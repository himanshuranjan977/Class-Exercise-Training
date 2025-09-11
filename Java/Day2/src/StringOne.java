



public class StringOne {

    public static void main(String[] args) {
        //index number from 0
        String subject ="American English";
        System.out.println(subject);//English
        System.out.println(subject.charAt(1));// n
        System.out.println(subject.charAt(2));// g

        System.out.println("Length : "+ subject.length());

        //Find a char in this String
        
        System.out.println(subject.indexOf('c'));
        System.out.println(subject.indexOf('z'));
        System.out.println(subject.indexOf('a'));

        //print the string
        System.out.println(subject.substring(1, 8));

        // American English
        System.out.println(subject.contains("lish"));

        System.out.println(subject.toLowerCase());
        System.out.println(subject.toUpperCase());

        String newword = subject.replace("English", "Spanish");
        System.out.println(newword);
       

    }
}
