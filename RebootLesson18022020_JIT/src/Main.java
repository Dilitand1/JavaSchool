import java.util.HashMap;
import java.util.Map;

public class Main {
    static final Map<String,Integer> map;
    static{
        map = new HashMap<>();
        map.put("1",1);
        map.put("2",2);
        map.put("3",3);
        map.put("4",4);
        map.put("5",5);
        map.put("6",6);
        map.put("7",7);
    }
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10000000;i++){
            String s = "";
            for(Map.Entry<String,Integer> entry : map.entrySet()){
                s += entry.getKey() + entry.getValue();
                //для плагина забиваем память шнягой:
                Object o = new String(String.valueOf(Math.random()));
            }
            //System.out.println(s);
        }
    }

}
