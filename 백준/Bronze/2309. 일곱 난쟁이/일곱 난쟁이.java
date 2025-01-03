import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] heights = new int[9];
        int total = 0;

        for (int i = 0; i < 9; i++) {
            heights[i] = Integer.parseInt(br.readLine());
            total += heights[i];
        }

        // 두명 제외 합 100 찾기
        outerLoop:
        for (int i = 0; i < 9; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (total - heights[i] - heights[j] == 100) {
                    printResult(heights, i, j);
                    break outerLoop;
                }
            }
        }
    }

    private static void printResult(int[] heights, int skip1, int skip2) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            if (i != skip1 && i != skip2) {
                result.add(heights[i]);
            }
        }
        // 오름차순
        Collections.sort(result);
        for (int height : result) {
            System.out.println(height);
        }
    }
}