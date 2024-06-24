import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		ArrayDeque<Integer> q=new ArrayDeque<>();
		for (int i = 0; i < N; i++) {
			q.offer(i+1);
		}
		int cnt=1;
		while(!q.isEmpty()) {
			if(cnt%2==1) {
				int temp = q.poll();
				if(q.isEmpty()) {
					System.out.println(temp);
					return;
				}
			} else {
				int temp = q.poll();
				q.offer(temp);
			}
			cnt++;
		}
	}
}