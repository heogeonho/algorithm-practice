import java.util.*;
import java.io.*;

/*
<메인 아이디어>
07/15 16:50
먼저 작은수 둘을 꺼내 비교해야 한다고 생각
삽입 삭제가 반복되며 해당 반복마다 정렬이 필요하므로 우선순위 큐를 활용할 것
수 두개를 꺼냈을 때 pq가 빈다면 최종 값으로 선정 후 종료
처음에 입력값이 1개일 경우 처리를 안해줘서 nullpointer 발생


<배운점 및 생각 정리>
예외처리에 대한 고민을 좀 더 신중하게 해야할 것 같다.
입력값이 1개 2개 등과 같이 조금 주어지는 경우도 처리 방법을 고려해야 한다.
 */

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq=new PriorityQueue<>();
		int ans=0;
		
		for(int i=0; i<N; i++) {
			pq.offer(Integer.parseInt(br.readLine()));
		}
		int temp=0;
		while (true) {
				if(pq.size()==1) {
					ans=0;
					break;
				}
				temp=pq.poll();
				temp=temp+pq.poll();
				ans+=temp;
				if(pq.isEmpty()) break;
				pq.offer(temp);
		}
		System.out.println(ans);
		br.close();
	}
}
