public class Array2 {

    public static void main(String[] args) {
        int[] scores ={90,95,85,85,78,89,96,56};
        int total =0;
        int counter =0;
        while (counter <scores.length){
            total +=scores[counter];
            counter++;
        }
        System.out.println("Total : " + total);

    }
}
