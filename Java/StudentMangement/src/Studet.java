public final  class Studet {

/*Create a new project called SchoolManagementBasic and create a class called "Student" with properties as name, age, and mark1, mark2, mark3. Use constructor overloading to create different constructors for initializing these properties.
All three marks must be private. Create setter and getter methods for each property. Make sure the mark is always between 0 and 100. If the mark is less than 0, set it to 0, and if it is greater than 100, set it to 100.
Student Class must have only public function, which is called PrintDetails -> this function must print the following details:
Name: [name]
Age: [age]
Mark1: [mark1]
Mark2: [mark2]
Mark3: [mark3]
Total: [Total]
Average: [Average]
Student class must have private function which can return the data after finding the total and average.
*/ 
    private String name;
    private int age;
    private int mark1;
    private int mark2;
    private int mark3;

    // --- Constructor Overloading ---

    // Constructor 1: No parameters
    public Studet(String string, String string2, int i, String string3) {
        this.name = "Unknown";
        this.age = 0;
        this.mark1 = 0;
        this.mark2 = 0;
        this.mark3 = 0;
    }
     // Constructor 2: Name and age only
    public Studet(String name, int age) {
        this.name = name;
        this.age = age;
        this.mark1 = 0;
        this.mark2 = 0;
        this.mark3 = 0;
    }

    // Constructor 3: Full initialization
    public Studet(String name, int age, int m1, int m2, int m3) {
        this.name = name;
        this.age = age;
        setMark1(m1);
        setMark2(m2);
        setMark3(m3);
    }

    // --- Setter methods (with validation for marks) ---

    public Studet() {
        
    }
    public void setName(String name) {
        this.name = name;
    }
      public void setAge(int age) {
        this.age = age;
    }

    public void setMark1(int mark1) {
        this.mark1 = validateMark(mark1);
    }

    public void setMark2(int mark2) {
        this.mark2 = validateMark(mark2);
    }

    public void setMark3(int mark3) {
        this.mark3 = validateMark(mark3);
    }

    // --- Getter methods ---

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getMark1() {
        return mark1;
    }

    public int getMark2() {
        return mark2;
    }

    public int getMark3() {
        return mark3;
    }

    // --- Private helper to validate marks ---
    private int validateMark(int mark) {
        if (mark < 0) return 0;
        if (mark > 100) return 100;
        return mark;
    }

    // --- Private method to calculate total ---
    private int getTotal() {
        return mark1 + mark2 + mark3;
    }

    // --- Private method to calculate average ---
    private double getAverage() {
        return getTotal() / 3.0;
    }

    // --- Public method to print student details ---
    public void printDetails() {
        System.out.println("----- Student Details -----");
        System.out.println("Name  : " + name);
        System.out.println("Age   : " + age);
        System.out.println("Mark1 : " + mark1);
        System.out.println("Mark2 : " + mark2);
        System.out.println("Mark3 : " + mark3);
        System.out.println("Total : " + getTotal());
        System.out.println("Average: " + getAverage());
        System.out.println("---------------------------");
    }
   public void displayInfo() {
        
        throw new UnsupportedOperationException("Unimplemented method 'displayInfo'");
    }






}
