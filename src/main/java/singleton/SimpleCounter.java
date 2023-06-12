package singleton;

class SimpleCounter {
    private static SimpleCounter INSTANCE = new SimpleCounter();
    private SimpleCounter() {

    }
    public static SimpleCounter getInstance() {
        if (INSTANCE == null) {
             INSTANCE = new SimpleCounter();
        }
        return INSTANCE;
    }
}
