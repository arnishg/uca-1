public class Solution {
    public static boolean isSafe(int i, int j, ArrayList<String> A, boolean[][] marked){
        return (i >= 0 && i < A.size() && j >= 0 && j < A.get(0).length() && A.get(i).charAt(j) == 'X' && marked[i][j] == false);
    }
    public static void dfs(ArrayList<String> A, int i, int j, int count, boolean[][] marked) {
        marked[i][j] = true;
        if(isSafe(i-1, j, A, marked)) {
            dfs(A, i-1, j, count, marked);
        }
        if(isSafe(i+1, j, A, marked)) {
            dfs(A, i+1, j, count, marked);
        }
        if(isSafe(i, j-1 , A, marked)) {
            dfs(A, i, j -1 , count, marked);
        }
        if(isSafe(i, j+1 , A, marked)) {
            dfs(A, i, j+1, count, marked);
        }
    }
    public int black(ArrayList<String> A) {
        boolean[][] marked = new boolean[A.size()][A.get(0).length()];
        for(int i = 0; i < A.size(); i++) {
            Arrays.fill(marked[i], false);
        }
        
        int count = 0;
        for(int i = 0; i < A.size(); i++) {
            for(int j = 0; j < A.get(0).length(); j++) {
                if(marked[i][j] == false && A.get(i).charAt(j) == 'X') {
                    marked[i][j] = true;
                    count++;
                    dfs(A, i, j, count, marked);
                }
            }
        }
        return count;
        
    }
}
