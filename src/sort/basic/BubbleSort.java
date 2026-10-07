package sort.basic;

import sort.common.MyList;
import sort.common.MySorter;

import java.util.Comparator;

public class BubbleSort<E extends Comparable<E>> implements MySorter<E> {

    @Override
    public void sort(E[] list, Comparator<E> comparator) {
        for (int last = list.length - 1; last > 0; last--) {
            for (int i = 0; i < last; i++) {
                if (comparator.compare(list[i], list[i + 1]) > 0) {
//                if (list[i].compareTo(list[i + 1]) > 0) {
                    MyList.swap(list, i, i + 1);
                }
            }
        }
    }
}
