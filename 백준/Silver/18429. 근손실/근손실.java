import java.io.*;
import java.util.*;

/*
순열 문제
중간에 중량 500 미만일 경우 필터링 필요
 */

class Main {
    static int N; // N 개중 길이 N의 순열 찾기
    static int K; // 매일 중량이 K만큼 감소
    static boolean[] v;
    static int[] kit, res; // kit 번호들 각 순열 산출물 -> res
    static int ans;

    static void perm(int cnt, int power) {
        if(cnt == N) {
            ans++;
            return;
        }
        for (int i = 1; i <= N; i++) {
            if(v[i]) continue;
            if((power+kit[i] - K) < 500) continue;
            v[i] = true;
            res[i] = i;
            perm(cnt+1, power+kit[i] - K);
            v[i] = false;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        kit = new int[N+1];

        for (int i = 1; i <= N; i++) {
            kit[i] = Integer.parseInt(st.nextToken());
        }
        v = new boolean[N+1];
        res = new int[N+1];

        perm(0, 500);
        System.out.println(ans);
    }
}