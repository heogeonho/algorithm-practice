import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main {

    static int cnt;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        countHanSu(N);
        System.out.println(cnt);
    }

    static void countHanSu(int N) {
        if (N < 100) {
            cnt = N;
        } else {
            cnt = 99;
            for (int i = 100; i <= N; i++) {
                int a = i / 100;
                int b = (i / 10) % 10;
                int c = i % 10;

                if (b - c == a - b) {
                    cnt++;
                }
            }
        }
    }
}
