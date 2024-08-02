import java.util.*;
import java.io.*;

public class Main {
	static StringBuilder sb=new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=null;
		int M=Integer.parseInt(br.readLine());
		int S=0;
		
		for(int i=0; i<M; i++) {
			st=new StringTokenizer(br.readLine()," ");
			String com=st.nextToken();
			if(com.equals("all")) {
				S = (1 << 21) - 1;
			} else if(com.equals("empty")) {
				S=0;
			} else {
				int v=Integer.parseInt(st.nextToken());
				if(com.equals("add")) {
					S=S|(1<<v);
				} else if(com.equals("remove")) {
					S=S&~(1<<v);
				} else if(com.equals("check")) {
					sb.append((S&(1<<v))==0 ? 0: 1).append("\n");
				} else if(com.equals("toggle")) {
					S=S^(1<<v);
				}
			}
		}
		System.out.print(sb.toString());
		br.close();
	}
}