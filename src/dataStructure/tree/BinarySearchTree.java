package dataStructure.tree;

/**
 * Created by jack.
 * Date: 2019-06-01
 * Time: 12:10
 */
public class BinarySearchTree<E extends Comparable<E>> {

    private TreeNode<E> root;

    public BinarySearchTree(E e) {
        root = new TreeNode<>(e);
    }

    public boolean search(E e) {

        TreeNode<E> current = root;

        while (current != null) {
            if (e.compareTo(current.element) < 0) {
                current = current.left;
            } else if (e.compareTo(current.element) > 0) {
                current = current.right;
            } else {
                return true;
            }
        }

        return false;
    }

    public boolean insert(E e) {

        if (root == null) {
            root = new TreeNode<>(e);
        } else {
            TreeNode<E> parent = null;
            TreeNode<E> current = root;

            while (current != null) {
                if (e.compareTo(current.element) < 0) {
                    parent = current;
                    current = current.left;
                } else if (e.compareTo(current.element) > 0) {
                    parent = current;
                    current = current.right;
                } else {
                    return false;
                }
            }

            if (e.compareTo(parent.element) < 0) {
                parent.left = new TreeNode<>(e);
            } else {
                parent.right = new TreeNode<>(e);
            }

        }

        return true;
    }

    public boolean delete(E e) {

        TreeNode<E> parent = null;
        TreeNode<E> current = root;

        while (current != null) {
            if (e.compareTo(current.element) < 0) {
                parent = current;
                current = current.left;
            } else if (e.compareTo(current.element) > 0) {
                parent = current;
                current = current.right;
            } else {
                break;
            }
        }

        if (current == null) {
            return false;
        }

        if (current.left == null) {
            if (parent == null) {
                root = current.right;
            } else {
                if (e.compareTo(parent.element) < 0) {
                    parent.left = current.right;
                } else {
                    parent.right = current.right;
                }
            }
        } else {
            TreeNode<E> parentOfRightMost = current;
            TreeNode<E> rightMost = current.left;

            while (rightMost.right != null) {
                parentOfRightMost = rightMost;
                rightMost = rightMost.right;
            }

            current.element = rightMost.element;

            if (parentOfRightMost.right.equals(rightMost)){
                parentOfRightMost.right = rightMost.left;
            } else {
                parentOfRightMost.left = rightMost.left;
            }

        }

        return true;
    }

    public TreeNode<E> getRoot() {
        return root;
    }
}

class TreeNode<E extends Comparable<E>> {

    E element;
    TreeNode<E> left;
    TreeNode<E> right;

    TreeNode(E e) {
        element = e;
    }
}

