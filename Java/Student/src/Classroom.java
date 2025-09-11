public class Classroom {
    public static void main(String[] args) {
        int[] m1= {10,20,30,40};
        Stu s1= new Stu("Kumar",m1);
        System.out.println("S1 total : " +s1.getTotal());
        int[] m2 ={10,20,30,40,50,60};
        Stu s2 = new Stu("Raj", m2);
        System.out.println("S2 total : " +s2.getTotal());

        Stu s3 =new Stu("Himanshu", new int[]{1,2,3}, new String[] {"1234564567","1234567897"});
        System.out.println("S3 total : " +s3.getTotal());

        Stu s4 =new Stu("Ranjan", new int[]{1,2,3}, new String[] {"1234564567","1234567897","4561237894"});
        System.out.println("S4 total : " +s4.getTotal());


    }

}
