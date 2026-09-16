package app.student;

// 이름, 나이, 번호, 평점을 관리하는 클래스
public record Student(
        String name,
        int age,
        int number,
        double gpa
) implements Comparable<Student> {
    @Override
    public int compareTo(Student o) {
        if (this.age == o.age) {
            return Integer.compare(this.number, o.number);
        } else {
            return Integer.compare(this.age, o.age);
        }
    }
}
