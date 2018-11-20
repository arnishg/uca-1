import java.util.*;
class BST {
    class Node {
        int data;
        Node left, right;
        int N;
        Node(int data) {
            this.data = data;
            left = right = null;
            N = 1;
        }
    }
    private Node root;
    public void insert(int key) {
        root = insert(root, key);
    }
    private Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        }
        if(root.data == data) {

        }
        else if(root.data > data) {
            root.left = insert(root.left, data);
        }
        else {
            root.right = insert(root.right, data);
        }
        root.N = 1 + size(root.left) + size (root.right);
        return root;
    }

    private int size(Node root) {
        if(root == null) {
            return 0;
        }
        return 1 + size(root.left) + size(root.right);

    }
    public int size() {

        return size(root);
    }
    public int getRank(int data) {
        return getRank(root, data);
    }
    private int getRank(Node root, int data) {
        int rank = 1;
        Node temp = root;
        while(temp != null) {
            if(temp.data > data) {
                temp = temp.left;
            }
            else if(temp.data < data) {
                rank += 1 + size(temp.left);
                temp = temp.right;
            }
            else {
                rank += size(temp.left);
                return rank;
            }
        }

        return -1;
    }
}

public class bstrank {
    public static void main(String[] args) {
            BST tree = new BST();
            int[] arr = {5,4,1,3,2,9,7,8,9,6,0,4};
            for(int i : arr) {
                tree.insert(i);
            }
            Arrays.sort(arr);
            for(int i: arr) {
                System.out.println("Rank of Node: " + i + " : " + tree.getRank(i));
            }
    }


}
