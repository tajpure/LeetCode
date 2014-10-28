package tajpure;

/**
 * @author taojx
 *
 */
public class SortList_Non_Recursion {
	public static ListNode sortList(ListNode head) {
		 if (head == null || head.next == null) {
			 return head;
		 }
		 int k = 1;
		 ListNode aNode = head;
		 ListNode bNode = head.next;
		 ListNode cNode = head;
//		 while (cNode.next != null) {
//			 int i = k;
//			 while (bNode.next != null) {
//				 aNode = merge(aNode, bNode, i);
//				 while (i > 0) {
//					 aNode = aNode.next;
//					 bNode = bNode.next;
//					 i--;
//				 }
//				 bNode = bNode.next;
//			 }
//			 k++;
//			 cNode = cNode.next;
//		 }
		 
		 return merge(aNode, bNode, k);
	 }
	 
	 public static ListNode merge(ListNode aNode, ListNode bNode, int k) {
		 int i = 0;
		 int aflag = 0;
		 int bflag = 0;
		 ListNode head = new ListNode(0);
		 if (aNode == null && bNode == null) return null;
		 ListNode current = head;
		 while (aNode != null && bNode != null && i < k) {
			 if(aNode.val < bNode.val) {
				 current.next = aNode;
				 aflag++;
				 aNode = aNode.next;
			 } else {
				 current.next = bNode;
				 bflag++;
				 bNode = bNode.next;
			 }
			 current = current.next;
			 i++;
		 }
		 return head.next;
	 }
	 
	 public static void main(String[] args) {
		 ListNode head = new ListNode(0);
		 ListNode current = null;
		 for (int i = 1; i < 10; i++) {
			 current = new ListNode(i);
			 current.next = head;
			 head = current;
		 }
		 //head = null;
		 head = sortList(head);
		 while (head.next != null) {
			 System.out.print(head.val + " ");
			 head = head.next;
		 }
		 System.out.println(head.val);
	 }
}
