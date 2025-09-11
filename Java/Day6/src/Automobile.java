public class Automobile {

    public String type;
    //private int wheelCount;
    public int wheelCount;

    public Automobile(String type, int wheelCount) {
        this.type = type;
        this.wheelCount = wheelCount;
    }

    /*private void moveForward() {
        System.out.println("Moving Forward >>>>>>>>>");
    }*/
    public void moveForward() {
        System.out.println("Moving Forward >>>>>>>>>");
    }

    public void moveBackward() {
        System.out.println("Moving Backward <<<<<<<<<");
    }

    public void start() {
        System.out.println("Engine Starts");
    }
}
