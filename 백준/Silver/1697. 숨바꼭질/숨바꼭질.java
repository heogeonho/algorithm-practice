import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main{

    /*
    수빈이 위치 N
    동생 위치 K (목적지)

    수빈이 이동 루트 (단위 1초)
    case1: X-1, X+1
    case2: 2*X

    BFS 활용 -> 가장 먼저 K 찾는 루트의 거리 출력
    큐에 들어가는 것 (위치정보?)
    방문처리 해줘서 더 큰 수 안들어가도록 처리

    static move = {1,-1,2}
    static int[] map = int[100000]

    BFS(N)

    BFS(int N) {
        q
        q.offer(N)
        while (!q.isEmpty) {
            i=q.pull()
            for(move.length()) {
                방문x -> 값 처리
                if k 면 break?
            }
        }
    }
     */
    static int len = 100001;
    static int[] map = new int[len];
    static boolean[] v = new boolean[len];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        System.out.println(bfs(N, K));
    }

    static int bfs(int N, int K) {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        v[N] = true;
        map[N] = 0;
        q.offer(N);
        while (!q.isEmpty()) {
            int i = q.poll();

            if ((i + 1) <= len - 1 && !v[i + 1]) {
                v[i + 1] = true;
                q.offer(i + 1);
                map[i + 1] = map[i] + 1;
                if (i + 1 == K) {
                    return map[i + 1];
                }
            }
            if ((i - 1) >= 0 && !v[i - 1]) {
                v[i - 1] = true;
                map[i - 1] = map[i] + 1;
                q.offer(i - 1);
                if (i - 1 == K) {
                    return map[i - 1];
                }
            }
            if ((2 * i) <= len - 1 && !v[2 * i]) {
                v[2 * i] = true;
                map[2 * i] = map[i] + 1;
                q.offer(2 * i);
                if (2 * i == K) {
                    return map[2 * i];
                }
            }
        }

        return 0;
    }
}