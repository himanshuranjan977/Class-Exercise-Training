public class GreetMain {
    public static void main(String[] args) {
        PrintGreet helloThread = new PrintGreet("Hello", 10);
        PrintGreet haiThread = new PrintGreet("Hai", 5);

        helloThread.setName("Thread-Hello");
        haiThread.setName("Thread-Hai");

        helloThread.start();
        haiThread.start();

    }

}
