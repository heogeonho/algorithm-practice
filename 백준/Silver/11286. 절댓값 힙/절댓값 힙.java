import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
        
		// 문제의 조건에 맞게 우선순위 큐 생성
		PriorityQueue<Integer> pq=new PriorityQueue<>((o1, o2)->{
			int res=Math.abs(o1)-Math.abs(o2);
			if(res!=0)	return res;
			else return Integer.compare(o1, o2);
		});
		
		int N=Integer.parseInt(br.readLine());
		
        // 입력된 값에 따라 우선순위 큐에 삽입 추출 진행
		for(int i=0; i<N; i++) {
			int oper=Integer.parseInt(br.readLine());
			if(oper!=0) {
				pq.offer(oper);
			} else {
				if(pq.peek()!=null)	sb.append(pq.poll()).append("\n");
				else sb.append(0).append("\n");
			}
		}
		System.out.println(sb.toString());
		br.close();
	}
}
