/*
입력
첫째 줄에 두 도메인의 유명도 N과 M이 주어진다. 
(-2,000,000,000 ≤ N, M ≤ 2,000,000,000)

출력
첫째 줄에 두 유명도의 차이 (|N-M|)을 출력한다.
*/


import java.io.*;
import java.util.*;

public class Main {
    public static void main (String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long N = Integer.parseInt(st.nextToken());
        long M = Integer.parseInt(st.nextToken());
        System.out.println(Math.abs(N-M));
    }
}
