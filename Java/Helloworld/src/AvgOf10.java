public class AvgOf10 {
    public static void main(String[] args) {
        int[] marks ={85,56,45,86,98,75,48,56,96,82};
        int total =0;
        double avg;
        for (int i = 0; i < marks.length; i++) {
            total +=marks[i];
            
        }
        avg=total/10.0;
        System.out.println("Total Marks : " +total);
        System.out.println("Average Marks : " +avg);
    }

}
