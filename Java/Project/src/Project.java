public class Project {
    public String code;
    public Skill[] skills;
    public Employee[] employees;
    public Employee manager;

    public Project(String code, Skill[] skills, Employee[] employees, Employee manager) {
        this.code = code;
        this.skills = skills;
        this.employees = employees;
        this.manager = manager;
    }

    public void printDetails() {
        System.out.println("Project Code: " + code);
        System.out.println("Skills Required:");
        for (Skill skill : skills) {
            System.out.println("- " + skill.name);
        }

        System.out.println("Assigned Employees:");
        for (Employee emp : employees) {
            System.out.println("Name: " + emp.name + ", ID: " + emp.empNumber + ", Gender: " + emp.gender);
        }

        System.out.println("Project Manager: " + manager.name + ", ID: " + manager.empNumber + ", Gender: " + manager.gender);
    }

    public static void main(String[] args) {
        Skill[] skills = {
            new Skill("Java"),
            new Skill("SQL"),
            new Skill("React")
        };

        Employee e1 = new Employee("Himanshu", 101, "Male");
        Employee e2 = new Employee("Priya", 102, "Female");
        Employee manager = new Employee("Mr. Sharma", 100, "Male");

        Employee[] team = {e1, e2};

        Project project = new Project("PRJ001", skills, team, manager);
        project.printDetails();
    }
}
