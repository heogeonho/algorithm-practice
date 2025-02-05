import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            int[] list = new int[n+1];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                list[a]=b;
            }

            int top = list[1];
            int count = 1;

            for(int i=2; i<=n;i++){
                if(list[i] > top) continue;
                count++;
                top = list[i];
                if(top == 1) break;
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}
