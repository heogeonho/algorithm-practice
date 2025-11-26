import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int L = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int n = Integer.parseInt(br.readLine());
        
        int[] cube = new int[20];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            cube[a] = b;
        }

        long filled = 0;
        long ans = 0;

        for (int i = 19; i >=0; i--) {
            filled <<= 3;

            long capacity = 
                    (long)(L >> i) *
                    (long)(W >> i) *
                    (long)(H >> i);
                    
            long space = capacity - filled;

            if(space <= 0) continue;

            long use = Math.min(space, cube[i]);

            filled += use;
            ans += use;
        }

        long totalVolume = (long) L*W*H;

        if (filled == totalVolume) {
            System.out.println(ans);
        } else {
            System.out.println(-1);
        }

    }
}