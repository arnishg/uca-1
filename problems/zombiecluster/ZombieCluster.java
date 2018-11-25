import java.util.*;
public class ZombieCluster {
	public static void main(String[] args) {
		ArrayList<String> arr = new ArrayList<>();
		/*arr.add("1100001");						
        arr.add("1110001");										
        arr.add("0110001");										
        arr.add("0001100");					
        arr.add("0001100");					
        arr.add("0000010");					
        arr.add("0010001");						
        	*/
		arr.add("1100");
		arr.add("1110");
		arr.add("0110");
		arr.add("0001");
        										
        ArrayList<ArrayList<Integer>> input = new ArrayList<>();
        for(int i = 0; i < arr.size(); i++) {
        	ArrayList<Integer> temp = new ArrayList<>();
        	String p = arr.get(i);
        	for(int j = 0; j < p.length(); j++) {
        		temp.add(Integer.parseInt(p.substring(j,j+1) ) );
        	}
        	input.add(temp);
        }
        boolean[] marked = new boolean[input.get(0).size()];
        int count = 0;
        for(int i = 0; i < input.size(); i++) {
        	if(marked[i] == false) {
        		
        		dfs(input, marked, i);
        		marked[i] = true;
        		count++;
        	}
        }
        System.out.println(count);
	}
	public static void dfs(ArrayList<ArrayList<Integer>> input, boolean[] marked, int i) {
		marked[i] = true;
		for(int j = 0; j < input.get(i).size(); j++) {
			if(input.get(i).get(j) == 1 && marked[j] == false) {
				marked[j] = true;
				dfs(input, marked, j);
			}
		}
	}
}
