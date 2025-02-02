import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
        int input = Integer.parseInt(br.readLine());
        int res = 0;

        int temp = 1000 - input;

        res += temp / 500;
        temp %= 500;
        res += temp / 100;
        temp %= 100;
        res += temp / 50;
        temp %= 50;
        res += temp / 10;
        temp %= 10;
        res += temp / 5;
        temp %= 5;
        res += temp / 1;

        System.out.println(res);
        br.close();
    }
}