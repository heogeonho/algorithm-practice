import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=null;
		
		st=new StringTokenizer(br.readLine()," ");
		int N=Integer.parseInt(st.nextToken());
		int E=Integer.parseInt(st.nextToken());
		
		List<int[]>[] g=new List[N+1]; for(int i=0; i<=N; i++) g[i]=new ArrayList<>();
		//i 번 정점에서 j 로~ 비용 c
		for(int k=0; k<E; k++) {
			st=new StringTokenizer(br.readLine()," ");
			int i=Integer.parseInt(st.nextToken());
			int j=Integer.parseInt(st.nextToken());
			int c=Integer.parseInt(st.nextToken());
			if(c!=0) {
				g[i].add(new int[] {j,c});
				g[j].add(new int[] {i,c});
			}			
		}
		
		boolean[] v=new boolean[N+1];
		int[] w=new int[N+1];
		for(int i=0; i<N; i++) w[i]=Integer.MAX_VALUE/2;
		
		int sum=0, cnt=0;
		w[0]=0;
		for(int i=0; i<=N; i++) {
			int min=Integer.MAX_VALUE;
			int minVertex=-1;
			for(int j=0; j<N+1; j++) {
				if(!v[j] && min>w[j]) { //최소가중치 메모이제이션
							min=w[j];
							minVertex=j;		// 몇번 정점이냐도 찾아야 한다.
				}
			}
			//step2
			v[minVertex]=true;			// 방문 처리
			sum+=min;					// MST에 누적 시키는~
			if(cnt++==N) break;		//++은 저기에 넣어야해 아직 간선을 연결한게 아니에여 
			// 갱신하러 가
			for(int[] j:g[minVertex]) {
				if(!v[j[0]] && w[j[0]]>j[1]) {
							   w[j[0]]=j[1]; //갱신!
				}
			}
		}
		System.out.println(sum);
		br.close();
	}
}