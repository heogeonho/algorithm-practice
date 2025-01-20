import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int F = Integer.parseInt(br.readLine());
        int result = 0;
        int temp = N / 100;
        for (int i = temp * 100; i < temp * 100 + F; i++) {
            if (i % F == 0) {
                result = i % 100;
                break;
            }
        }
        if (result < 10) {
            String res = "0";
            System.out.println(res + result);
        } else {
            System.out.println(result % 100);
        }
        br.close();
    }
}