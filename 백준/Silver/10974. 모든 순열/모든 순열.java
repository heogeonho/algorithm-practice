import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main {
    static int N, M;
    static int[] a, b;
    static boolean[] v;


    static void perm(int cnt, StringBuilder sb) {
        if (cnt == M) {
            for (int i = 0; i < M; i++) {
                sb.append(b[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            if (v[i]) continue;
            v[i] = true;
            b[cnt] = a[i];
            perm(cnt + 1, sb);
            v[i] = false;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        M = N;
        a = new int[N];
        b = new int[M];
        v = new boolean[N];
        for (int i = 0; i < N; i++) {
            a[i] = i + 1;
        }

        perm(0, sb);
        System.out.println(sb);
    }
}