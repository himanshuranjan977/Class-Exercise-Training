public class Assignment {
    int q1;
    int q2;
    int q3;
    String studentName;
    String examName;
    public Assignment(String studentName, String examName, int q1, int q2, int q3) {
        this.studentName = studentName;
        this.examName = examName;
        this.q1 = q1;
        this.q2 = q2;
        this.q3 = q3;
    }
    public int findTotal() {
        return q1 + q2 + q3;
    }
    public double findAverage() {
        return findTotal() / 3.0;
    }
    public String findGrade() {
        double avg = findAverage();
        if (avg <= 50) {
            return "Fail";
        } else if (avg <= 70) {
            return "Pass";
        } else {
            return "Distinction";
        }
    }
    public void printDetails() {
        System.out.println("----- Assignment Details -----");
        System.out.println("Student Name: " + studentName);
        System.out.println("Exam Name   : " + examName);
        System.out.println("Marks       : Q1=" + q1 + ", Q2=" + q2 + ", Q3=" + q3);
        System.out.println("Total Marks : " + findTotal());
        System.out.println("Average     : " + findAverage());
        System.out.println("Grade       : " + findGrade());
        System.out.println("--------------------------------");

    }
    
}
