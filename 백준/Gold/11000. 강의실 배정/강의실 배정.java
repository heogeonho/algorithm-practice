import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=null;
		
		int N=Integer.parseInt(br.readLine());
		// 강의실이 미배정된 강의가 저장된 int 배열 a
		int[][] a=new int[N][2];
		for (int i=0; i<N; i++) {
			st=new StringTokenizer(br.readLine()," ");
			a[i][0]=Integer.parseInt(st.nextToken()); // S
			a[i][1]=Integer.parseInt(st.nextToken()); // T
		}
//		for(int[] al:a) System.out.print(Arrays.toString(al)+" "); System.out.println();

		//빠른 강의부터 집어넣기 위해 sort
		Arrays.sort(a, (o1, o2)->{
			int res=Integer.compare(o1[0], o2[0]);
			if(res==0) {
				return Integer.compare(o1[1], o2[1]);
			}
			return res;
		});
//		for(int[] al:a) System.out.print(Arrays.toString(al)+" "); System.out.println();
		
		//강의장 배정을 위한 우선순위큐
		PriorityQueue<Integer> pq=new PriorityQueue<>();
		
		//가장 빠른 강의 배정하기
		pq.offer(a[0][1]);
		
		for (int i=1; i<N; i++) {
			if(pq.peek()<=a[i][0]) {
				pq.poll();
			}
			pq.offer(a[i][1]);
		}
		
		System.out.println(pq.size());
		br.close();
	}
}
