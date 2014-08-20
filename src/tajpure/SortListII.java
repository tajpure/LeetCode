package tajpure;
/**
 *
 * @author taojx
 */
public class SortListII {
	
	 public static ListNode sortList(ListNode head) {
		 if (head == null || head.next == null) {
			 return head;
		 }
		 ListNode slowNode = head;
		 ListNode fastNode = head.next;
		 while (fastNode.next != null && fastNode.next.next != null) {
			 slowNode = slowNode.next;
			 fastNode = fastNode.next.next;
		 }
		 fastNode = sortList(slowNode.next);
		 slowNode.next = null;
		 slowNode = sortList(head);
		 return merge(slowNode, fastNode);
	 }
	 
	 public static ListNode merge(ListNode aNode, ListNode bNode) {
		 ListNode head = new ListNode(0);
		 if (aNode == null && bNode == null) return null;
		 ListNode current = head;
		 while (aNode != null && bNode != null) {
			 if(aNode.val < bNode.val) {
				 current.next = aNode;
				 aNode = aNode.next;
			 } else {
				 current.next = bNode;
				 bNode = bNode.next;
			 }
			 current = current.next;
		 }
		 if (aNode != null) {
			 current.next = aNode;
		 }
		 if (bNode != null) {
			 current.next = bNode;
		 }
		 return head.next;
	 }
	 
	 public static void main(String[] args) {
		 ListNode head = new ListNode(0);
		 head.next = new ListNode(123);
		 ListNode current = null;
		 for (int i = 1; i < 10; i++) {
			 current = new ListNode(i);
			 current.next = head;
			 head = current;
		 }
		 head = null;
		 head = sortList(head);
//		 while (head.next != null) {
//			 System.out.println(head.val);
//			 head = head.next;
//		 }
		 System.out.println(head);
	 }
}
