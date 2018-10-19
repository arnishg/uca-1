class trie {
    class node {
        boolean end;
        node[] arr;
    }
    node create() {
        node nn = new node();
        nn.end = false;
        nn.arr = new node[26];
        return nn;
    }
    node root;
    trie() {
        root = create();
    }
    void insert(String s) {
        node temp = root;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ' ') {
                continue;
            }
            int x = s.charAt(i) - 'a';
            if(temp.arr[x] == null) {
                temp.arr[x] = create();
            }
            temp = temp.arr[x];

        }
        temp.end = true;
    }
    boolean search(String s) {
        node temp = root;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ' ') {
                continue;
            }
            int x = s.charAt(i) - 'a';
            if(temp.arr[x] == null) {
                return false;
            }
            temp = temp.arr[x];
        }
        if(temp.end == true) {
            return true;
        }
        return false;
    }
}
public class trie_tree {
    public static void main(String[] args) {
        trie t = new trie();
        t.insert("grover");
        System.out.println(t.search("arnish"));
    }
}
