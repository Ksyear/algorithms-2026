package sort.basic;

import sort.common.MySorter;

public class InsertionSort<E extends Comparable<E>> implements MySorter<E> {
    @Override
    public void sort(E[] list) {
        for (int i = 1; i <= list.length - 1; i++) {
            // list[0...i]의 적합한 자리에 list[i]를 삽입한다.
            E newItem = list[i];
            int j = i - 1;
            for (; j >= 0 && newItem.compareTo(list[j]) < 0; j--) {
                list[j + 1] = list[j];
            }
            list[j + 1] = newItem;
        }

    }
}
