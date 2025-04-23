import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 전체 날짜 수 (2 <= N <= 100,000)
        int K = Integer.parseInt(st.nextToken()); // 합 구하기 연속 날짜 수

        // 반복해서 구간합을 구해야 하기 때문에 prefix sum 활용
        int[] pSum = new int[N];

        st = new StringTokenizer(br.readLine());
        pSum[0] = Integer.parseInt(st.nextToken());
        for (int i = 1; i < N; i++) {
            pSum[i] = pSum[i-1] + Integer.parseInt(st.nextToken());
        }

        // 슬라이딩 윈도우를 통해 순회 및 max 값 산출
        int left = 1;
        int right = K-1;
        int max = pSum[right];
        right++;
        while(right < N) {
            max = Math.max(max, pSum[right] - pSum[left-1]);
            left++;
            right++;
        }

        System.out.println(max);
    }
}