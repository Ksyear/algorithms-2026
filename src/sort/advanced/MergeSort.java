package sort.advanced;

import sort.common.MySorter;

public class MergeSort<E extends Comparable<E>> implements MySorter<E> {
    @Override
    public void sort(E[] list) {
        mergeSort(list, 0, list.length - 1);
    }

    private void mergeSort(E[] list, int p, int r) {
        if (p < r) {
            int q = (p + r) / 2;
            mergeSort(list, p, q);
            mergeSort(list, q + 1, r);
            merge(list, p, q, r);
        }
    }

    private void merge(E[] list, int p, int q, int r) {
        int i = p;
        int j = q + 1;
        int t = 0;
        
        E[] tmp = (E[]) new Comparable[r - p + 1];

        while (i <= q && j <= r) {
            if (list[i].compareTo(list[j]) >= 0) {
                tmp[t++] = list[j++];
            } else {
                tmp[t++] = list[i++];
            }
        }

        while (i <= q) {
            tmp[t++] = list[i++];
        }
        while (j <= r) {
            tmp[t++] = list[j++];
        }

        i = p;
        t = 0;
        while (i <= r) {
            list[i++] = tmp[t++];
        }
    }
}
