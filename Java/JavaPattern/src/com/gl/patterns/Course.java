package src.com.gl.patterns;

public class Course {

    @SuppressWarnings("FieldMayBeFinal")
    private  String name;
    @SuppressWarnings("FieldMayBeFinal")
    private  String trainer;
    @SuppressWarnings("FieldMayBeFinal")
    private  int fee;
    @SuppressWarnings("FieldMayBeFinal")
    private  int duration;

    public void display(){
        System.out.println(name + " - " +trainer+ " - " + fee +" - " + duration);

    }

    public Course(CourseBuilder builder){
        this.name=builder.name;
        this.trainer=builder.trainer;
        this.fee=builder.fee;
        this.duration=builder.duration;
    }
    public static class CourseBuilder{
        public String name;
        public String trainer;
        public int fee;
        public int duration;

        public CourseBuilder setName(String name){
            this.name=name;
            return  this;
        }
        public CourseBuilder setTrainer(String  trainer){
            this.trainer=trainer;
            return this;
        }


        public CourseBuilder setFee(int fee){
            this.fee=fee;
            return this;
        }
        public CourseBuilder setDuration(int duration){
            this.duration=duration;
            return this;
        }
        public Course build(){
            return new Course(this);
        }
        
        


    }
   
}
