import java.util.*;
import java.io.*;

public class Main {
	static int N, M, k;
	static int[] group, money;

	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=null;
		
		st=new StringTokenizer(br.readLine()," ");
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		k=Integer.parseInt(st.nextToken());
		
		group=new int[N+1];
		for(int i=1; i<=N; i++) group[i]=i;
		
		money=new int[N+1];
		//학생은 1번부터 있다고 생각 인덱스 자리의 돈 = 그 학생의 친구비
		st=new StringTokenizer(br.readLine()," ");
		for(int i=1; i<=N; i++) {
			money[i]=Integer.parseInt(st.nextToken());
		}
		


		// 친구 그룹 union으로 생성 & 값의 비교 작은수만 남기기
		for(int i=0; i<M; i++) {
			st=new StringTokenizer(br.readLine()," ");
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			union(a,b);

		}
		
		int ans=0;
		HashSet<Integer> set=new HashSet<>();
		for(int g:group) set.add(find(g));
		for(int m:set) ans+=money[m];
		
		if(k>=ans) System.out.println(ans);
		else System.out.println("Oh no");		
		br.close();
	}

	static boolean union(int a, int b) {
		int aRoot=find(a);
		int bRoot=find(b);
		if(aRoot==bRoot) return false;
		if(money[aRoot]<money[bRoot]) {			
			group[bRoot]=aRoot;
		} else {
			group[aRoot]=bRoot;			
		}
		return true;
	}

	static int find(int x) {
		if(group[x]==x) return x;
		return group[x]=find(group[x]);
	}
}
