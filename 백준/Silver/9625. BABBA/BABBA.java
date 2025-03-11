import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int[] dpA, dpB;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int K = Integer.parseInt(br.readLine());
        /*
        A(0일때)     A1      B0
        B           A0      B1  
        BA          A1      B1
        BAB         A1      B2
        BABBA       A2      B3
        BABBABAB    A3      B5
                    A:이전B  B:이전A+B
         */
        dpA = new int[K + 1];
        dpB = new int[K + 1];
        dpA[0] = 1;
        dpB[0] = 0;
        for (int i = 1; i <= K; i++) {
            dpA[i] = dpB[i - 1];
            dpB[i] = dpA[i - 1] + dpB[i - 1];
        }
        sb.append(dpA[K]).append(" ").append(dpB[K]);
        System.out.println(sb);
        br.close();
    }
}