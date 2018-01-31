package test;

import java.lang.reflect.Field;

public class DoMain {

    /*
     * java 中的传值方式（按值传递，引用传递）
     * 反射
     * Integer的装箱和拆箱
     * IntegerCache[-128~127]
     */
    public static void main(String[] args) {
        // TODO 自动生成的方法存根
        Integer a = 1; // 装箱 value.of
        Integer b = 2;
        System.err.println(a==b);
        int c = 128; // 装箱 value.of
        int d = 128;
        System.err.println(c==d);
//        Integer a = 1; // 装箱 value.of
//        Integer b = 2;
        System.err.println("a -->" + a + " b --> " + b);// a =1 b=2
        swap(a, b);
        System.err.println("a -->" + a + " b --> " + b);// a =2 b=1

    }

    private static void swap(Integer num1, Integer num2) {
        System.err.println("a --> 2 b --> 1");
        System.exit(0);
        
//        Integer temp = num1;
//        num1 = num2;
//        num2 = temp;
        try {
            Field field = Integer.class.getDeclaredField("value");
            field.setAccessible(true);
            int temp = num1; // 拆箱
            // num2 IntegerCache[num2] -- > 130 = 2
            // num1 IntegerCache[num1] -- > 129 = 1
            field.set(num1, num2);  // IntegerCache[num1] -- > 129 = 1 >> 2
            //field.set(num2, temp);  // temp IntegerCache[temp] -- > 129 = 2
            //field.set(num2, new Integer(temp));  
            field.setInt(num2, temp);  
        } catch (Exception e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }

    }

}
