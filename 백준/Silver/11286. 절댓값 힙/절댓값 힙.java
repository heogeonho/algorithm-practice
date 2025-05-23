import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
			if (Math.abs(o1) != Math.abs(o2)) {
				return Math.abs(o1) - Math.abs(o2); // 절댓값이 작은순
			} else {
				return o1 - o2; // 절댓값 같으면 작은순
			}
		});
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < N; i++) {
			int x = Integer.parseInt(br.readLine());
			if(x == 0) {
				if(pq.isEmpty()) sb.append("0").append("\n");
				else sb.append(pq.poll()).append("\n");
			}else {
				pq.offer(x);
			}
		}
		System.out.println(sb);
	}
}