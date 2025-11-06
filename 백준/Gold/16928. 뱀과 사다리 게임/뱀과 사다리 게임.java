import java.io.*;
import java.util.*;

class Main {

    // 단방향 노드
    // BFS 활용

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Integer>[] node = new ArrayList[101];
        for(int i = 1; i <= 100; i++) {
            node[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            node[x].add(y);
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            node[u].add(v);
        }

        boolean[] v = new boolean[101];
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {1, 0});
        v[1] = true;
        while (!q.isEmpty()) {
            int[] curr = q.poll();

            for (int i = 1; i <= 6; i++) {
                int next = curr[0]+i;
                if(next>100) continue;
                if(!node[next].isEmpty()) next = node[next].get(0);
                
                if(!v[next]) {
                    v[next] = true;
                    if(next==100) {
                        System.out.println(curr[1]+1);
                        break;
                    }
                    q.offer(new int[] {next, curr[1]+1});
                }
            }
        }
    }
}