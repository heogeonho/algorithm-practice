import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int result = 0;
        int size = 1;
        int criteria = 10;

        for (int i = 1; i <= N; i++) {
            if (i % criteria == 0) {
                size += 1;
                criteria *= 10;
            }
            result += size;
        }

        System.out.println(result);
    }
}