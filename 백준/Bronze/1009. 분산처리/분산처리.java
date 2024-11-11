import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int result = 1;
            for (int k = 0; k < b; k++) {
                result = (result % 10) * a;
            }
            if(result % 10 != 0) {
                sb.append(result % 10).append("\n");    
            } else {
                sb.append(10).append("\n");
            }
        }
        System.out.println(sb.toString());
        br.close();
    }
}
