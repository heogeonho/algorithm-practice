import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] a, b;

    static void comb(int cnt, int start, StringBuilder sb) {
        if (cnt == M) {
            for (int i = 0; i < M; i++) {
                sb.append(b[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        int prev = -1;
        for (int i = start; i < N; i++) {
            if (a[i] == prev) continue;
            b[cnt] = a[i];
            prev = a[i];  // 이전 값 갱신
            comb(cnt + 1, i, sb);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        a = new int[N];
        b = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(a);
        comb(0, 0, sb);
        System.out.println(sb);
        br.close();

    }
}
