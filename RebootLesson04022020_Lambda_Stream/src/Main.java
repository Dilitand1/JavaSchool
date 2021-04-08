import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.*;

public class Main {
    public static Integer i = 0;
    public static void main(String[] args) {

        Integer[] ints = Stream.iterate(1, x -> x < Integer.MAX_VALUE - i, x->{
                                            x = x + i;
                                            i = x - i;
                                            return x;})
                .toArray(x -> new Integer[x]);
        //.forEach(x-> System.out.println(x));

        System.out.println(Arrays.toString(ints));


    }
}
