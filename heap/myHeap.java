
package uca-1.heap

interface heap {
	void enque(int a);
	void deque();
	void swim(int i);
	void sink(int i);
	int getTop();
	void swap(int a, int b);
}
class maxHeap implements heap {
	int[] arr;
	int size;
	
	maxHeap() {
		arr = new int[100];
		size = 0;
	}
	public void enque(int data) {
		arr[size] = data;
		swim(size);
		size++;
	}
	public void swim(int i) {
		if(i == 0) {
			return;
		}
		if(arr[i] > arr[i/2]) {
			swap(i,i/2);
		}
		swim(i/2);
	}
	public void swap(int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	public void deque() {
		swap(0,size-1);
		size--;
		sink(0);
	}
	public void sink(int i) {
		int max = i;
		if(2*i < size && arr[i] < arr[2*i]) {
			max = 2*i;
		}
		if((2*i + 1) < size && arr[i] < arr[2*i + 1]) {
			max = 2*i + 1;
		}
		if(max != i) {
			swap(i, max);
			sink(max);
		}
	}
	public int getTop() {
		return arr[0];
	}
	
}
public class myHeap {
	public static void main(String[] args) {
		maxHeap m = new maxHeap();
		m.enque(1);
		m.enque(11);
		m.enque(12);
		m.enque(5);
		m.enque(4);
		for(int i: m.arr) {
			System.out.println(i);
		}
		System.out.println(m.getTop());
	}
	
}
