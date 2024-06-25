import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		
		int N=Integer.parseInt(br.readLine());

		String[] a=new String[N];
		for(int i=0; i<N; i++) {
			a[i]=br.readLine().trim();
		}

		Arrays.sort(a, (o1, o2)-> {
			int compRes= Integer.compare(o1.length(), o2.length());
			if(compRes==0) {
				return o1.compareTo(o2);
			}
			return compRes;
		});
		
		for (int i = 0; i < a.length; i++) {
			if(i==0) {
				sb.append(a[i]).append("\n");				
			} else {
				if(!a[i].equals(a[i-1])) {
					sb.append(a[i]).append("\n");					
				}
			}
		}
		System.out.println(sb);
		br.close();
	}
}