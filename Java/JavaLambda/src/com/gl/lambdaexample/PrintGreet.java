public class PrintGreet extends Thread{
    @SuppressWarnings("FieldMayBeFinal")
    private String message;
    @SuppressWarnings("FieldMayBeFinal")
    private int count;

    public PrintGreet(String message, int count) {
        this.message = message;
        this.count = count;
    }

    @Override
    public void run() {
        for (int i = 1; i <= count; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + message + " (" + i + ")");
        }
    }


}
