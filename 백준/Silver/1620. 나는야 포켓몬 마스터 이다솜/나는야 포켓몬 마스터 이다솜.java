import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();

        HashMap<Integer, String> numMap = new HashMap<>();
        HashMap<String, Integer> nameMap = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            String input = br.readLine();
            numMap.put(i, input);
            nameMap.put(input, i);
        }

        for (int i = 0; i < M; i++) {
            String str = br.readLine();
            if (Character.isDigit(str.charAt(0))) {
                sb.append(numMap.get(Integer.parseInt(str))).append("\n");
            } else {
                sb.append(nameMap.get(str)).append("\n");
            }
        }

        System.out.println(sb.toString());
        
    }
}
