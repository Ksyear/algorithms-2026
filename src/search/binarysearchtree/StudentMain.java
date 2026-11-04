package search.binarysearchtree;

import java.util.List;

public class StudentMain {
    static void main(){
        BinarySearchTree<String, Student> bst = new BinarySearchTree<>();
        List<Student> studentList = List.of(
                new Student("홍길동", 24, 20220101, 4.1),
                new Student("김성수", 24, 20220109, 3.7),
                new Student("김승연", 24, 20221010, 4.2),
                new Student("민승민", 24, 20220231, 3.3),
                new Student("조성현", 24, 20220293, 3.2)
        );

        bst.insert(studentList.get(0).name(), studentList.get(0));
        bst.insert(studentList.get(1).name(), studentList.get(1));
        bst.insert(studentList.get(2).name(), studentList.get(2));
        bst.insert(studentList.get(3).name(), studentList.get(3));
        bst.inorder();

        TreeNode<String, Student> findNode = bst.search("김길동");
        if (findNode == null) {
            System.out.println("값을 찾을 수 없습니다.");
        } else {
            System.out.println(findNode.value);
        }
        BinarySearchTree<Integer, Student> bstAge = new BinarySearchTree<>();
        bstAge.insert(studentList.get(0).age(),studentList.get(0));
        bstAge.insert(studentList.get(1).age(),studentList.get(1));
        bstAge.insert(studentList.get(2).age(),studentList.get(2));
        bstAge.insert(studentList.get(3).age(),studentList.get(3));
        bstAge.insert(studentList.get(4).age(),studentList.get(4));
        bstAge.insert(studentList.get(5).age(),studentList.get(5));

        TreeNode<Integer, Student> findNode2 = bstAge.search(31);
        if (findNode == null) {
            System.out.println("값을 찾을 수 없습니다.");
        } else {
            System.out.println(findNode.value);
        }

        bstAge.delete(19);
        bstAge.inorder();
    }
}
