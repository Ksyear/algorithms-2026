package search.basic;

import search.common.MySearcher;

import java.util.Comparator;

public class IterBinarySearch<E extends Comparable<E>> implements MySearcher<E> {
    @Override
    public int search(E[] list, E target) {
        int low = 0;
        int high = list.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int result = target.compareTo(list[mid]);
            if (result == 0) {
                return mid;
            } else if (result < 0) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
//            System.out.println("low = " + low + " high = " + high);
        }
        return -1;
    }

    @Override
    public int search(E[] list, E key, Comparator<E> comparator) {
        int low = 0;
        int high = list.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

//            int result = key.compareTo(list[mid]);
            int result = comparator.compare(key, list[mid]);

            if (result == 0) {
                return mid;
            } else if (result < 0) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}