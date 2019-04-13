/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */

public class Solution {
    class Result{
        int cnt;
        int sum;
        TreeNode maxNode;
        float maxVal;
        Result left;
        Result right;
        Result(){
            maxNode = null;
            maxVal = Float.NEGATIVE_INFINITY;
        }
        Result(TreeNode root){
            left = new Result();
            right = new Result();
            if(root.left != null){
                left = new Result(root.left);
            }
            if(root.right != null){
                right = new Result(root.right);
            }
            
            cnt = left.cnt + right.cnt + 1;
            sum = left.sum + right.sum + root.val;
            float val = (float) sum / cnt;
            
            // System.out.println(val);
            
            if(val > left.maxVal && val > right.maxVal){
                maxNode = root;
                maxVal = val;
            } else {
                if(left.maxVal > right.maxVal){
                    maxNode = left.maxNode;
                    maxVal = left.maxVal;
                } else {
                    maxNode = right.maxNode;
                    maxVal = right.maxVal;
                }
            }
            // System.out.println(maxNode == root);
        }
    }
    
    /**
     * @param root: the root of binary tree
     * @return: the root of the maximum average of subtree
     */
    public TreeNode findSubtree2(TreeNode root) {
        // write your code here
        if(root == null || root.left == null && root.right == null)
            return root;
        Result r = new Result(root);
        // if(r.maxNode == root){
        //     if(r.left.maxVal > r.right.maxVal){
        //         return r.left.maxNode;
        //     } else {
        //         return r.right.maxNode;
        //     }
        // }
        return r.maxNode;
    }
}