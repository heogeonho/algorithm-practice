import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main {
    static int Quarter = 25;
    static int Dime = 10;
    static int Nickel = 5;
    static int Penny = 1;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int c = Integer.parseInt(br.readLine());

            sb.append(c / Quarter).append(" ");
            int remain = c % Quarter;
            sb.append(remain / Dime).append(" ");
            remain = remain % Dime;
            sb.append(remain / Nickel).append(" ");
            remain = remain % Nickel;
            sb.append(remain / Penny).append("\n");
        }
        System.out.println(sb.toString());
        br.close();
    }
}
