import java.util.*;
import java.io.*;

public class Main{
	static int N, M, K=3;
	static int[] a, b;
	static int sum=0;
		
	private static void play(int cnt, int start) {
		if(cnt==K) {
			int temp = Arrays.stream(b).sum();
			if(temp<=M && temp>sum) {
				sum=temp;
				return;
			}
			return;
		}
		for (int i = start; i < N; i++) {
			b[cnt]=a[i];
			play(cnt+1, i+1);
		}
	}	

	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		a=new int[N];
		st=new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			a[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(a);
//		System.out.println(Arrays.toString(a));
		b=new int[K];
		play(0, 0);
		System.out.println(sum);
	}
}
