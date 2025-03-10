import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        String[] a = new String[N];
        for (int i = 0; i < N; i++) {
            a[i] = br.readLine();
        }

        Arrays.sort(a, (o1, o2) -> {
            if (o1.length() == o2.length()) {
                return o1.compareTo(o2);
            }
            return o1.length() - o2.length();
        });

        for (int i = 0; i < a.length; i++) {
            if (i == 0) {
                sb.append(a[i]).append("\n");
                continue;
            }
            if (!a[i].equals(a[i - 1])) {
                sb.append(a[i]).append("\n");
            }
        }
        System.out.println(sb);
        br.close();
    }
}