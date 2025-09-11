public class Array1 {
    public static void main(String[] args) {
        int s1= 90;
        int s2 =95;
        int s3 = 85;
        // 4 + 4 + 4 =>12 bytes
        int total =s1+ s2+s3;
        System.out.println("Total : " +total);
        int[] scores ={90,95,85,85,78,89,96,56};
        //String[] subjects ={"English", "maths","science"};
        // 4*3 => 12 bytes
        //find the total using accumulation method
        int arrayTotal =0;
        for(int i=0;i<=7;i++){
            arrayTotal=arrayTotal+scores[i];

        }

        System.out.println("Total : " + arrayTotal);
    }

}
