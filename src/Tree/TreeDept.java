package Tree;

import org.junit.Test;

/**
 * Created by LXF on 2017/4/11.
 */
public class TreeDept {
    public int TreeDepth(TreeNode root) {
        if (root == null)
            return 0;

        int l = TreeDepth(root.left);
        int r = TreeDepth(root.right);

        if (l >= r)
            return l + 1;
        else
            return r + 1;
    }

    @Test
    public void test() {
        TreeDept treeDept = new TreeDept();
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.right = treeNode4;

        System.out.println(treeDept.TreeDepth(treeNode1));
    }
}
