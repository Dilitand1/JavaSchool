import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class CashClass implements Serializable {
    Map<String,Integer> cashMap = new HashMap<>();

    public Map<String, Integer> getCashMap() {
        return cashMap;
    }

    public void setCashMap(Map<String, Integer> cashMap) {
        this.cashMap = cashMap;
    }
}
