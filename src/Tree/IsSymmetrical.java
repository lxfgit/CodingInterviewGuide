package Tree;

/**
 * Created by LXF on 2017/8/15.
 */
public class IsSymmetrical {
    public static boolean isSymmetrical(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return false;
        }
        TreeNode l = root.left;
        TreeNode r = root.right;

        return false;
    }
}
