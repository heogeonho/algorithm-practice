import java.util.*;
import java.io.*;
/*
DP 알고리즘에 대한 이해 첫걸음
점화식 구하는 방식에 대한 고민 -> 블럭의 길이에 따라 점화식 세우기 접근 등등
추가적으로 %10007을 해주는 이유와 오버플로우에 대한 고려를 해보는 계기가 된 문제
 */
public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[] dp=new int[n+4];
		
		dp[0]=0;
		dp[1]=1;
		dp[2]=3;
		
		for(int i=3; i<=n; i++) {
			dp[i]=(dp[i-1]+(dp[i-2]*2))%10007;
		}
		
		System.out.println(dp[n]);
	}
}