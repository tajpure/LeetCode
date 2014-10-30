package tajpure;

import java.util.HashMap;


/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class CopyListwithRandomPointer {

	    public static RandomListNode copyRandomList(RandomListNode head) {
	    	if (head == null) return head;
	    	RandomListNode curNode = head;
	        RandomListNode headCopy = new RandomListNode(head.label);
	        RandomListNode curCopy = headCopy;
	        HashMap<RandomListNode,RandomListNode> copyTable = new HashMap<RandomListNode,RandomListNode>();
	        while (curNode != null) {		// copy next
	        	RandomListNode tmp = curNode.next;
	        	if (tmp != null) {
	        		curCopy.next = new RandomListNode(tmp.label);
	        	}
	        	copyTable.put(curNode, curCopy);
	        	curNode = tmp;
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
