import java.util.*;
import java.io.*;

public class Main{
	static int N,M;
	static int[] a, b;
	static StringBuilder sb=new StringBuilder();
	
	static void comb(int cnt, int start) {
		if(cnt==M) {
			for(int i:b) sb.append(i+" ");
			sb.append("\n");
			return;
		}
		for(int i=start; i<N; i++) {
			b[cnt]=a[i];
			comb(cnt+1,i+1);
		}
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		
		a=new int[N];
		for (int i = 0; i < N; i++) {
			a[i]=i+1;
		}
		
		b=new int[M];
		comb(0,0);
		System.out.println(sb.toString());
		br.close();
	}
}
