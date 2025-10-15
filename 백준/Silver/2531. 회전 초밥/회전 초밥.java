import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] sushi = new int[N];
        for (int i = 0; i < N; i++) {
            sushi[i] = Integer.parseInt(br.readLine());
        }

        int start = 0;
        int end = start+k-1;
        int max = Integer.MIN_VALUE;
        Map<Integer,Integer> eat = new HashMap<>();
        eat.put(c, 1);
        for(int i = start; i <= end; i++) eat.put(sushi[i], eat.getOrDefault(sushi[i], 0)+1);
        // System.out.println(eat);

        end++;
        while (start < N) {
            // System.out.println("sushi["+start+"]"+sushi[start]);
            // System.out.println("sushi["+end%N+"]"+sushi[end%N]);
            if(sushi[start]!=c && eat.get(sushi[start])==1) eat.remove(sushi[start]);
            else if(eat.get(sushi[start])!=1) eat.put(sushi[start], eat.get(sushi[start])-1);
            eat.put(sushi[end%N], eat.getOrDefault(sushi[end%N], 0)+1);
            // System.out.println(eat);
            max = Integer.max(max, eat.size());
            start++;
            end++;
        }

        System.out.println(max);
    }
}