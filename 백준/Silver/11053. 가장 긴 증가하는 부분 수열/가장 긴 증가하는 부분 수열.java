import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        /*
        가장 긴 증가하는 부분 수열
        -> DP 바텀 업?
        
        dp[N]
        for int i 0~N
            for int j 0~i
                if A[i]>A[j]
                    dp[i]=(dp[j]+1, dp[i]) 중 큰수
                    res=max(res, dp[i])
         */
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        // input data: N (수열의 길이), A (수열)
        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int result = 1;
        int[] dp = new int[N];
        for (int i = 0; i < N; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (A[i] > A[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                    result = Math.max(result, dp[i]);
                }
            }
        }
        System.out.println(result);
    }
}