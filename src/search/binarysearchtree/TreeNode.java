package search.binarysearchtree;

public class TreeNode<K, V> {
    K key;
    V value;

    TreeNode<K, V> left;
    TreeNode<K, V> right;

    public TreeNode(K key, V value, TreeNode<K, V> left, TreeNode<K, V> right) {
        this.key = key;
        this.value = value;
        this.left = left;
        this.right = right;
    }
}
