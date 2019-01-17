public class Solution {
    public static boolean cycle(int v, int[][] arr, boolean[] marked, boolean[] recStack) {
        if(recStack[v]) {
            return true;
        }
        if(marked[v]) {
            return false;
        }
        
        recStack[v] = true;
        marked[v] = true;
        
        for(int i = 0; i < arr[v].length; i++) {
            if(arr[v][i] == 1 && cycle(i, arr, marked, recStack)) {
                return true;
            }
        }
        recStack[v] = false;
        return false;
    }
    public int solve(int A, ArrayList<Integer> B, ArrayList<Integer> C) {
        int[][] arr = new int[A][A];
        for(int i = 0; i < A; i++) {
            Arrays.fill(arr[i], 0);
        }
        
        for(int i = 0; i < B.size(); i++) {
            arr[B.get(i) - 1][C.get(i) - 1] = 1;
        }
        
        boolean[] marked = new boolean[A];
        boolean[] recStack = new boolean[A];
        Arrays.fill(recStack, false);
        Arrays.fill(marked, false);
        
        for(int i = 0; i < A; i++) {
            if(cycle(i, arr, marked, recStack)) {
                return 0;
            }
        }
        return 1;
    }
}
