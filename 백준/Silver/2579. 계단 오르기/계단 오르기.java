import java.io.*;
import java.util.*;

public class Main {
	static int[] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int N=Integer.parseInt(br.readLine());
		dp=new int[N+1];
		int[] input=new int[N+1];
		for(int i=1; i<=N; i++) {
			input[i]=Integer.parseInt(br.readLine());
		}
		
		// 1
		dp[1]=input[1];
		
		// 2
		if(N>=2) {			
			dp[2]=dp[1]+input[2];
		}
		
		// 3부터 바텀 업
		for(int i=3; i<=N; i++) {
			dp[i]=Math.max(dp[i-2], dp[i-3]+input[i-1])+input[i];
		}
		
		System.out.println(dp[N]);
		br.close();
	}
}