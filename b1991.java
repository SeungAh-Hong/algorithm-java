import java.util.*;
import java.io.*;


class Node {
    char root;
    Node left;
    Node right;

    Node(char root, Node left, Node right) {
        this.root = root;
        this.left = left;
        this.right = right;
    }
}

public class b1991 {
    static StringBuilder sb;
    static Node head = new Node('A', null, null);

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for(int i=1;i<=N;i++){
            st = new StringTokenizer(br.readLine(), " ");
            char root = (st.nextToken()).charAt(0);
            char left = (st.nextToken()).charAt(0);
            char right = (st.nextToken()).charAt(0);

            insertNode(head, root, left, right); // Node 자리만들기 (재귀 이용)
        }

        sb = new StringBuilder();
        preorder(head);
        sb.append('\n');

        inorder(head);
        sb.append('\n');

        postorder(head);
        System.out.println(sb);
    }
    private static void insertNode(Node parent, char root, char left, char right) {
        if (parent.root == root) {
            if(left != '.') {
                parent.left = new Node(left, null, null);
            }
            if(right != '.') {
                parent.right = new Node(right, null, null);
            }
        }
        else {
            if(parent.left != null) {
                insertNode(parent.left, root, left, right);
            }
            if(parent.right != null) {
                insertNode(parent.right, root, left, right);
            }
        }
    }

    private static void preorder(Node node) {
        if(node == null) return;

        sb.append(node.root);
        preorder(node.left);
        preorder(node.right);
    }
    private static void inorder(Node node) {
        if(node == null) return;

        inorder(node.left);
        sb.append(node.root);
        inorder(node.right);
    }
    private static void postorder(Node node) {
        if(node == null) return;

        postorder(node.left);
        postorder(node.right);
        sb.append(node.root);
    }
}