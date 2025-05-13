import java.io.*;
import java.util.*;
/*
처음에 그리디로 풀었다가 처참하게 틀렸음 -> 항상 가장 큰 제곱수가 최적의 해가 아닐 수 있음

dp 메모이제이션 활용해서 푸는 것이 해답
점화식: dp[i] = min(dp[i - (j*j)]) + 1;
유형상 바텀업으로 풀어야 할 것 같음
*/
class Main {
    static int[] dp = new int[50001]; // 1-based dp 배열
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        // 초기화 및 바텀업 메모이제이션
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = min(i) + 1;
        }
        
        System.out.println(dp[n]);
    }
    
    // min(dp[i - (j*j)])
    static int min(int n) {
        int res = Integer.MAX_VALUE;
        for(int i = 1; i * i <= n; i++) {
            res = Math.min(dp[n-(i*i)], res);
        }
        return res;
    }
}