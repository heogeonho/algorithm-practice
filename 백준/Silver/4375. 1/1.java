import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String inputStr = null;
        while ((inputStr = br.readLine()) != null) {
            int answer = 1;
            int temp = 1;
            int n = Integer.parseInt(inputStr);
            boolean isFind = false;
            while (isFind == false) {
                if (temp % n == 0) {
                    break;
                } else {
                    temp = ((temp * 10) + 1) % n;
                    answer++;
                }
            }
            sb.append(answer).append("\n");
        }
        System.out.println(sb.toString());
    }
}