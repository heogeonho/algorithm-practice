import java.util.*;
import java.io.*;

public class Main{
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		
		int N=Integer.parseInt(br.readLine());

		Set<String> set=new HashSet<>();
		for(int i=0; i<N; i++) {
			set.add(br.readLine());
		}
		List<String> al=new ArrayList<>(set);

		al.sort((o1, o2)-> {
			int compRes= Integer.compare(o1.length(), o2.length());
			if(compRes==0) {
				return o1.compareTo(o2);
			}
			return compRes;
		});

		for (int i = 0; i < al.size(); i++) {
			sb.append(al.get(i)).append("\n");
		}
		System.out.println(sb);
		br.close();
	}
}