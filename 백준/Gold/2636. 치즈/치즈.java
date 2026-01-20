import java.io.*;
import java.util.*;

class Main {

    static int N, M;
    static int[][] map;
    static boolean[][] v;

    static final int[] di = {-1, 0, 1, 0};
    static final int[] dj = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        /* 
        외부의 한 덩어리를 측정하기?
        외부공간을 BFS
        테두리 처리가 고민
        -> 치즈를 만나면 해당 위치 식별 처리

        개수만 출력하면 됨
        
        ---
        
        테두리에 대해 bfs 진행되는 동안 위치 보관 로직
        위치 정보를 기반으로 녹이는 로직
        
        두 로직에 대한 분리가 인상깊었던 문제
        */ 

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());


        map = new int[N][M];
        int cheese = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) cheese++;
            }
        }

        int time = 0;
        int last = 0;

        while (cheese > 0) {
            v = new boolean[N][M];
            int melted = bfs();
            last = melted;
            cheese -= melted;
            time++;
        }

        System.out.println(time);
        System.out.println(last);
        
    }

    public static int bfs() {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        List<int[]> melt = new ArrayList<>();

        v[0][0] = true;
        q.add(new int[] {0,0});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int ci = cur[0];
            int cj = cur[1];

            for(int d = 0; d < 4; d++) {
                int ni = ci + di[d];
                int nj = cj + dj[d];

                if (0<=ni&&ni<N && 0<=nj&&nj<M && !v[ni][nj]) {
                    v[ni][nj] = true;
                    if(map[ni][nj] == 0) {
                        q.add(new int[] {ni, nj});
                    } else {
                        melt.add(new int[] {ni,nj});
                    }
                }
            }
        }

        for(int[] i : melt) {
            map[i[0]][i[1]] = 0;
        }
        return melt.size();
    }
}