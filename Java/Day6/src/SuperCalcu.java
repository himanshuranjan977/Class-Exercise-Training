public class SuperCalcu  extends Calcu{
    public int subtract(int a,int b){
        return a-b;
    }
    public int add(int a,int b){
        System.out.println("From Super calcu");
        return a+b;
    }
    public int add(int a,int b,int c,int d){
        return a+b+c+d;
    }

}
