import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine()); //N번째 P
        for (int i = 0; i <= 2 * N + 1; i++) {
            sb.append("K");
        }
        int M = Integer.parseInt(br.readLine()); //S의 길이
        String S = br.readLine() + sb; //문자열S

        int cnt = 0;
        int result = 0;
        for (int i = 0; i < M; i++) {
            if (S.charAt(i) == 'I') {
                if (S.charAt(i + 1) == 'O' && S.charAt(i + 2) == 'I') {
                    cnt += 2;
                    i++;
                } else {
                    cnt++;
                    int temp = ((cnt - (2 * N + 1)) / 2 + 1);
                    if (temp > 0) {
                        result += temp;
                    }
                    cnt = 0;
                }
            }
        }

        System.out.println(result);
    }
}
