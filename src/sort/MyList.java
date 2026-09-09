package sort;

public class MyList {
    public static <E> void print(E[] list) {
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i] + " ");
        }
        System.out.println();
    }

    public static <E> void swap(E[] list, int i, int j) {
        // list[i]와 list[j]를 교환한다
        E tmp = list[i];
        list[i] = list[j];
        list[j] = tmp;
    }
}
