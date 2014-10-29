package tajpure;

/**
 * Definition for singly-linked list. class ListNode { int val; ListNode next;
 * ListNode(int x) { val = x; next = null; } }
 */
public class LinkedListCycle {

	public static boolean detectCycle(ListNode head) {
		if (head == null || head.next == null) return false;
		ListNode fast = head;
		ListNode slow = head;
		while (fast != null) {
			slow = slow.next;
			fast = fast.next;
			if (fast != null) {
				fast = fast.next;
			}
			if (fast == slow) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(0);
//		ListNode cur = null;
//		ListNode pre = head;
//		for (int i = 1; i < 10; i++) {
//			cur = new ListNode(i);
//			pre.next = cur;
//			pre = pre.next;
//		}
//		pre.next = head.next;
		System.out.println(detectCycle(head));
	}
}
