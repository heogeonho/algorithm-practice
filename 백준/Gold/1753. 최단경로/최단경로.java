import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception{
		//정점의 수 V, 간선의 수 E 시작 정점의 번호 K
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=null;
		StringBuilder sb=new StringBuilder();
		
		st=new StringTokenizer(br.readLine()," ");
		int V=Integer.parseInt(st.nextToken());
		int E=Integer.parseInt(st.nextToken());
		
		int K=Integer.parseInt(br.readLine())-1; // 0부터 계산하기 위해 입력마다 1 빼주기 *
		
		List<int[]>[] g=new List[V]; 
		for(int i=0; i<V; i++) g[i]=new ArrayList<>();
		for(int i=0; i<E; i++) {
			st=new StringTokenizer(br.readLine()," ");
			int u=Integer.parseInt(st.nextToken())-1;
			int v=Integer.parseInt(st.nextToken())-1;
			int w=Integer.parseInt(st.nextToken());
			g[u].add(new int[] {v, w});
		}
		
		boolean[] v=new boolean[V];
		int[] d=new int[V];
		for(int i=0; i<V; i++) d[i]=Integer.MAX_VALUE;
		d[K]=0;

		for(int i=0; i<V; i++) {
			int min=Integer.MAX_VALUE;
			int minVertex=-1;
			for(int j=0; j<V; j++) {
				if(!v[j] && min>d[j]) {
							min=d[j];
							minVertex=j;
				}
			}
			if(minVertex==-1) {
				break;
			} 
			v[minVertex]=true;				
		
			for(int[] j: g[minVertex]) {
				if(!v[j[0]] && d[j[0]]>min+j[1]) {
							   d[j[0]]=min+j[1];
				}
			}

		}
		
		for (int i:d) {
			if(i==Integer.MAX_VALUE) {
				sb.append("INF\n");
			} else {				
				sb.append(i+"\n");
			}
		}
		System.out.println(sb);
		br.close();
	}
}