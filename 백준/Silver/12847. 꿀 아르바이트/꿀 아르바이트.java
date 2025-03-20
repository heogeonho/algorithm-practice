import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 누적합 배열 선언
        long[] prefixSum = new long[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            prefixSum[i] = prefixSum[i - 1] + Integer.parseInt(st.nextToken());
        }

        long max = 0;
        // 슬라이딩 윈도우?
        for (int i = m; i <= n; i++) {
            max = Math.max(max, prefixSum[i] - prefixSum[i - m]);
        }

        System.out.println(max);
    }
}