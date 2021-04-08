package adapter;

public class Main {
    public static void main(String[] args) {
        Man man = new Man();
        Woman woman = new Woman();
        WrapWoman wrapWoman = new WrapWoman(woman);

        System.out.println(man.logic());
        System.out.println(wrapWoman.logic());

    }
}

class Woman {
    String womanLogic() {
        return "Женская логика";
    }
}

class Man {
    String logic() {
        return "Логика";
    }
}

class WrapWoman extends Man {
    private Woman woman;

    WrapWoman(Woman woman) {
        this.woman = woman;
    }

    @Override
    String logic() {
        return woman.womanLogic();
    }
}