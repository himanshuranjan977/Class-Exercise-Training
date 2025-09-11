

public class EvenValue {
    public static void main(String[] args) {
        int[] num ={12,25,8,33,40,17,22,19,60,5};
        int i=0;
        System.out.println("Even number4s in array : ");
        while(i<num.length){
            if(num[i]%2==0){
                System.out.println(num[i]);
            }
            i++;
        }
    }

}
