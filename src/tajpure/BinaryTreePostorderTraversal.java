package tajpure;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * time:O(n) memory:O(n) 
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class BinaryTreePostorderTraversal {
	    public static List<Integer> postorderTraversal(TreeNode root) {
	        List<Integer> list = new ArrayList<Integer>();
	        Stack<TreeNode> s = new Stack<TreeNode>();
	    	if (root == null) return list;
	        while (root != null) {
	        	s.push(root);
	        	list.add(root.val);
	        	root = root.left;
	        }
	        while (!s.empty()) {
	        	TreeNode curNode = s.pop().right;
	        	while (curNode != null) {
	        		s.push(curNode);
		        	list.add(curNode.val);
	        		curNode = curNode.left;
	        	}
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
