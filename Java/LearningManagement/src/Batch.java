public class Batch {
    public String code;
    public Course[] courses;
    public Trainer trainer;
    public Studentss[] students;

    public Batch(String code, Course[] courses, Trainer trainer, Studentss[] students) {
        this.code = code;
        this.courses = courses;
        this.trainer = trainer;
        this.students = students;
    }

    public void printDetails() {
        System.out.println("Batch Code: " + code);

        System.out.println("Courses:");
        for (Course course : courses) {
            System.out.println("- " + course.name + " (" + course.code + ")");
        }

        System.out.println("Trainer: " + trainer.name + " (" + trainer.empCode + ")");

        System.out.println("Students:");
        for (Studentss s : students) {
            System.out.println("- " + s.name + " (" + s.studentCode + ")");
    }
    }
}