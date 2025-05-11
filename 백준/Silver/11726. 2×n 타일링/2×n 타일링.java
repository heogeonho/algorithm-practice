import java.io.*;
import java.util.*;

/*
탑다운 방식을 활용하여 dp 문제 풀어보기
점화식: dp(n-1) + dp(n-2) = dp(n)
*/

class Main {
    static int[] dp = new int[10001]; // 메모이제이션을 위한 1-based arr
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp[1] = 1;
        dp[2] = 2;  
        System.out.println(sol(n));
    }

    // 재귀 함수를 활용해 top-down 형식으로 해 찾기
    static int sol(int n) {
        if(dp[n]!=0) return dp[n];
        return dp[n] = (sol(n-1) + sol(n-2)) % 10007;
    }
}