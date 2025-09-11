public class Batch {
    public String name;
    public Stude subject;          // ✅ Use Stude type
    public Trainer trainer;

    public Batch(String name, Stude subject, Trainer trainer) {
        this.name = name;
        this.subject = subject;
        this.trainer = trainer;
    }

    public static void main(String[] args) {
        Stude s1 = new Stude("Java");
        Trainer t1 = new Trainer("Mr. Sharma");

        Batch b1 = new Batch("Batch A", s1, t1);

        System.out.println("Batch Name: " + b1.name);
        System.out.println("Subject: " + b1.subject.name);     // ✅ Fixed
        System.out.println("Trainer: " + b1.trainer.name);
    }
}