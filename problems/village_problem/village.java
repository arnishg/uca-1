import java.util.Collections;
import java.util.PriorityQueue;

class allot implements Comparable<allot>{
		private int pop;
		private int hosp;
		allot(int p) {
			this.pop = p;
			this.hosp = 1;
		}
		void addHosp() {
			this.hosp++;
		}
		int density() {
			return this.pop/this.hosp;
		}
		public int compareTo(allot o) {
			if(o.density() > density()) {
				return -1;
			}
			return 1;
		}
		
}
public class village {
	
	public static void main(String[] args) {
		int[] arr = {500,200,300};
		int m = 5;
		PriorityQueue<allot> q = new PriorityQueue<allot>(Collections.reverseOrder());
		for(int i: arr) {
			q.add(new allot(i));
		}
		m -= arr.length;
		while(m > 0) {
			allot temp = q.poll();
			temp.addHosp();
			q.add(temp);
			m--;
		}
		int t = q.peek().density();
		System.out.print(t);
		
		
	}
}
