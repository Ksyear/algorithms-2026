package sort.common;

import java.util.Comparator;

public interface MySorter<E extends Comparable<E>> {
    default void sort(E[] list){
        sort(list, Comparable::compareTo);
    }

    void sort(E[] list, Comparator<E> comparator);
}
