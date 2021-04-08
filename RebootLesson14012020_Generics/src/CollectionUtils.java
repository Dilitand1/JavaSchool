import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CollectionUtils {
    public static <T> void addAll(List<? extends T> source, List<? super T> destination) {
        destination.addAll(source);
    }

    public static <T> List newArrayList(List<T> list) {
        return new ArrayList(list);
    }

    public static <T> int indexOf(List<? super T> source, T o) {
        for (int i = 0; i < source.size(); i++) {
            if (source.get(i).equals(o)) {
                return i;
            }
        }
        return -1;
    }

    public static <T> List limit(List<? super T> source, int size) {
        List dest = source.subList(0,size);
        return dest;
    }

    public static <T> void add(List<? super T> source, T o) {
        source.add(o);
    }

    public static <T> void removeAll(List<? super T> removeFrom, List<? extends T> c2) {
        for(T t: c2){
            removeFrom.remove(t);
        }
    }

    public static <T> boolean containsAll(List<T> c1, List<T> c2) {
        return c1.containsAll(c2);
    }

    public static <T> boolean containsAny(List<T> c1, List<T> c2) {
        if (!c1.isEmpty() && !c2.isEmpty()) {
            for (T t : c1) {
                if(c2.contains(t)){
                    return true;
                }
            }
        }
        return false;
    }

    public static <T extends Comparable<T>> List range(List<T> list, T min, T max) {
        List<T> dest = list.subList(0,0);//Создаем пустой список
        for (T t : list){
            if (t.compareTo(min) >= 0 && t.compareTo(max) <= 0){
                dest.add(t);
            }
        }
        return dest;
    }

    public static <T> List range(List<T> list, T min, T max, Comparator<Object> comparator) {
        List<T> dest = list.subList(0,0);//Создаем пустой список
        for(T t : list){
            if(comparator.compare(t,min) >= 0 && comparator.compare(t,max) <= 0){
                dest.add(t);
            }
        }
        return dest;
    }
}
