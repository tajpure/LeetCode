package tajpure;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class BinaryTreePreorderTraversal {
	    public static List<Integer> postorderTraversal(TreeNode root) {
	        List<Integer> list = new ArrayList<Integer>();
	        Stack<TreeNode> s1 = new Stack<TreeNode>();
	        Stack<TreeNode> s2 = new Stack<TreeNode>();
	    	if (root == null) return list;
	        TreeNode curNode;
	        s1.push(root);
	        while (!s1.empty()) {
	        	curNode = s1.pop();
	        	if (curNode.left != null) s1.push(curNode.left);
	        	if (curNode.right != null) s1.push(curNode.right);
	        	s2.push(curNode);
	        }
	        while (!s2.empty()) {
	        	list.add(s2.pop().val);
	        }
	    	return list;
	    }
	    
	    public static void main(String[] args) {
	    	TreeNode t1 = new TreeNode(1);
	    	TreeNode t2 = new TreeNode(2);
	    	TreeNode t3 = new TreeNode(3);
	    	t1.right = t2;
	    	t2.left = t3;
	    	System.out.println(postorderTraversal(t1));
	    }
	}
