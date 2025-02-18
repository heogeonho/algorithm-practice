import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] positions;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); 
        M = Integer.parseInt(br.readLine()); 

        positions = new int[M];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            positions[i] = Integer.parseInt(st.nextToken());
        }

        int left = 1, right = N; 
        int answer = right;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (canIlluminate(mid)) {
                answer = mid;
                right = mid - 1; 
            } else {
                left = mid + 1; 
            }
        }

        System.out.println(answer);
    }

    static boolean canIlluminate(int height) {
        int lastCovered = 0;

        for (int pos : positions) {
            if (pos - height > lastCovered) {
                return false;
            }
            lastCovered = pos + height; 
        }

        return lastCovered >= N;
    }
}