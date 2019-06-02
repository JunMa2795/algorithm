package dataStructure.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by jack.
 * Date: 2019-06-01
 * Time: 17:29
 */
public class TreeTraverse {

    public static void preorder(TreeNode<?> root) {

        if (root == null) {
            return;
        }

        System.out.println(root.element + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void inorder(TreeNode<?> root) {

        if (root == null) {
            return;
        }

        inorder(root.left);
        System.out.println(root.element + " ");
        inorder(root.right);
    }

    public static void postorder(TreeNode<?> root) {

        if (root == null) {
            return;
        }

        postorder(root.left);
        postorder(root.right);
        System.out.println(root.element + " ");
    }

    public static void levelOrder(TreeNode<?> root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode tempNode = queue.poll();
            System.out.print(tempNode.element + " ");
            if (tempNode.left != null) {
                queue.add(tempNode.left);
            }
            if (tempNode.right!= null) {
                queue.add(tempNode.right);
            }
        }

    }

}
