import java.util.*;
import java.io.*;

public class Main {
	static int N, cnt=0;
	static List<Integer>[] network;
	static boolean[] v;

	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=null;
		
		N=Integer.parseInt(br.readLine());
		int E=Integer.parseInt(br.readLine());
		
		network=new List[N+1]; for(int i=1; i<N+1; i++) network[i]=new ArrayList<>();
		v=new boolean[N+1];
		
		for(int i=0; i<E; i++) {
			st=new StringTokenizer(br.readLine()," ");
			int from=Integer.parseInt(st.nextToken());
			int to=Integer.parseInt(st.nextToken());
			network[from].add(to);
			network[to].add(from);
		}
		
//		dfs(1);
		bfs(1);
		System.out.println(cnt);
		br.close();
	}

	private static void bfs(int i) {
		ArrayDeque<Integer> q=new ArrayDeque<>();
		v[i]=true;
		q.offer(i);
		while(!q.isEmpty()) {
			i=q.poll();
			for(int j:network[i]) {
				if(!v[j]) {
					cnt++;
					v[j]=true;
					q.offer(j);
				}
			}
		}
		
	}

	private static void dfs(int i) {
		v[i]=true;
		for(int j:network[i]) {
			if(!v[j]) {
				cnt++;
				dfs(j);
			}
		}
	}

}
