import java.util.*;
import java.io.*;

public class Main {
	
	// 실제 값들 현황을 담는 맵
	static HashMap<Integer,Integer> map=new HashMap<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=null;
		StringBuilder sb=new StringBuilder();
		
		int T=Integer.parseInt(br.readLine());
		
		//테스트 반복
		for(int i=0; i<T; i++) {
			int k=Integer.parseInt(br.readLine());
			PriorityQueue<Integer> maxPQ=new PriorityQueue<>(Collections.reverseOrder());
			PriorityQueue<Integer> minPQ=new PriorityQueue<>();
			
			//입력 반복
			for(int j=0; j<k; j++) {
				st=new StringTokenizer(br.readLine()," ");
				String oper=st.nextToken();
				
				// 입력 I 처리 (두 큐에 삽입 & 맵에 삽입)
				if(oper.equals("I")) {
					int num=Integer.parseInt(st.nextToken());
					maxPQ.offer(num);
					minPQ.offer(num);
					map.put(num, map.getOrDefault(num, 0) + 1);	
				} 
				// 입력 D 처리
				else  {
					int type=Integer.parseInt(st.nextToken());
					// 맵에 값 없으면 비어있기 때문에 다음 턴으로 넘기기
					if(map.size()==0) continue;
					// 각 타입에 따라 유효 값을 삭제해야 함
					if(type==-1) {
						removeNum(minPQ);
					} else if(type==1) {
						removeNum(maxPQ);
					}
				}
			}
			
			if(map.size()==0) {
				sb.append("EMPTY\n");
			} else {
				int res=removeNum(maxPQ);
				sb.append(res).append(" ");
				if(map.size()!=0) res=removeNum(minPQ);
				sb.append(res).append("\n");
			}
			map.clear();
		}
		System.out.println(sb.toString());
	}
	
	static int removeNum(PriorityQueue<Integer> pq) {
		int value=0;
		while(true) {
			value=pq.poll();
			int cnt=map.getOrDefault(value, 0);
			if(cnt==0) continue;
			if(cnt==1) map.remove(value);
			else {
				map.put(value, cnt-1);
			}
			break;
		}
		return value;
	}
}
