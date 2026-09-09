package sort;

import sort.basic.BubbleSort;
import sort.basic.InsertionSort;

public class SortMain<E> {
    static void main() {

        Integer[] intList = {8, 31, 48, 73, 3, 65, 20, 29, 11, 15};
//        MySorter<Integer> intSorter = new SelectionSort<>();
//        MySorter<Integer> intSorter = new BubbleSort<>();
        MySorter<Integer> intSorter = new InsertionSort<>();
        intSorter.sort(intList);
        MyList.print(intList);

        Double[] doubleList = {8.0, 31.0, 48.0, 73.0, 3.0, 65.0, 20.0, 29.0, 11.0, 15.0};
//        MySorter<Double> doubleSorter = new SelectionSort<>();
//        MySorter<Double> doubleSorter = new BubbleSort<>();
        MySorter<Double> doubleSorter = new InsertionSort<>();
        doubleSorter.sort(doubleList);
        MyList.print(doubleList);

        String[] stringList = {"8", "31", "48", "73", "3", "65", "20", "29", "11", "15"};
//        MySorter<String> stringSorter = new SelectionSort<>();
//        MySorter<String> stringSorter = new BubbleSort<>();
        MySorter<String> stringSorter = new InsertionSort<>();
        stringSorter.sort(stringList);
        MyList.print(stringList);

    }
}
