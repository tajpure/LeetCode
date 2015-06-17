package tajpure;

public class AddTwoNumbers {
	
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int num1, num2, carry = 0;
    	ListNode tmp = new ListNode(0);
        ListNode sum = tmp;
        while (l1 != null || l2 != null || carry != 0) {
        	num1 = 0;
        	num2 = 0;
        	if (l1 != null) {
        		num1 = l1.val;
        		l1 = l1.next;
        	}
        	if (l2 != null) {
        		num2 = l2.val;
        		l2 = l2.next;
        	}
        	tmp.next = new ListNode((num1 + num2 + carry) % 10);
        	tmp = tmp.next;
        	carry = (num1 + num2 + carry) / 10;
        }
        return sum.next;
    }
	
	public static void print(ListNode head) {
		while (head != null) {
			System.out.println(head.val + " ");
			head = head.next;
		}
	}
	
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(9);
//		l1.next = new ListNode(4);
		l2.next = new ListNode(9);
//		l1.next.next = new ListNode(3);
//		l2.next.next = new ListNode(4);
		print(addTwoNumbers(l1,l2));
	}
}
