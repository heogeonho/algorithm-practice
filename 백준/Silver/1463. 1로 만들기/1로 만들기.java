import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        /*
        1. X가 3으로 나누어 떨어지면, 3으로 나눈다.
        2. X가 2로 나누어 떨어지면, 2로 나눈다.
        3. 1을 뺀다.
        바텀업 방식으로 최소값 찾아 넣기가 제일 좋아보인다.
        */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+1];
        dp[0] = dp[1] = 0;

        // 바텀업 방식으로 3가지 방안 비교 및 삽입
        for (int i = 2; i <= N; i++) {
            int minValue = dp[i-1]+1;
            if(i%2==0) minValue = Math.min(minValue, dp[i/2]+1);
            if(i%3==0) minValue = Math.min(minValue, dp[i/3]+1);
            dp[i] = minValue;
        }
        System.out.println(dp[N]);
        
    }
}
        /*
        <개선 전 풀이>
        else if (N>=4) {
            dp[2] = 1;
            dp[3] = 1;
            for(int i = 4; i <= N; i++) {
                if(i%3 == 0) dp[i] = dp[i/3]+1;
                if(i%2 == 0) {
                    if(dp[i]!=0) dp[i] = Math.min(dp[i/2]+1, dp[i]);
                    else dp[i] = dp[i/2]+1;
                }
                if(dp[i]!=0) dp[i] = Math.min(dp[i-1]+1,dp[i]);
                else dp[i] = dp[i-1]+1;
            }
            System.out.println(dp[N]);
        }
         */