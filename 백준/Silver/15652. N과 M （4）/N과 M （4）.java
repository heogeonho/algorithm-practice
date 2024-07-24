import java.io.*;
import java.util.*;

public class Main {
	static int N, M; // N개의 수 M개 고르기
	static int[] a, b; // N개 자연수 담을 배열 a, 결과 담을 배열 b 
	// 중복 허용이니까 방문 판별은 x
	
	static StringBuilder sb=new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine(), " ");
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		a=new int[N];		
		b=new int[M];
		for(int i=0; i<N; i++) {
			a[i]=i+1;
		}
		
		comb(0, 0);
		
		System.out.println(sb.toString());
		br.close();
	}
	static void comb(int cnt, int start) {  // 조합에서는 start값을 줘야한다!
		if(cnt==M) {
			for(int n:b) sb.append(n).append(" ");
			sb.append("\n");
			return;
		}
		
		for(int i=start; i<N; i++) {
			b[cnt]=a[i];
			comb(cnt+1, i);
		}
	}
}