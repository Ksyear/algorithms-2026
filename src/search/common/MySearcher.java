package search.common;

import java.util.Comparator;

public interface MySearcher<E> {
    int search(E[] list, E target);

    int search(E[] list, E target, Comparator<E> comparator);
}
