import java.util.ArrayList;
import java.util.List;

public class Q2 {
    public static void main(String[] args) {
        List<Number> list = new ArrayList<>();
        method1(list);
        method2(list);

        System.out.println(list);
    }

    public static void method1(List<? super Number> list){
        list.add(new Integer(100));
        list.add(new Double(100));
        list.add(new Long(100));
    }

    public static void method2(List<Number> list){
        list.add(new Integer(100));
        list.add(new Double(100));
        list.add(new Long(100));
    }

}