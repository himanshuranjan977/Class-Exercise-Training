public class ReverseArray {
    public static void main(String[] args) {
        int[] num = {5,52,40,63,21,54,78,2,32,10};
        System.out.println("Array in reverse order : ");
        for(int i=num.length -1;i>=0;i--){
            System.out.println(num[i]);
        }
    }

}
