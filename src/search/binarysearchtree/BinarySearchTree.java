package search.binarysearchtree;

public class BinarySearchTree<K extends Comparable<K>, V> {
    private TreeNode<K, V> root;

    public TreeNode<K, V> search(K key) {
        return search(root, key);
    }

    private TreeNode<K, V> search(TreeNode<K, V> t, K key) {
        if (t == null) {
            return null;
        }
        int result = key.compareTo(t.key);
        if (result == 0) {
            return t;
        } else if (result < 0) {
            return search(t.left, key);
        } else {
            return search(t.right, key);
        }
    }

    public void insert(K key, V value) {
        root = insert(root, key, value);
    }

    private TreeNode<K, V> insert(TreeNode<K, V> t, K key, V value) {
        if (t == null) {
            return new TreeNode<K, V>(key, value, null, null);
        }
        int result = key.compareTo(t.key);
        if (result < 0) {
            t.left = insert(t.left, key, value);
        } else if (result > 0) {
            t.right = insert(t.right, key, value);
        }
        return t;
    }

    public void delete(K key) {
        root = findAndDelete(root, key);
    }

    private TreeNode<K, V> findAndDelete(TreeNode<K, V> t, K key) {
        if (t == null) {
            return null;
        }
        int result = key.compareTo(t.key);
        if (result == 0) {
            // 해당 노드 삭제하기
            t = deleteNode(t);
        } else if (result < 0) {
            t.left = findAndDelete(t.left, key);
        } else {
            t.right = findAndDelete(t.right, key);
        }
        return t;
    }

    private TreeNode<K, V> deleteNode(TreeNode<K, V> t) {
        if (t.left == null && t.right == null) {
            return null; // case 1 (no child)
        } else if (t.left == null) {
            return t.right; // case 2 (only right child
        } else if (t.right == null) {
            return t.left; // case 2 (only left child)
        } else { // case 3 (two children)
            TreeNode<K, V> s = t.right;
            TreeNode<K, V> parent = null;
            while (s.left != null) {
                parent = s;
                s = s.left;
            }
            t.key = s.key;
            t.value = s.value;
            if (s == t.right) {
                t.right = s.right;
            } else {
                parent.left = s.right;
            }

            return t;
        }
    }


    // 중위 순회
    public void inorder() {
        inorder(root);
    }

    private void inorder(TreeNode<K, V> t) {
        if (t == null) {
            return;
        }
        inorder(t.left);
        System.out.println(t.value);
        inorder(t.right);
    }
}
