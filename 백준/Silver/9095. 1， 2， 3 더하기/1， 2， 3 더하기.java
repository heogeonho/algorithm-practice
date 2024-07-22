/*
다이나믹 프로그램 점화식 찾기
1, 2, 3을 더해서 결과를 찾는 문제인데 나는 각 숫자를 따로보고 점화식을 세웠다.
dp[] 배열을 선언하고
1,2,3의 값만 직접 넣어주었고
이후 값들은 점화식 계산에 따라 넣어주었다.
*/

import java.util.*;
import java.io.*;

public class Main {
	static int[] dp=new int[11];

	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		
		int T=Integer.parseInt(br.readLine());
		
		dp[1]=1;
		dp[2]=2;
		dp[3]=4;
		
		for(int i=0; i<T; i++) {
			int n=Integer.parseInt(br.readLine());
			sb.append(solution(n)).append("\n");
		}
		
		System.out.println(sb.toString());
		br.close();
	}

	static int solution(int n) {
		int res=dp[n];
		if(n==1) return res;
		else if(n==2) return res;
		else if(n==3) return res;
		
		if(dp[n] != 0) return res;
		
		return solution(n-1)+solution(n-2)+solution(n-3);
	}
}
