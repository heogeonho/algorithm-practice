import java.util.*;
import java.io.*;

public class Main {
	static int k, r=6;
	static int[] S, ans;
	static StringBuilder sb=new StringBuilder();

	static void chooseNumber(int cnt, int start) {
		if(cnt==r) {
			for(int i:ans) sb.append(i+" ");
			sb.append("\n");
			return;
		}
		for(int i=start; i<k; i++) {
			ans[cnt]=S[i];
			
			chooseNumber(cnt+1, i+1);
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=null;
		
		while(true) {
			st=new StringTokenizer(br.readLine()," ");
			k=Integer.parseInt(st.nextToken());
			if(k==0) break;
			
			S=new int[k];
			for(int i=0; i<k; i++) {
				S[i]=Integer.parseInt(st.nextToken());
			}
			ans=new int[6];
			chooseNumber(0, 0);
			
			sb.append("\n");
		}
		System.out.println(sb);
		br.close();
	}
}