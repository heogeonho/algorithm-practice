import java.util.*;
import java.io.*;

public class Main {
	static int N, M, V;
	static List<Integer>[] g;
	static boolean[] v;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=null;
		
		st=new StringTokenizer(br.readLine()," ");
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		V=Integer.parseInt(st.nextToken());
		
		g=new List[N+1]; for(int i=0; i<N+1; i++) g[i]=new ArrayList<>();
		
		for(int i=0; i<M; i++) {
			st=new StringTokenizer(br.readLine()," ");
			int from=Integer.parseInt(st.nextToken());
			int to=Integer.parseInt(st.nextToken());
			g[from].add(to);
			g[to].add(from);
		}
		
		v=new boolean[N+1];
		dfs(V);
		System.out.println();
		v=new boolean[N+1];
		bfs(V);
		br.close();
	}

	private static void bfs(int i) {
		ArrayDeque<Integer> q=new ArrayDeque<>();
		v[i]=true;
		q.offer(i);
		while(!q.isEmpty()) {
			i=q.poll();
			System.out.print(i+" ");
			Collections.sort(g[i]);
			for(int j:g[i]) {
				if(!v[j]) {
					v[j]=true;
					q.offer(j);
				}
			}
		}
	}

	private static void dfs(int i) {
		v[i]=true;
		System.out.print(i+" ");
		Collections.sort(g[i]);
		for(int j:g[i]) {
			if(!v[j]) {
				dfs(j);
			}
		}
	}
}