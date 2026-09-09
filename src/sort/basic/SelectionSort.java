package sort.basic;

import sort.MyList;
import sort.MySorter;

public class SelectionSort<E extends Comparable<E>> implements MySorter<E> {
    @Override
    public void sort(E[] list) {
        for (int last = list.length - 1; last > 0; last--) {
            // list[0...last] 중 가장 큰 수 list[k]를 찾는다.
            int largest = 0;
            for (int i = 1; i <= last; i++) {
//                if (list[i] > list[largest]) {
                if (list[i].compareTo(list[largest]) > 0) {
                    largest = i;
                }
            }

            int k = largest;
            MyList.swap(list, k, last);
        }
    }
}