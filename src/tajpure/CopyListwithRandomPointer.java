package tajpure;

import java.util.HashMap;

/**
 * time:O(n) memory:O(n) 
 * 
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 * 
 * Here is another way(time:O(n) memory:O(1)) to be accepted from the discuss from LeetCode:
 * Step 1: create a new node for each existing node and join them together eg: A->B->C will be A->A'->B->B'->C->C'
 * Step 2: copy the random links: for each new node n', n'.random = n.random.next
 * Step 3: detach the list: basically n.next = n.next.next; n'.next = n'.next.next
 */
public class CopyListwithRandomPointer {

	    public static RandomListNode copyRandomList(RandomListNode head) {
	    	if (head == null) return head;
	    	RandomListNode curNode = head;
	        RandomListNode headCopy = new RandomListNode(head.label);
	        RandomListNode curCopy = headCopy;
	        HashMap<RandomListNode,RandomListNode> copyTable = new HashMap<RandomListNode,RandomListNode>();
	        while (curNode != null) {		// copy next
	        	RandomListNode temp = curNode.next;
	        	if (temp != null) {
	        		curCopy.next = new RandomListNode(temp.label);
	        	}
	        	copyTable.put(curNode, curCopy);
	        	curNode = temp;
	        	curCopy = curCopy.next;
	        }
	        curNode = head;
	        curCopy = headCopy;
	        while (curNode != null) {	// copy random
	        	curCopy.random = copyTable.get(curNode.random);
	        	curNode = curNode.next;
	        	curCopy = curCopy.next;
	        }
	        return headCopy;
	    }
	    
	    public static void print(RandomListNode curNode) {
	    	while (curNode != null) {
	    		System.out.println("label:" + curNode.label);
	    		if (curNode.random != null) {
	    			System.out.println("random label:" + curNode.random.label);
	    		}
	    		curNode = curNode.next;
	    	}
	    }
	    
	    public static void main(String[] args) {
	    	RandomListNode head = new RandomListNode(0);
	    	RandomListNode curNode = head;
	    	head.random = head;
	    	for (int i = 1; i < 5; i++) {
	    		curNode.next = new RandomListNode(i);
	    		curNode.random = curNode;
	    		curNode = curNode.next;
	    	}
    		curNode.random = curNode;
	    	print(head);
	    	curNode = copyRandomList(head);
	    	print(curNode);
	    }
}
