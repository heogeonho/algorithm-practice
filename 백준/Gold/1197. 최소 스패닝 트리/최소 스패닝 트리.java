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
		//    정점 i -> 정점 j (비용 c) 
        //  & 정점 j -> 정점 i (비용 c)
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
		
		boolean[] v=new boolean[N+1]; //방문처리
		int[] w=new int[N+1];         //각 정점에서 각 정점으로 가는 가중치
		for(int i=1; i<=N; i++) w[i]=Integer.MAX_VALUE/2;
		
        PriorityQueue<int[]> pq=new PriorityQueue<>((o1,o2)->Integer.compare(o1[1],o2[1]));
		int sum=0, cnt=0;
		w[1]=0;  // 정점 1에서 시작하려고 함
        pq.offer(new int[] {1,0});
        while(!pq.isEmpty()) {
            int[] vw=pq.poll();
            int min=vw[1];
            int minVertex=vw[0];
            if(v[minVertex]) continue;

            v[minVertex]=true;			// 방문 처리
			sum+=min;					// MST cost sum 누적을 위함
			if(cnt++==N) break; 
			// 갱신 과정
			for(int[] j:g[minVertex]) { // 아까 최소 cost를 가진 정점으로 방문
				if(!v[j[0]] && w[j[0]]>j[1]) {
							   w[j[0]]=j[1]; // 갱신
			                   pq.offer(j);
                }
			}
		}
		System.out.println(sum);
		br.close();
	}
}