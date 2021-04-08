import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        CountMap<Number> map = new CountMapIml<>();
        map.add(10D);
        map.add(10D);
        map.add(11D);
        map.add(12D);

        //System.out.println(map.printMap());
        HashMap newMap = new HashMap();
        map.toMap(newMap);

        System.out.println(newMap);
        map.addAll(map);
        System.out.println(map.toMap());
    }
}

