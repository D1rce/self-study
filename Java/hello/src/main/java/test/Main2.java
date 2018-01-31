package test;

public class Main2 {

    /*
     * 
     */
    public static void main(String[] args) {
        
        System.err.println(testClosure().get());
        
        
    }

//    public static Supplier<Integer> testClosure() {
//
//        final int i = 1;
//
//        return new Supplier<Integer>() {
//
//            @Override
//            public Integer get() {
//
//                return i;
//
//            }
//
//        };
//
//    }
    public static Supplier<Integer> testClosure() {

        int i = 1;

        return () -> {

            return i;

        };

    }
    
}
