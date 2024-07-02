import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static List<Integer>[] studComp;
	static int[] indegree;
	static StringBuilder sb=new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=null;
		
		//N 노드 수, M 간선 수 
		st=new StringTokenizer(br.readLine()," ");
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		
		//학생 키 받아넣기
		studComp=new List[N+1]; for(int i=1; i<N+1; i++) studComp[i]=new ArrayList<>();
		indegree=new int[N+1];
		for(int i=0; i<M; i++) {
			st=new StringTokenizer(br.readLine()," ");
			int from=Integer.parseInt(st.nextToken());
			int to=Integer.parseInt(st.nextToken());
			studComp[from].add(to);
			indegree[to]++; // 진입 차수
		}
		
		bfs();
		System.out.println(sb);
		br.close();
	}

	static void bfs() {
		ArrayDeque<Integer> q=new ArrayDeque<>();
		for(int i=1; i<N+1; i++) {
			if(indegree[i]==0) q.offer(i); //0인거 찾아 큐에 넣기
		}
		while(!q.isEmpty()) {
			int i=q.poll();
			sb.append(i+" ");
			for (int j:studComp[i]) {
				indegree[j]--;
				if(indegree[j]==0) q.offer(j);
			}
		}
	}
}
