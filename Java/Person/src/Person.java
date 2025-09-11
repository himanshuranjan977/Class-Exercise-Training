public class Person {
    String name;
    int age;
    String gender;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) throws InvalidAge {
        if (age < 18) {
            throw new InvalidAge("Age must be 18 or above.");
        }
        this.age = age;
    }

    public void setGender(String gender) throws InvalidGender {
        if (!gender.equalsIgnoreCase("Male") && !gender.equalsIgnoreCase("Female")) {
            throw new InvalidGender("Gender must be either 'Male' or 'Female'.");
        }
        this.gender = gender;
    }

    public void printDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Gender: " + gender);
    }
}
