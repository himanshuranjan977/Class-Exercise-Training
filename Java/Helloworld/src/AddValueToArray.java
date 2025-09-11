

public class AddValueToArray {

    public static void main(String[] args) {
        int[] num={10,20,30,40,50};
        int i=0;
        while(i<num.length){
            num[i]=num[i]+5;
            i++;
        }
        System.out.println("Update the array after adding 5 to each value : ");
        for(int j=0;j<num.length;j++){
            System.out.println(num[j]);
        }
    }
}
