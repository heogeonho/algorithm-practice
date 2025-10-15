import java.io.*;
import java.util.*;

public class Main {
    static int N, d, k, c;
    static int[] sushi;
    static int[] freq;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        sushi = new int[N];
        for (int i = 0; i < N; i++) sushi[i] = Integer.parseInt(br.readLine());

        System.out.println(solve());
    }

    static int solve() {
        freq = new int[d + 1];
        int distinct = 0;

        // 초기 윈도우 [0, k)
        for (int i = 0; i < k; i++) {
            if (freq[sushi[i]]++ == 0) distinct++;
        }
        int max = distinct + (freq[c] == 0 ? 1 : 0);

        // 슬라이딩 N-1번 (원형이므로 N번 갱신하면 모든 시작점 커버)
        for (int start = 1; start < N; start++) {
            int out = sushi[start - 1];
            if (--freq[out] == 0) distinct--;
            int in = sushi[(start + k - 1) % N];
            if (freq[in]++ == 0) distinct++;

            int cur = distinct + (freq[c] == 0 ? 1 : 0);
            if (cur > max) max = cur;
        }
        return max;
    }
}