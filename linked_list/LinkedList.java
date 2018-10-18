package uca-1.linked_list;

interface Linked {
	void addFirst(int data);
	void addLast(int data);
	int size();
	boolean contains(int data);
	void removeFirst();
	void removeLast();
}
class myLinkedList implements Linked {
	class Node {
		int data;
		Node next;
		Node(int a) {
			data = a;
			next = null;
		}
	}
	Node head;
	myLinkedList() {
		head = null;
	}
	public void addFirst(int d) {
		Node nn = new Node(d);
		nn.next = head;
		head = nn;
	}
	public void addLast(int d) {
		Node nn = new Node(d);
		if(head == null) {
			head = nn;
			return;
		}
		Node temp = head;
		while(temp.next != null) {
			temp = temp.next;
		}
		temp.next = nn;
	}
	public int size() {
		int i = 0;
		Node temp = head;
		while(temp != null) {
			temp = temp.next;
			i++;
		}
		return i;
	}
	public boolean contains(int a) {
		Node temp = head;
		while(temp != null) {
			if(temp.data == a) {
				return true;
			}
			temp = temp.next;
		}
		return false;
	}
	public void removeFirst() {
		if(head == null) {
			return;
		}
		head = head.next;
	}
	public void removeLast() {
		if(head == null) {
			return;
		}
		if(head.next == null) {
			head = null;
			return;
		}
		Node temp = head;
		while(temp.next.next != null) {
			temp = temp.next;
		}
		temp.next = null;
	}
}
public class LinkedList {

	public static void main(String[] args) {
		myLinkedList l = new myLinkedList();
		assert l.size() == 0;
		l.addFirst(1);
		assert l.size() == 1;
		l.addLast(2);
		assert l.size() == 2;
		assert l.contains(2) == true;
		l.removeLast();
		assert l.contains(2) == false;
		assert l.contains(1) == true;
		assert l.size() == 1;
		l.removeLast();
		assert l.contains(1) == false;
		assert l.size() == 0;
		System.out.println("All cases Passed");
	}

}
