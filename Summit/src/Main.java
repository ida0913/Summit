public class Main {
    public static void main(String[] args) {
        Thread main = new Thread(new Runnable() {
            @Override
            public void run() {
                new Window("Summit", 100, 100);
            }
        });

        main.start();
    }
}
