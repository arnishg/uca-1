public class Solution {
    public int colorful(int A) {
        ArrayList<Character> arr = new ArrayList<>();
        Set<Integer> hash = new HashSet<Integer>();
        int n = A;
        while(n > 0) {
            arr.add((char)(n%10 + 48));
            n = n/10;
        }
        Collections.reverse(arr);
        StringBuilder sb = new StringBuilder();
        for(char a: arr) {
            sb.append(a);
        }
        String temp = sb.toString();
        for(int i = 0; i < temp.length(); i++) {
            for(int j = i+1; j < temp.length()+1; j++) {
                int t = Integer.parseInt(temp.subSequence(i, j).toString());
                int p = 1;
                while(t > 0) {
                    p *= t%10;
                    t = t/10;
                }
                if(hash.contains(p)) {
                    return 0;
                }
                hash.add(p);
            }
        }
        return 1;
    }
}
