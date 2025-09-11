public class Excercise {
    public static void main(String[] args) {
       int sub1=98;
       int sub2=60;
       int sub3=70;
        
       if(sub1<50 || sub2<50|| sub3<50){
        System.out.println("Fail");
       }
       else{
        int total = sub1+sub2+sub3;
        double average =total /3.0;
        System.out.println("Total Marks :" +total);
        System.out.println("Average : " + average);
       
        if(average>= 71){
            System.out.println("Distinction");
        }
        else if(average >= 51){
            System.out.println("1st Class");
        }
        else {
            System.out.println("Fail");
        }

       }
    }

}
