package genericmethods;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
public class Main {
    public static void main(String[] args) {
        Integer[] array = {1, 2, 3};
        Arrays.stream(ArrayUtils.invert(array)).toList().forEach(System.out::print);
    }
}
// do not remove imports


/*
class ArrayUtils {
    public static <E> Boolean hasNull(E[] array) {
        boolean isnull = false;
        for (E element : array
             ) {
            if (element == null) {
                isnull = true;
            }
        }
        return isnull;
    }
}*/
/*
class ArrayUtils {
    public static <T> T getFirst(T[] array) {
        if (array.length == 0) {
            return null;
        }
        return array[0];
    }
}*/
/*class ArrayUtils {
    public static <T> String info(T[] array) {
        List<T> list = new ArrayList<>(Arrays.asList(array));
        return list.toString();
    }
}*/
class ArrayUtils {
    public static <T> T[] invert(T[] array) {
        T temp;
        for (int i = 0; i < array.length / 2; i++) {
            temp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = temp;
        }
        return array;
    }
}