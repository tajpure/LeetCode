package tajpure;

import java.util.Stack;

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class ReorderList {

	    public static void reorderList(ListNode head) {
	    	if (head == null) return;
	    	Stack<ListNode> stack = new Stack<ListNode>();
	    	ListNode fastP = head;
	    	ListNode slowP = head;
	    	while (fastP != null) {
	    		slowP = slowP.next;
	    		fastP = fastP.next;
	    		if (fastP != null) {
	    			fastP = fastP.next;
	    		}
	    	}
	    	while (slowP != null) {
	    		stack.push(slowP);
	    		slowP = slowP.next;
	    	}
	    	while (!stack.empty()) {
	    		ListNode cur = stack.pop();
		    	ListNode last = head.next;
	    		cur.next = last;
	    		head.next = cur;
	    		head = last;
	    	}
	    	head.next = null;
	    }
	    
	    public static void printList(ListNode head) {
	    	while (head != null) {
	    		System.out.print(head.val + " ");
	    		head = head.next;
	    	}
	    }
	    
	    public static void main(String[] args) {
	    	ListNode head = new ListNode(0);
	    	ListNode cur;
	    	ListNode pre = head;
	    	for (int i = 1; i < 10; i++) {
	    		cur = new ListNode(i);
	    		pre.next = cur;
	    		pre = pre.next;
	    	}
	    	reorderList(null);
	    	printList(head);
	    }
}
