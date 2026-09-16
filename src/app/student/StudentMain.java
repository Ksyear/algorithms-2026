package app.student;

import sort.basic.InsertionSort;
import sort.common.MyList;
import sort.common.MySorter;

public class StudentMain {
    // 본인 포함 이 클래스에 있는 학생 10명 리스트로 만들기
    static void main() {
        Student[] studentList= {
                new Student("양희찬", 24, 1, 4.1),
                new Student("김승연", 24, 2, 4.227),
                new Student("조성현", 24, 3, 3.7),
                new Student("김성수", 24, 5, 3.8),
                new Student("민승민", 24, 10, 3.5),
                new Student("김주형", 24, 4, 3.9),
                new Student("허준혁", 24, 7, 4.1),
                new Student("황민솔", 22, 8, 4.3),
                new Student("홍길동", 27, 9, 3.2),
                new Student("히바치", 21, 6, 2.0)
        };

        MySorter<Student> sorter = new InsertionSort<>();
        sorter.sort(studentList);
        MyList.println(studentList);
    }
}
