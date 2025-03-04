import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());

            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int[] boxCnt = new int[n];
            int result = 0;

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    String isBox = st.nextToken();
                    if (isBox.equals("1")) {
                        boxCnt[j]++;
                    } else {
                        result += boxCnt[j];
                    }
                }
            }
            sb.append(result).append("\n");
        }

        System.out.println(sb.toString());
    }
}
