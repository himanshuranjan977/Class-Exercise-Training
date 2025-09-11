public class Planet {
    private  String name;
    private Double diameter;
    private double distance;
    public void setName(String name){
        this.name=name;
    }
    public void setDiameter(double diameter){
        this.diameter=diameter;
    }
    public void setDistance(double distance){
        this.distance=distance;
    }
    public String getName(){
        return name;
    }
    public double getDiameter(){
        return diameter;
    }
    public double getDistance(){
        return distance;
    }
    public void printDetails() {
        System.out.println("----- Planet Details -----");
        System.out.println("Name      : " + name);
        System.out.println("Diameter  : " + diameter + " km");
        System.out.println("Distance  : " + distance + " million km from Sun");
        System.out.println("--------------------------");
    }



}
