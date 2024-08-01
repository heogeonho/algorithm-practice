import java.util.*;
import java.io.*;

public class Main {
	
	static StringBuilder sb=new StringBuilder();
	static int Cnt=0;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	
		int N=Integer.parseInt(br.readLine());
		
		Cnt=0;
		hanoi(N,1,3,2);
		
		System.out.println(Cnt);
		System.out.print(sb.toString());
		br.close();
	}

	static void hanoi(int n, int start, int to, int via) {
		if(n==1) {
			move(1, start, to);
		}
		
		else {
			hanoi(n-1, start, via, to);
			move(1, start, to);
			hanoi(n-1, via, to, start);
		}
	}

	static void move(int i, int start, int to) {
		Cnt++;
		sb.append(start).append(" ").append(to).append("\n");
	}
}