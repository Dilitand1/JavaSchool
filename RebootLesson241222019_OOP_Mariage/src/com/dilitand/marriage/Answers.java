package com.dilitand.marriage;

import testPackage.*;

public class Answers extends TestClass {

    public void visibles(){
        protectedMethod();
        publicMethod();
        //defaultMethod();//дефолтный метод не видно из наследника только протектед
        //если создавать экземпляр TestClass то будет только публичные методы
    }

//Проверяем что возвращают разные виды сложения
    public void plusResult() {
        byte a = 1;
        byte b = 2;
        System.out.println("byte + byte returns " + isINt(a + b));
        System.out.println("char + char returns " + isINt((char)a + (char)b));
        System.out.println("short + short returns " + isINt((short)a + (short)b));
        System.out.println("int + long returns " + isINt((int)a + (long)b));
        System.out.println("double + float returns " + isINt((double)a + (float)b));
        System.out.println("long + float returns " + isINt((long)a + (float)b));
        System.out.println("int + double returns " + isINt((int)a + (double)b));
        System.out.println("Вывод - при сложении срабатывает автоматическое преобразование в наибольший по размерности оператор, но не ниже int");

        byte c = (byte) (a + b);

    }

    public String isINt(int x) {
        return "int";
    }

    public String isINt(long x) {
        return "long";
    }

    public String isINt(double x) {
        return "double";
    }

    public String isINt(float x) {
        return "float";
    }
    public String isINt(byte x) {
        return "byte";
    }
    public String isINt(char x) {
        return "char";
    }
    public String isINt(short x) {
        return "short";
    }

    void changeInteger(Integer x)
    {
        x++;
    }
    public void changeString(String s)
    {
        s = "a";
    }
    public void changeStringBuilder(StringBuilder s)
    {
        s.append("a");
    }
    public void changeArray(int[] ar)
    {
        ar[1] = 10;
    }
}
