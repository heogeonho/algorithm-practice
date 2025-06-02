import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    static int r, c;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        r = Integer.parseInt(input[1]);
        c = Integer.parseInt(input[2]);

        int size = (int) Math.pow(2, N);
        System.out.println(getOrder(size, 0, 0));
    }

    static int getOrder(int size, int row, int col) {
        if (size == 1) return 0;

        int half = size / 2;
        int areaSize = half * half;

        // 사분면 조건문
        if (r < row + half && c < col + half) {
            return getOrder(half, row, col);
        } else if (r < row + half && c >= col + half) {
            return areaSize + getOrder(half, row, col + half);
        } else if (r >= row + half && c < col + half) {
            return 2 * areaSize + getOrder(half, row + half, col);
        } else {
            return 3 * areaSize + getOrder(half, row + half, col + half);
        }
    }
}