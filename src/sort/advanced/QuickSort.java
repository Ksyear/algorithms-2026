package sort.advanced;

import sort.common.MyList;
import sort.common.MySorter;

import java.util.Comparator;

import static sort.common.MyList.swap;


public class QuickSort<E extends Comparable<E>> implements MySorter<E> {

    @Override
    public void sort(E[] list, Comparator<E> comparator) {
        quickSort(list, 0, list.length - 1, comparator);
    }

    private void quickSort(E[] list, int p, int r, Comparator<E> comparator) {
        if (p < r) {
            int q = partition(list, p, r, comparator);
            quickSort(list, p, q - 1, comparator);
            quickSort(list, q + 1, r, comparator);
        }

    }

    private int partition(E[] list, int p, int r, Comparator<E> comparator) {
        // pivot을 마지막으로 설정할 때
//        E pivot = list[r];
        // 개선 1: pivot을 렌덤값으로 설정할 때
        int k = (int) (Math.random() * (r - p + 1)) + p;
        swap(list, k, r);
        E pivot = list[r];

        int i = p - 1;

        for (int j = p; j <= r; j++) {
            int result = comparator.compare(list[j], pivot);
            if (result < 0) {
                swap(list, ++i, j);
            } else if (result == 0 && j % 2 == 1) { // 개선 2
                swap(list, ++i, j);
            }
        }

        swap(list, i + 1, r);
        return i + 1;
    }
}
