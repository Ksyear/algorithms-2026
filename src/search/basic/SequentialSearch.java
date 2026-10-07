package search.basic;

import search.common.MySearcher;

import java.util.Comparator;

public class SequentialSearch<E extends Comparable<E>> implements MySearcher<E> {
    @Override
    public int search(E[] list, E target) {
        return search(list, target, Comparable::compareTo);
    }

    @Override
    public int search(E[] list, E target, Comparator<E> comparator) {
        for (int i = 0; i < list.length; i++) {
            if (comparator.compare(list[i], target) == 0) {
                return i;
            }
        }
        return -1;
    }
}
