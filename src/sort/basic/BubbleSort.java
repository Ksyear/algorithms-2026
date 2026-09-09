package sort.basic;

import sort.MyList;
import sort.MySorter;

public class BubbleSort<E extends Comparable<E>> implements MySorter<E> {
    @Override
    public void sort(E[] list) {
        for (int last = list.length - 1; last > 0; last--) {
            for (int i = 0; i < last; i++) {
                if (list[i].compareTo(list[i + 1]) > 0) {
                    MyList.swap(list, i, i+1);
                }
            }
        }
    }
}
