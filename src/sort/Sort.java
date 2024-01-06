package sort;

import java.util.ArrayList;
import java.util.List;

public class Sort {
    public static <T extends Comparable<T>> void sort(List<T> toSort) {
        int len = toSort.size();

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                T first = toSort.get(i);
                T second = toSort.get(j);

                if (first.compareTo(second) < 0) {
                    // swap them if the first item is greater than the second
                    toSort.set(i, second);
                    toSort.set(j, first);
                }
            }
        }
    }
}
