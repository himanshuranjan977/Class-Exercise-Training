public class Stu {
    public String name;
    //array attribute
    public int[] marks;

    //mobile numbers - 2 - fixed 
    public String[] mobileNumbes = new String [2];


    public Stu(String name ,int[] marks){
        this.name=name;
        this.marks=marks;
    }
    public Stu(String name,int[] marks,String[] mobileNumbers){
        this.name=name;
        this.marks=marks;
        this.mobileNumbes=mobileNumbers;
    }
    public int getTotal(){
        int total=0;
        for(int temp : marks){
            total += temp;

        }
        return total;
    }
    

}
