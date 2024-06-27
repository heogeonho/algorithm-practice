import java.io.*;
import java.util.*;

public class Main {
	
	static class Node{
		char value;
		Node left;
		Node right;
		
		Node(char value, Node left, Node right) {
			this.value=value;
			this.left=left;
			this.right=right;
		}
	}

	static void insertNode(Node node, char mid, char left, char right){
		if (node.value==mid) {
			node.left=(left=='.' ? null : new Node(left, null, null));
			node.right=(right=='.' ? null : new Node(right, null, null));
		} else {
			if(node.left != null) insertNode(node.left, mid, left, right);
			if(node.right != null) insertNode(node.right, mid, left, right);
		}
	}
	
	public static void preOrder(Node node) {
		if(node ==null) return;
		System.out.print(node.value);
		preOrder(node.left);
		preOrder(node.right);
	}
	
	public static void inOrder(Node node) {
		if(node ==null) return;
		inOrder(node.left);
		System.out.print(node.value);
		inOrder(node.right);
	}
	
	public static void postOrder(Node node) {
		if(node ==null) return;
		postOrder(node.left);
		postOrder(node.right);
		System.out.print(node.value);
	}
	
	static int N;
	static Node head=new Node('A', null, null);

	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=null;
		StringBuilder sb=new StringBuilder();
		
		N=Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			st=new StringTokenizer(br.readLine()," ");
			
			char mid=st.nextToken().charAt(0);
			char left=st.nextToken().charAt(0);
			char right=st.nextToken().charAt(0);
			
			insertNode(head, mid, left, right);
		}
		preOrder(head);
		System.out.println();
		inOrder(head);
		System.out.println();
		postOrder(head);
		System.out.println();
		br.close();
	}
}