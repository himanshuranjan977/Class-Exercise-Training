public class Main {
    public static void main(String[] args) {
        Course[] courseList = {
            new Course("Java", "C001"),
            new Course("Python", "C002")
        };

        Trainer trainer = new Trainer("Mr. Sharma", 35, "T1001");

        Studentss[] students = {
            new Studentss("Himanshu", 22, "S001"),
            new Studentss("Ranjan", 21, "S002")
        };

        Batch batch = new Batch("B2025", courseList, trainer, students);

        batch.printDetails();
    }
}