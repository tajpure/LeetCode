package tajpure;

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
	    	ListNode fastP = head;
	    	ListNode slowP = head;
	    	while (fastP != null) {
	    		slowP = slowP.next;
	    		fastP = fastP.next;
	    		if (fastP != null) {
	    			fastP = fastP.next;
	    		}
	    	}
	    	slowP = reverse(slowP);
	    	while (slowP != null) {
	    		ListNode cur = slowP;
	    		slowP = slowP.next;
		    	ListNode last = head.next;
	    		cur.next = last;
	    		head.next = cur;
	    		head = last;
	    	}
	    	head.next = null;
	    }
	    
	    public static ListNode reverse(ListNode head) {
	    	if (head == null || head.next == null) return head;
			ListNode top = head;
			ListNode cur = head.next;
			top.next = null;
			while (cur != null) {
				ListNode tmp = cur.next;
				cur.next = top;
				top = cur;
				cur = tmp;
			}
			return top;
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
	    	reorderList(head);
	    	printList(head);
	    }
}
