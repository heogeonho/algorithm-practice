import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int E = Integer.parseInt(st.nextToken());
        int e = E == 15 ? 0 : E;
        int S = Integer.parseInt(st.nextToken());
        int s = S == 28 ? 0 : S;
        int M = Integer.parseInt(st.nextToken());
        int m = M == 19 ? 0 : M;

        // 15로 나눈 나머지가 e 인 수 반복 = ce
        // ce 를 19로 나눈 나머지가 m 인 수 = cm
        // cm 을 28로 나눈 나머지가 s 인 수 = result

        int i = 0;
        int result = 0;
        while (true) {
            int ce = 15 * i + e;
            if (ce == 0) {
                i++;
                continue;
            }
            if (ce % 19 == m) {
                if (ce % 28 == s) {
                    result = ce;
                    break;
                }
            }
            i++;
        }

        System.out.println(result);
        br.close();
    }
}