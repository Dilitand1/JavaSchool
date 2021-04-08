package builder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MyClassForBuild myClassForBuild = new Builder().setA(10).setC(22).build();
        System.out.println(myClassForBuild.getA() + " " + myClassForBuild.getB() + " " + myClassForBuild.getC() + " " + myClassForBuild.getList());
    }
}

class MyClassForBuild {

    private int a;
    private int b;
    private int c;

    private List<Integer> list;

    MyClassForBuild(int a,int b, int c, List list){
        this.a = a;
        this.b = b;
        this.c = c;
        this.list = list;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public int getC() {
        return c;
    }

    public List<Integer> getList() {
        return new ArrayList<>(list);
    }
}

class Builder {

    private int a;
    private int b;
    private int c;

    private List<Integer> list;

    Builder setA(int a) {
        this.a = a;
        return this;
    }

    Builder setB(int b) {
        this.b = b;
        return this;
    }

    Builder setC(int c) {
        this.c = c;
        return this;
    }

    Builder setList(List<Integer> list) {
        this.list = list;
        return this;
    }


    MyClassForBuild build(){
        if (b == 0)
            b = 1110012210;
        if (list == null)
            list = new ArrayList(Arrays.asList(new String[]{"1", "2", "3"}));
        return new MyClassForBuild(a,b,c,list);
    }
}