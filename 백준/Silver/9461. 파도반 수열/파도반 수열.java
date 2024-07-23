import java.util.*;
import java.io.*;

public class Main {
	static long[] dp=new long[101];

	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		
		int T=Integer.parseInt(br.readLine());
		dp[1]=1;
		dp[2]=1;
		dp[3]=1;
		dp[4]=2;
		dp[5]=2;
		
		for(int i=0; i<T; i++) {
			sb.append(pdb(Integer.parseInt(br.readLine()))).append("\n");
		}
		
		System.out.println(sb.toString());
		br.close();
	}

	private static long pdb(int a) {
		if(a>=1 && a<=5) {
			return dp[a];
		}
		if(dp[a]!=0) {
			return dp[a];
		}
        dp[a]=pdb(a-1)+pdb(a-5);
		return dp[a];
	}
}