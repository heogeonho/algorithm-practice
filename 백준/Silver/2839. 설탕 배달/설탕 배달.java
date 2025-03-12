import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int res = 0;
        if (N == 4 || N == 7) {
            res = -1;
        } else if (N % 5 == 0) {
            res = N / 5;
        } else if (N % 5 == 1 || N % 5 == 3) {
            res = N / 5 + 1;
        } else {
            res = N / 5 + 2;
        }

        System.out.println(res);
        br.close();
    }
}