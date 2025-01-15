import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    /*
  N개의 자연수 중 M개를 고른 수열
  비내림차순: 수열 내부 숫자 순서가 오름차순
  중복되는 수열은 한번만 처리
   */
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
        int prev = -1; // 같은 조합을 피하기 위해 전단계에서 선택한 값 같은 depth에서 다시 고르지 않게 처리
        for (int i = start; i < N; i++) {
            if (a[i] == prev) continue;
            b[cnt] = a[i];
            prev = a[i];
            comb(cnt + 1, i + 1, sb);
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