import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class a = A.class.getClassLoader().loadClass("A");
        Class b = B.class.getClassLoader().loadClass("B");

        //Это всегда true:
        System.out.println(a.getClassLoader() == b.getClassLoader());

        //Почему это работает?
        Class c = a.getClassLoader().loadClass("B");
        Method m = c.getDeclaredMethod("metod");
        m.invoke(new B());
    }
}

class A {
    void metod(){
        System.out.println("a");
    }
}
class B {
    void metod(){
        System.out.println("b");
    }
}
