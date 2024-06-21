import java.util.*;
import java.io.*;

public class Main {
	static int N=9, M=7;
	static int[] a, b;
	static int sum=0;

	private static void comb(int cnt, int start) {
		if(cnt==M) {
			int temp = Arrays.stream(b).sum();
			if (temp==100) {
				for(int i:b) System.out.println(i);
				return;
			}
			return;
		}
		for (int i = start; i < N; i++) {
			b[cnt]=a[i];
			comb(cnt+1, i+1);
		}
	}	

	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		a=new int[N];
		for (int i = 0; i < N; i++) {
			a[i]=Integer.parseInt(br.readLine());
		}
		b=new int[M];
		comb(0, 0);
	}
}