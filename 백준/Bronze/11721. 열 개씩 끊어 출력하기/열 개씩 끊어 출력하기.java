import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();
        int len = str.length();
        for (int i = 0; i < len / 10 + 1; i++) {
            int startIdx = i * 10;
            if (i == len / 10) {
                sb.append(str.substring(startIdx));
                break;
            }
            sb.append(str, startIdx, startIdx + 10).append("\n");
        }
        System.out.println(sb);
    }
}
