import java.util.*;
import java.io.*;

/*
서로 연결된 그룹이 몇개인지?
그래프 탐색
 */

public class Main {

    static boolean[] v;
    static List<Integer>[] graph;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st=new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph=new List [N+1]; // index 0은 제외
        for(int i=0; i<=N; i++) graph[i]=new ArrayList<>();
        v=new boolean[N+1];

        for(int i=1; i<=M; i++) {
            st=new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph[from].add(to);
            graph[to].add(from);
        }

        int cnt=0;
        for(int i = 1; i<= N; i++) {
            if(!v[i]) {
                dfs(i);
                cnt+=1;
            }
        }
        System.out.println(cnt);
    }

    static void dfs(int i) {
        v[i]=true;
        for(int j:graph[i]){
            if(!v[j]) dfs(j);
        }
    }
}
