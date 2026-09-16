package sort;

import sort.basic.BubbleSort;
import sort.basic.InsertionSort;
import sort.basic.SelectionSort;
import sort.common.MyList;
import sort.common.MySorter;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class SortPerformanceTest {
    static final int SIZE = 50_000;

    static void main() {
        Integer[] list = getList();

        List<MySorter<Integer>> sorters = Arrays.asList(
                new SelectionSort<>(),
                new BubbleSort<>(),
                new InsertionSort<>()
        );

        for (MySorter<Integer> sorter : sorters) {
            Integer[] copyList = Arrays.copyOf(list, list.length);
            measureTime(sorter, copyList);
//            MyList.print(copyList, 10);
        }

    }

    private static Integer[] getList() {
        Random random = new Random();
        Integer[] list = new Integer[SIZE];

        for (int i = 0; i < SIZE; i++) {
            list[i] = random.nextInt(100_000);
        }
        return list;
    }

    private static <E> void measureTime(MySorter<E> sorter, E[] list) {
        long startTime = System.nanoTime();
        sorter.sort(list);
        long endTime = System.nanoTime();
        //System.out.println(sorter.getClass().getSimpleName() + " 실행 시간: " + ((endTime - startTime) / 1000_000.0) + " msec");
        System.out.printf("%20s 실행 시간: %10.2f msec\n", sorter.getClass().getSimpleName(), (endTime - startTime) / 1000_000.0);
    }
}
