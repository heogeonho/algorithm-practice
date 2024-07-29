import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine(), " ");
		StringBuilder sb=new StringBuilder();
		
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		int cnt=0;
		ArrayList<String> result=new ArrayList<>();
		
		String[] noListen=new String[N];
		String[] noWatch=new String[M];
		
		for(int i=0; i<N; i++) {
			noListen[i]=br.readLine();
		}
		
		for(int i=0; i<M; i++) {
			noWatch[i]=br.readLine();
		}
		
		HashMap<String, Integer> map=new HashMap<>();
		
		for(int i=0; i<N; i++) {
			map.put(noListen[i], 1);
		}
		
		for(int i=0; i<M; i++) {
			if(map.get(noWatch[i])==null) {
				map.put(noWatch[i], 1);
			} else {
				cnt++;
				result.add(noWatch[i]);
			}
		}
        result.sort((o1, o2) -> o1.compareTo(o2));
		
		sb.append(cnt).append("\n");
		for(String s:result) sb.append(s).append("\n");
		
		System.out.println(sb.toString());
		br.close();
	}
}