package Tree;

/**
 * Created by LXF on 2017/8/15.
 */
public class HasSubtree {
    public static boolean hasSubtree(TreeNode root1, TreeNode root2) {
        if(root2==null) return false;
        if(root1==null && root2!=null) return false;
        boolean flag = false;
        if(root1.val==root2.val){
            flag = isSubTree(root1,root2);
        }
        if(!flag){
            flag = hasSubtree(root1.left, root2);
            if(!flag){
                flag = hasSubtree(root1.right, root2);
            }
        }
        return flag;
    }
    public static boolean isSubTree(TreeNode root1, TreeNode root2) {
        if(root2==null) return true;
        if(root1==null && root2!=null) return false;
        if(root1.val==root2.val){
            return isSubTree(root1.left, root2.left) && isSubTree(root1.right, root2.right);
        }else{
            return false;
        }
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        node1.left = new TreeNode(2);
        node1.right = new TreeNode(3);
        node1.left.left = new TreeNode(4);
        TreeNode node2 = new TreeNode(2);
        node2.left = new TreeNode(4);
        System.out.println(hasSubtree(node1,node2));
    }
}
