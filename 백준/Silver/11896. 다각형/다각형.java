import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long res = 0;

        for (long i = a; i <= b; i++) {
            if (i == 2) continue;
            if (i % 2 == 0) {
                res += i;
            }
        }
        System.out.println(res);
    }
}