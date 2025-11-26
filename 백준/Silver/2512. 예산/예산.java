import java.io.*;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int max = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
        }

        int M = Integer.parseInt(br.readLine());

        int l = 0;
        int r = max;
        int answer = 0;

        while (l <= r) {
            int mid = (l + r) / 2;

            long sum = 0;
            for (int x : arr) sum += Math.min(x, mid);

            if (sum <= M) { 
                answer = mid;
                l = mid + 1;
            } else {   
                r = mid - 1;
            }
        }

        System.out.println(answer);
    }
}