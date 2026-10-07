package search.basic;

import search.common.MySearcher;

import java.util.Comparator;

public class RecurBinarySearch<E extends Comparable<E>> implements MySearcher<E> {
    @Override
    public int search(E[] list, E target) {
        return binarySearch(list, 0, list.length - 1, target, Comparable::compareTo);
    }

    @Override
    public int search(E[] list, E target, Comparator<E> comparator) {
        return binarySearch(list, 0, list.length - 1, target, comparator);
    }

    private int binarySearch(E[] list, int low, int high, E target, Comparator<E> comparator) {
        if (low > high) {
            return - 1;
        }
        int mid = (low + high) / 2;
        int result = comparator.compare(target, list[mid]);
        if (result == 0) {
            return mid;
        } else if (result < 0) {
            return binarySearch(list, low, mid - 1, target, comparator);
        } else {
            return binarySearch(list, mid + 1, high, target, comparator);
        }
    }
}
