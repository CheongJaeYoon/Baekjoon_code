import java.util.*;
import java.io.*;
import java.lang.Math;

public class Main{
    static class Node {
        char name;
        Node left, right;

        Node(char name){
            this.name = name;
        }
    }
    static int n;
    static Node[] arr;
    static StringBuilder sb = new StringBuilder("");
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        arr = new Node[n];
        Node root;
        for(int i = 0; i < n; i++){
            arr[i] = new Node((char)('A' + i));
        }

        for(int i = 0; i < n; i++){
            String str= br.readLine();
            char node = str.charAt(0); 
            char left = str.charAt(2);
            char right = str.charAt(4);
            if(left != '.'){
                arr[node-'A'].left = arr[left-'A'];
            }
            if(right != '.'){
                arr[node-'A'].right = arr[right-'A'];
            }
        }
        
        // 전위 순회
        preOrder(arr[0]);
        sb.append("\n");
        // 중위 순회
        inOrder(arr[0]);
        sb.append("\n");
        // 후위 순회
        postOrder(arr[0]);

        System.out.println(sb);
    }

    static void preOrder(Node node) {
        sb.append(node.name);
        if (node.left != null) preOrder(node.left);
        if (node.right != null) preOrder(node.right);
    }

    static void inOrder(Node node) {
        if (node.left != null) inOrder(node.left);
        sb.append(node.name);
        if (node.right != null) inOrder(node.right);
    }

    static void postOrder(Node node) {
        if (node.left != null) postOrder(node.left);
        if (node.right != null) postOrder(node.right);
        sb.append(node.name);
    }
}