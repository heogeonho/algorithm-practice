import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        
        // 최대공약수
        int gcd = findGcd(A, B);
        
        // 최소공배수
        int lcm = A * B / gcd;

        System.out.println(gcd);
        System.out.println(lcm);
    }

    static int findGcd(int a, int b) {
        int min = Math.min(a, b); // 작은수부터 찾기
        for (int i = min; i >= 1; i--) {
            if (a % i == 0 && b % i == 0) {
                return i; // 처음 만나는 공약수가 최대공약수
            }
        }
        return 1; // 공약수가 없으면 1
    }
}