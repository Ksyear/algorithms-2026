package search;

import search.basic.IterBinarySearch;
import search.basic.RecurBinarySearch;
import search.basic.SequentialSearch;
import search.common.MySearcher;

public class SearchMain {
    static void main() {
        Integer[] list = new Integer[]{10, 12, 13, 14, 17, 20, 25, 27, 30, 35, 40, 45, 47};

//        MySearcher<Integer> searcher = new SequentialSearch<>();
        MySearcher<Integer> searcher = new IterBinarySearch<>();
//        MySearcher<Integer> searcher = new RecurBinarySearch<>();
        int index = searcher.search(list, 17);
        if (index >= 0) {
            System.out.println("17은 " + index + " 위치에 있습니다.");
        } else {
            System.out.println("17은 리스트에 없습니다.");
        }

        index = searcher.search(list, 19);
        if (index >= 0) {
            System.out.println("19은 " + index + " 위치에 있습니다.");
        } else {
            System.out.println("19은 리스트에 없습니다.");
        }

        index = searcher.search(
                list,
                20,
                (a, b) -> Integer.compare(a, b) // lambda
        );
        if (index >= 0) {
            System.out.println("20은 " + index + " 위치에 있습니다.");
        } else {
            System.out.println("20은 리스트에 없습니다.");
        }
    }
}
