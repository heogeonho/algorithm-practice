import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        
        System.out.println(countHanSu(N));
    }

    static int countHanSu(int N) {
        int cnt = 0;
        if (N < 100) {
            cnt = N;
        } else {
            cnt = 99;
            for (int i = 100; i <= N; i++) {
                if (i / 100 + i % 10 == (i % 100 / 10) * 2) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
