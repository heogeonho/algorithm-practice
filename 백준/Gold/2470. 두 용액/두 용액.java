import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int[] result = new int[2];

        int start = 0;
        int end = arr.length - 1;
        int min = Integer.MAX_VALUE;

        while (start < end) {
            int sum = arr[start] + arr[end];
            int abs = Math.abs(sum);

            if (abs < min) {
                min = abs;
                result[0] = arr[start];
                result[1] = arr[end];
            }

            if (sum > 0) {
                end--;
            } else {
                start++;
            }
        }

        System.out.println(result[0] + " " + result[1]);
    }
}