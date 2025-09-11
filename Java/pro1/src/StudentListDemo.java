

import java.util.LinkedList;

public class StudentListDemo {
    public static void main(String[] args) {
        LinkedList<Student> students =new LinkedList<>();
        
        students.add(new Student("Himanshu Ranjan", 20, "Male", new int[]{80,90,85,70,79}));
        students.add(new Student("Ranjan", 20, "Male", new int[]{88,90,85,70,79}));
        students.add(new Student("Himanshu Kumar", 20, "Male", new int[]{80,65,85,70,79}));
        students.add(new Student("Rajan", 20, "Male", new int[]{88,90,45,70,79}));


        System.out.println("Students Information : ");
        for(int i=0;i<students.size();i++){
            students.get(i).printInfo();
        }
    }

}
