import java.io.*;
import java.util.*;

class Main {
    
    static int n;
    static List<Integer>[] network;
    static boolean[] v;
    
    static int vsCnt = 0; // 바이러스 확산 cnt 변수
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        n = Integer.parseInt(br.readLine());
        
        // 노드별 방문 여부 배열
        v = new boolean[n+1];
        
        // 네트워크 그래프 생성
        network = new List[n+1];
        for(int i = 0; i <= n; i++) network[i] = new ArrayList<>();

        // 그래프 값 입력 (양방향 그래프)
        int connect = Integer.parseInt(br.readLine());
        while (connect-- > 0) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            network[node1].add(node2);
            network[node2].add(node1);
        }
        dfs(1);

        System.out.println(vsCnt);
    }
    
    // dfs 탐색
    static void dfs(int i) {
        v[i] = true;
        for(int node : network[i]) {
            if(!v[node]) {
                vsCnt++;
                dfs(node);
            }
        }
    }
}