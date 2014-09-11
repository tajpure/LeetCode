package com.taj;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class InsertionSortList {
	
	private static ListNode sortList = new ListNode(0);;
	
    public static ListNode insertionSortList(ListNode head) {
        ListNode curNode = head;
        
        while (curNode.next != null) {
        	ListNode node = new ListNode(curNode.val);
        	insert(node);
        	curNode = curNode.next;
        }
        insert(curNode);
        return sortList.next;
    }
    
    public static void insert(ListNode node) {
    	ListNode curNode = sortList.next;
    	ListNode lastNode = sortList;
    	
    	while (curNode != null && curNode.next != null) {
    		if (curNode.val > node.val) {
    			node.next = curNode;
    			lastNode.next = node;
    			break;
    		}
    		lastNode = curNode;
    		curNode = curNode.next;
    	}
    	if (curNode == null) {
    		sortList.next = new ListNode(node.val);
    	} else if (curNode.next == null) {
    		if (curNode.val > node.val) {
    			node.next = curNode;
    			lastNode.next = node;
    		} else {
    			curNode.next = node;
    		}
    	}
    }
    
    
    public static void print(ListNode head) {
    	while (head.next != null) {
    		System.out.print(head.val + " ");
    		head = head.next;
    	}
    	System.out.print(head.val);
    }
    public static void main(String[] args) {
    	ListNode head = new ListNode(231);
    	ListNode cur = null;
    	for (int i=0; i < 123; i++) {
    		cur = new ListNode(i);
    		cur.next = head;
    		head = cur;
    	}
    	head = null;
    	head = insertionSortList(head);
    	print(head);
    }
}
