import java.util.ArrayList;
import java.util.List;

public class Question {
    public static void main(String[] args) {
        List<A> list = new ArrayList<>();
        method1(list,new A());
        method1(list,new B());
        method1(list,new C());
        method2(list,new A());
        method2(list,new B());
        method2(list,new C());
        System.out.println(list);
    }

 public static <K> void method1(List<? super K> list, K k){
       list.add(k);
 }

 public static <K> void method2(List<K> list, K k){
        list.add(k);
    }

}
class A {

}
class B extends A{

}
class C extends A{

}