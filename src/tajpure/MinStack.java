package tajpure;

import java.util.ArrayList;
import java.util.List;

public class MinStack {
	private List<Integer> list = new ArrayList<Integer>();
	private List<Integer> minlist = new ArrayList<Integer>();
	public void push(int x) {
		int topIndex = minlist.size()-1;
		if (topIndex < 0 || x <= minlist.get(topIndex)) {
			minlist.add(x);
		}
		list.add(x);
	}

	public void pop() {
		int topIndex = minlist.size()-1;
		int top = list.remove(list.size()-1);
		if (top == minlist.get(topIndex)) {
			minlist.remove(topIndex);
		}
	}

	public int top() {
		return list.get(list.size()-1);
	}

	public int getMin() {
		return  minlist.get(minlist.size()-1);
	}
	
	public String toString() {
		return list.toString();
	}
	
	public static void main(String[] args) {
		MinStack stack = new MinStack();
		stack.push(-1);
		stack.push(0);
		stack.push(1);
		stack.push(-1);
		System.out.println(stack);
		stack.top();
		System.out.println(stack.getMin());
		stack.pop();
		System.out.println(stack.getMin());
		stack.pop();
	}
}
