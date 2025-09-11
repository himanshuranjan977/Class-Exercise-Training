public class SkipEvenIndex {
    public static void main(String[] args) {
        int[] num ={11,22,33,44,55,66,77,88,99,100};
        System.out.println("Values at odd index position : ");
        for(int i=0;i<num.length;i++){
            if(i%2 != 0){
                System.out.println("Index " + i +":" + num[i]);
            }
        }
    }

}
