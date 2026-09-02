package algorithmdesign;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// 성능 측정(Performance Measurement)
public class PerformanceTest {
    public static void main(String[] args){
//        List<String> list = new ArrayList<>();
        List<String> list = new LinkedList<>();

        long startTime;
        long endTime;

        startTime = System.nanoTime();

        for(int i = 0; i < 100000; i++){
            list.add(0, String.valueOf(i));
        }

        // 배열 리스트시 n^2 비례
        // 연결 리스트시 n 비례

        endTime = System.nanoTime();

        System.out.println("알고리즘 수행 시간: " + (endTime - startTime)/1000_000.0 + "ms");

    }
}
