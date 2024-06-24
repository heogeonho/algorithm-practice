import java.util.*;
import java.io.*;

public class Main{
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int K=Integer.parseInt(br.readLine());
		ArrayDeque<Integer> stack = new ArrayDeque<>();
		for(int i =0;i<K;i++) {
			int num=Integer.parseInt(br.readLine());
			if(num!=0) {
				stack.push(num);
			} else {
				stack.pop();
			}			
		}
		
		int result=0;
		while (!stack.isEmpty()) {
			result += stack.pop();
		}
		System.out.println(result);
	}
}
