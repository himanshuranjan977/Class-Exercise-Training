public class Square<T extends Number> {
    private T side;
    void setSide(T side){
        this.side =side;
    }
    @SuppressWarnings("unused")
    T getSide(){
        return this.side;
    }

    public double findArea(){
        double mySide =side.doubleValue();
        /*System.out.println("Area of the Square is " + (mySide*mySide));*/
        return mySide*mySide;
    }

}
