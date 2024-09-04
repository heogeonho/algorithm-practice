import java.util.*;
import java.io.*;

public class Main {

    static int k;
    static String[] A;
    static boolean[] v = new boolean[10];
    static List<String> results = new ArrayList<>();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        k = Integer.parseInt(br.readLine());
        A = new String[k];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<k; i++) {
            A[i] = st.nextToken();
        }
        dfs("",0);

        Collections.sort(results);
        System.out.println(results.get(results.size() - 1)); // 최대값
        System.out.println(results.get(0)); // 최소값
    }

    static void dfs (String number, int depth) {
        if(depth == k+1) {
            results.add(number);
            return;
        }

        for(int i=0; i<10; i++) {
            if(v[i]) continue;
            if(depth==0 || check(number.charAt(depth - 1)-'0', i, A[depth-1])) {
                v[i]=true;
                dfs(number+i,depth+1);
                v[i]=false;
            }
        }
    }

    // 부등호를 만족하는지 확인하는 함수
    static boolean check(int a, int b, String sign) {
        if (sign.equals("<")) {
            return a < b;
        } else {
            return a > b;
        }
    }
}