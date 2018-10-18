interface c_stack {
	void push(int a);
	int pop();
	
	boolean isEmpty();
	boolean isFull();
	int top();
}
class A_Stack implements c_stack{
	int[] arr;
	int size;
	int i;
	A_Stack(int a) {
		arr = new int[a];
		size = a;
	}
	A_Stack() {
		this(10);
	}
	
	public boolean isEmpty() {
		return i == 0;
	}
	public boolean isFull() {
		return i == size;
	}
	public void push(int a) {
		if(isFull() == true) {
			return;
		}
		arr[i++] = a;
	}
	public int pop() {
		if(isEmpty() == true) {
			return -1;
		}
		int t = top();
		i--;
		return t;
	}
	public int top() {
		if(isEmpty() == true) {
			return -1;
		}
		int t = arr[i-1];
		return t;
	}
	
}
class L_Stack implements c_stack {
	class Node {
		int data;
		Node next;
	}
	Node head;
	int s;
	L_Stack(int a) {
		head = null;
		s = a;
	}
	L_Stack() {
		this(10);
	}
	public int size() {
		Node temp = head;
		int i = 0;
		while(temp != null) {
			temp = temp.next;
			i++;
		}
		return i;
	}
	public boolean isEmpty() {
		return head == null;
	}
	public boolean isFull() {
		return size() == s;
	}
	public void push(int a) {
		if(isFull() == true) {
			return;
		}
		Node nn = new Node();
		nn.data = a;
		if(head == null) {
			head = nn;
			return;
		}
		nn.next = head;
		head = nn;
	}
	public int pop() {
		if(isEmpty() == true) {
			return -1;
		}
		int t = head.data;
		head = head.next;
		return t;
	}
	public int top() {
		if(isFull() == true) {
			return  -1;
		}
		int t = head.data;
		return t;
	}
	
}
public class MyStack {
	public static void main(String[] args) {
		c_stack s = new L_Stack();
		assert s.isEmpty() == true;
		assert s.isFull() == false;
		s.push(5);
		assert s.top() == 5;
		s.pop();
		assert s.isEmpty() == true;
		s.push(6);
		s.push(7);
		assert s.top() == 7;
		s.pop();
		assert s.top() == 6;
		for(int i = 0; i < 9; i++) {
			s.push(i);
		}
		assert s.isFull() == true;
		assert s.isEmpty() == false;
		System.out.println("All cases Passed");
	}
}
