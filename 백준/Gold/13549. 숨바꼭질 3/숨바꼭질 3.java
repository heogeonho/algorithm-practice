import java.io.*;
import java.util.*;

class Main {
    static int N; // 수빈 현재 위치
    static int K; // 동생 현재 위치
    static boolean[] v = new boolean[100001];
    static final int[] di = {-1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        bfs(N);
    }

    static void bfs(int start){
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {start, 0});
        v[start] = true;

        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int x = curr[0];
            int depth = curr[1];

            if(x == K) {
                System.out.println(depth);
                break;
            }

            if(x * 2 <= 100000 && !v[x * 2]) {
                v[x * 2] = true;
                q.offerFirst(new int[] {x * 2, depth});
            }

            if(0<=x-1 && !v[x-1]) {
                v[x-1] = true;
                q.offer(new int[] {x-1, depth+1});
            }

            if(x+1<=100000 && !v[x+1]) {
                v[x+1] = true;
                q.offer(new int[] {x+1, depth+1});
            }
        }
    }
}