package sort.basic;

import sort.common.MyList;
import sort.common.MySorter;

import java.util.Comparator;

import static sort.common.MyList.swap;

public class SelectionSort<E extends Comparable<E>> implements MySorter<E> {


    @Override
    public void sort(E[] list, Comparator<E> comparator) {
        for (int last = list.length - 1; last > 0; last--) {
            // list[0...last] 중 가장 큰 수 list[k]를 찾는다.
            int largest = 0;
            for (int i = 1; i <= last; i++) {
//                if (list[i] > list[largest]) {
                if (comparator.compare(list[i], list[largest]) > 0) {
//                    if (list[i].compareTo(list[largest]) > 0) {
                    largest = i;
                }
            }

            int k = largest;
            swap(list, k, last);
        }
    }
}