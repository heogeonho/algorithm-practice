import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            
            
            int answer = -1;
            int k = x; // x로 초기화
            int lcm = lcm(M, N);

            while (k <= lcm) {

                if ((k - 1) % N + 1 == y) {
                    answer = k;
                    break;
                }
                k += M; // M씩 증가
            }
            sb.append(answer).append("\n");
        }
        System.out.println(sb.toString());
    }

    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static int lcm(int a, int b) {
        return a * b / gcd(a, b);

    }
}
