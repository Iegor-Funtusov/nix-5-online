package ua.com.alevel;

public class ExceptionMain {

    public static void main(String[] args) {
        ClassLoader thread = Thread.currentThread().getContextClassLoader();
        System.out.println("thread = " + thread.getName());
        System.out.println(Thread.currentThread().getName());
        SomeClass someClass = new SomeClass();
        someClass.test();
//        for (int i = 0; i < 10; i++) {
//            ExceptionThread exceptionThread = new ExceptionThread();
//            try {
//                exceptionThread.run();
//            } catch (Exception e) {
//                System.out.println("e = " + e.getMessage());
//            }
//        }
    }
}
