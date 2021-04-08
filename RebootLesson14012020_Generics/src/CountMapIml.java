import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

class CountMapIml<T extends Number> implements CountMap<T> {

    private Map<Integer, T> map;
    Integer counter;


    CountMapIml() {
        counter = 0;
        this.map = new HashMap<>();
    }

    @Override
    public void add(T o) {
        if (!map.containsKey(o)) {
            map.put(counter, o);
            counter++;
        }
    }

    @Override
    public int getCount(T o) {
        int countAdd = 0;
        Iterator<Map.Entry<Integer, T>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, T> entry = iterator.next();
            if (o.equals(entry.getValue())) {
                countAdd++;
            }
        }
        return countAdd;
    }

    @Override
    public int remove(T o) {
        int countDel = 0;
        Iterator<Map.Entry<Integer, T>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, T> entry = iterator.next();
            if (o.equals(entry.getValue())) {
                countDel++;
                iterator.remove();
            }
        }
        return countDel;
    }

    @Override
    public int size() {
        return map.size();
    }

    public static < T extends Number > T middler(T arg1, T arg2) {

        if (arg1 == null || arg2 == null) {
            return null;
        }
        if (arg1 instanceof Double) {
            return (T) new Double(arg1.doubleValue() + (arg2.doubleValue()));
        } else if (arg1 instanceof Integer) {
            return (T) new Integer((arg1.intValue() + (arg2.intValue())));
        } else {
            throw new IllegalArgumentException("Type " + arg1.getClass() + " is not supported by this method");
        }
    }


    @Override
    public void addAll(CountMap<T> source) {
        Iterator<Map.Entry<Integer,T>> iterator = source.toMap().entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, T> entry = iterator.next();
            if (this.map.containsKey(entry.getKey())) {
                T res = middler(entry.getValue(),map.get(entry.getKey()));
                this.map.put(entry.getKey(), res);
            } else {
                this.add(entry.getValue());
            }
        }
    }

    @Override
    public Map toMap() {
        return this.map;
    }

    @Override
    public void toMap(Map destination) {
        Iterator<Map.Entry<Integer, T>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, T> entry = iterator.next();
            if (destination.containsKey(entry.getKey())) {
                T res = middler(entry.getValue(),map.get(entry.getKey()));
                destination.put(entry.getKey(), res);

            } else {
                destination.put(entry.getKey(), entry.getValue());
            }
        }
    }
}