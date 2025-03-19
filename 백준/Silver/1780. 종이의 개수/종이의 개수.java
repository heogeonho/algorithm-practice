import java.io.*;
import java.util.*;

class Main {
    static int[][] paper;
    static int minusOne = 0, zero = 0, plusOne = 0; // -1, 0, 1 개수 카운트 위한 변수

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        paper = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 분할 정복 시작
        countPapers(0, 0, N);

        System.out.println(minusOne);
        System.out.println(zero);
        System.out.println(plusOne);
    }

    static void countPapers(int rowStart, int colStart, int size) {
        if (checkSame(rowStart, colStart, size)) { // 현재 영역이 하나의 숫자로만 이루어졌는지 확인
            int value = paper[rowStart][colStart]; // 시작 값 기준 동일성 판단하기
            if (value == -1) minusOne++;
            else if (value == 0) zero++;
            else plusOne++;
            return;
        }

        int newSize = size / 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                countPapers(rowStart + i * newSize, colStart + j * newSize, newSize);
            }
        }
    }

    // 하나의 숫자로만 이루어져 있는지 체크하는 함수
    static boolean checkSame(int rowStart, int colStart, int size) {
        int firstValue = paper[rowStart][colStart]; // 순회 시작
        for (int i = rowStart; i < rowStart + size; i++) {
            for (int j = colStart; j < colStart + size; j++) {
                if (paper[i][j] != firstValue) {
                    return false;
                }
            }
        }
        return true;
    }
}