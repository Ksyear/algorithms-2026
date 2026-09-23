package search.basic;

import search.common.MySearcher;

import java.util.Comparator;

public class RecurBinarySearch<E extends Comparable<E>> implements MySearcher<E> {
    @Override
    public int search(E[] list, E target) {
        return binarySearch(list, 0, list.length - 1, target);
    }

    private int binarySearch(E[] list, int low, int high, E target) {
        if (low > high) {
            return -1;
        }
        int mid = (low + high) / 2;
        int result = target.compareTo(list[mid]);
        if (result == 0) {
            return mid;
        } else if (result < 0) {
            return binarySearch(list, low, mid - 1, target);
        } else {
            return binarySearch(list, mid + 1, high, target);
        }
    }

    @Override
    public int search(E[] list, E key, Comparator<E> comparator) {
        return binarySearch(list, 0, list.length - 1, key, comparator);
    }

    private int binarySearch(E[] list, int low, int high, E key, Comparator<E> comparator) {
        if (low > high) {
            return -1;
        }
        int mid = (low + high) / 2;
        int result = key.compareTo(list[mid]);
        if (result == 0) {
            return mid;
        } else if (result < 0) {
            return binarySearch(list, low, mid - 1, key, comparator);
        } else {
            return binarySearch(list, mid + 1, high, key, comparator);
        }
    }

}
