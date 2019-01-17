public class Solution {
    public static boolean isSafe(ArrayList<ArrayList<Character>> a, int i, int j, boolean[][] marked) {
        return (i >= 0 && i < a.size() && j >= 0 && j < a.get(i).size() && marked[i][j] == false && a.get(i).get(j) == '*'); 
    }
    public static void dfs(ArrayList<ArrayList<Character>> a, int i, int j, boolean[][] marked) {
        
        marked[i][j] = true;
        a.get(i).set(j, 'O');
        
        if(isSafe(a, i, j-1, marked)) {
            dfs(a, i, j-1, marked);
        }
        if(isSafe(a, i, j+1, marked)) {
            dfs(a, i, j+1, marked);
        }
        if(isSafe(a, i-1, j, marked)) {
            dfs(a, i-1, j, marked);
        }
        if(isSafe(a, i+1, j, marked)) {
            dfs(a, i+1, j, marked);
        }
    }
    public void solve(ArrayList<ArrayList<Character>> a) {
        for(int i = 0; i < a.size(); i++) {
            for(int j = 0; j < a.get(0).size(); j++) {
                if(a.get(i).get(j) == 'O') {
                    a.get(i).set(j, '*');
                }
            }
        }
        boolean[][] marked = new boolean[a.size()][a.get(0).size()];
        for(int i = 0; i < a.size(); i++) {
            Arrays.fill(marked[i], false);
        }
        
        for(int i = 0; i < a.get(0).size(); i++) {
            if(marked[0][i] == false && a.get(0).get(i) == '*') {
                dfs(a, 0, i, marked);
            }
        }
        
        for(int i = 0; i < a.get(0).size(); i++) {
            if(marked[a.size() - 1][i] == false && a.get(a.size() - 1).get(i) == '*') {
                dfs(a, a.size() - 1, i, marked);
            }
        }
        for(int i = 0; i < a.size(); i++) {
            if(marked[i][0] == false && a.get(i).get(0) == '*') {
                dfs(a, i, 0, marked);
            }
        }
        for(int i = 0; i < a.size(); i++) {
            if(marked[i][a.get(0).size() - 1] == false && a.get(i).get(a.get(0).size() - 1) == '*') {
                dfs(a, i, a.get(0).size() - 1, marked);
            }
        }
        
        
        
        
        for(int i = 0; i < a.size(); i++) {
            for(int j = 0; j < a.get(i).size(); j++) {
                if(a.get(i).get(j) == '*') {
                    a.get(i).set(j, 'X');
                }
            }
        }
        
        /*for(ArrayList<Character> ch : a) {
            System.out.println(ch);
        }*/
    }
}
