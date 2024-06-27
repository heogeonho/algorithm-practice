import java.util.*;
import java.io.*;

public class Main {
	static void partition(int r, int c, int size) {
		if(size!=2) {
			size=size/2;
			
			if(R<r+size && C<c+size) {
				partition(r     , c     , size);				
			}
			else if(R<r+size && C>=c+size) {
				v+=size*size;
				partition(r     , c+size, size);				
			}
			else if(R>=r+size && C<c+size) {
				v+=2*size*size;
				partition(r+size, c     , size);				
			}
			else if(R>=r+size && C>=c+size) {
				v+=3*size*size;
				partition(r+size, c+size, size);				
			}
		} else { 
			for(int i=0; i<2; i++) {
				for(int j=0; j<2; j++) {
					if(r+i==R && c+j==C) {
						result=v;
						return;
					}
					v++;
				}
			}
		}
	}
	
	static int v=0;
	static int R, C, result;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		
		int N=Integer.parseInt(st.nextToken());
		int r=Integer.parseInt(st.nextToken()); //행
		int c=Integer.parseInt(st.nextToken()); //열
		int size=(int)Math.pow(2, N);
		R=r;
		C=c;
		
		partition(0,0,size);
		System.out.println(result);
		
		br.close();
	}
}