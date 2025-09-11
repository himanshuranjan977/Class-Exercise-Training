import java.util.Scanner;
public class SumOfMarks {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int s1 = sc.nextInt();
            int s2 = sc.nextInt();
            int s3 = sc.nextInt();
            int s4 = sc.nextInt();
            int s5 = sc.nextInt();
            int total = s1 + s2 + s3 + s4 + s5;
            System.out.println("Total Marks: " + total);
        }

    }

}
