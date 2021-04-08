package com.dilitand.marriage;

public class Main {
    public static void main(String[] args) {
        //marriage();
        //tstAnswer();
        tstInteger();
    }
    public static void marriage()
    {
        Person person1 = new Person(true,"Dima");
        Person person2 = new Person(false,"Natalia");

        Person person3 = new Person(true,"Vasia");
        Person person4 = new Person(false, "Elena");

        System.out.println(person1.marry(person2));//женим первую пару
        System.out.println();
        System.out.println(person3.marry(person4));//женим вторую пару
        System.out.println();
        System.out.println(person1.marry(person4));//меняем супругов
        System.out.println();
        System.out.println(person1.marry(person3));//пытаемся поженить однополых (по идее false )
    }
    /*
    public static void tstAnswer()
    {
        //Проверяем что возвращают различные сложения
        Answers a = new Answers();
        a.plusResult();
    }
    public static void tstInteger(int... i)
    {
        //Проверяем изменение объекта по ссылке
        Answers a = new Answers();
        Integer x = 5;
        a.changeInteger(x);
        System.out.println(x);

        String s = "5";
        a.changeString(s);
        System.out.println(s);

        StringBuilder sb = new StringBuilder(s);
        a.changeStringBuilder(sb);
        System.out.println(sb);

        int[] ar = {1,2,3};
        a.changeArray(ar);
        System.out.println(ar[1]);

        System.out.println("Вывод: классы обертки и String не меняются по ссылке, по стрингам можно использовать StringBuilder");
    }
*/
}
