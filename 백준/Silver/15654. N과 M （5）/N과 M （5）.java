import java.io.*;
import java.util.*;

public class Main {
	static int N, M; // N개의 수 M개 고르기
	static int[] a, b; // N개 자연수 담을 배열 a, 결과 담을 배열 b 
	static boolean[] v;
	
	static StringBuilder sb=new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=null;
		st=new StringTokenizer(br.readLine(), " ");
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		a=new int[N];		
		v=new boolean[N];		
		
		b=new int[M];
		
		st=new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++) {
			a[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(a);
        
		perm(0);
		
		System.out.println(sb.toString());
		br.close();
	}
	
	static void perm(int cnt) {
		if(cnt==M) {
			for(int n:b) sb.append(n).append(" ");
			sb.append("\n");
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(v[i]) continue;
			v[i]=true;
			b[cnt]=a[i];
			perm(cnt+1);
			v[i]=false;
		}
	}
}
