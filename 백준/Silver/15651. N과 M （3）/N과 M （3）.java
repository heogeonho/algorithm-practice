import java.io.*;
import java.util.*;

class Main {
    static int N, M; // N 개중 길이 M의 순열 찾기
    static int[] a, res; 
    static StringBuilder sb;

    static void perm(int cnt) {
        if(cnt == M) {
            for(int i : res) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 0; i < N; i++) {
            res[cnt] = a[i];
            perm(cnt+1);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = i+1;
        }
        res = new int[M];

        sb = new StringBuilder();
        perm(0);
        System.out.println(sb.toString());    
    }
}