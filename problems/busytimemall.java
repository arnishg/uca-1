
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class busytimemall {
	
	public static void main(String[] args) {
		ArrayList<String> arr = new ArrayList<>();
		arr.add("1472568095461 59 E");
		arr.add("1472568095461 59 E");
		arr.add("1472630264983  5 X");
		arr.add("1472635488880 59 E");
		
		arr.add("1472641430597 60 X");
		arr.add("1472635488880 2 X");
		
		class customSort implements Comparator<String> {
			@Override
			public int compare(String a, String b) {
				String[] t1 = a.split(" ");
				String[] t2 = b.split(" ");
				return t1[0].compareTo(t2[0]);
			}
		}
		Collections.sort(arr, new customSort());
		
		int max = 0;
		int current = 0;
		StringBuilder sb = new StringBuilder();
		StringBuilder next = new StringBuilder();
		for(String temp: arr) {
			String[] op = temp.split(" ");
			//System.out.println();
			if(op[2].charAt(0) == 'E') {
				//System.out.println("Entering if 1");
				current += Integer.parseInt(op[1]);
				
			}
			else if(op[2].charAt(0) == 'X') {
				//System.out.println("Entering if 2");
				current -= Integer.parseInt(op[1]);
			}
			
			if(current > max) {
				//System.out.println("Entering if 3");
				max = current;
				sb.setLength(0);
				sb.append(op[0]);
			}
			
		}
		//System.out.println("Max visitors at: " + sb.toString());
		for(int i = 0; i < arr.size(); i++) {
			String temp = arr.get(i);
			String[] op = temp.split(" ");
			if(sb.toString().compareTo(op[0]) == 0) {
				if(i < arr.size() - 1) {
					next.setLength(0);
					next.append(arr.get(i+1).split(" ")[0]);
					
				}
				
			}
		}
		System.out.println(sb.toString() + " " + next.toString());
		
	}
}
