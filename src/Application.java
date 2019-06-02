import dataStructure.tree.BinarySearchTree;
import dataStructure.tree.TreeTraverse;

/**
 * Created by jack.
 * Date: 2019-06-01
 * Time: 14:05
 */
public class Application {

    public static void main(String[] args) {

        BinarySearchTree<Integer> bst = new BinarySearchTree<>(35);

        bst.insert(25);
        bst.insert(36);
        bst.insert(13);
        bst.insert(34);
        bst.insert(36);
        bst.insert(48);

        System.out.println(bst.search(14));
        System.out.println(bst.insert(14));
        System.out.println(bst.search(14));
        System.out.println(bst.delete(14));
        System.out.println(bst.search(14));

        TreeTraverse.inorder(bst.getRoot());
        TreeTraverse.levelOrder(bst.getRoot());
    }

}
