import java.util.*;
import java.io.*;

public class Main {
    static int N = 9;
    static int[][] board = new int[9][9];
    static StringBuilder sb = new StringBuilder();

    static void solve() {
        if (fillSudoku(0, 0)) {
            for (int[] row : board) {
                for (int num : row) {
                    sb.append(num).append(" ");
                }
                sb.append("\n");
            }
        }
    }

    static boolean fillSudoku(int row, int col) {
        if (row == N) return true;  // 스도쿠가 완성된 경우

        // 다음 위치 계산
        int nextRow = (col == N - 1) ? row + 1 : row;
        int nextCol = (col == N - 1) ? 0 : col + 1;

        if (board[row][col] != 0) {
            // 현재 위치에 숫자가 이미 있으면 다음 칸으로 넘어감
            return fillSudoku(nextRow, nextCol);
        }

        // 숫자 1부터 9까지 시도
        for (int num = 1; num <= 9; num++) {
            if (checkBox(num, row, col) && checkRow(num, row) && checkCol(num, col)) {
                board[row][col] = num;
                if (fillSudoku(nextRow, nextCol)) return true;
                board[row][col] = 0;  // 백트래킹
            }
        }

        return false;
    }

    static boolean checkBox(int num, int row, int col) {
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == num) return false;
            }
        }
        return true;
    }

    static boolean checkRow(int num, int row) {
        for (int col = 0; col < N; col++) {
            if (board[row][col] == num) return false;
        }
        return true;
    }

    static boolean checkCol(int num, int col) {
        for (int row = 0; row < N; row++) {
            if (board[row][col] == num) return false;
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 9; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solve();
        System.out.println(sb);
        br.close();
    }
}
