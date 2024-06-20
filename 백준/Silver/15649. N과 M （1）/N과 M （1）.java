import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static int[] a;
	static int[] b;
	static boolean[] v;

	private static void perm(int cnt) {
		StringBuilder sb=new StringBuilder();
		if(cnt==M) {
			for(int i:b) sb.append(i+" ");
			System.out.println(sb);
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
	
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		
		a=new int[N];
		for (int i = 1; i <= N; i++) {
			a[i-1]=i;
		}
		
		b=new int[M];
		v=new boolean[N];
		perm(0);
//		System.out.println(Arrays.toString(a));
		
		br.close();
	}
}