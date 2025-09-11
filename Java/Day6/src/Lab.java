public class Lab {
    public static void main(String[] args) {
        Calcu c1= new Calcu();
        SuperCalcu sc1= new SuperCalcu();
        System.out.println(sc1.add(10,20));
        System.out.println(c1.add(10,5));
        System.out.println(c1.add(0,0,0));

    }

}
