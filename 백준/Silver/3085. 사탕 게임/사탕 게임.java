import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/*
순회 전 최대 길이 찾기
NxN 전체 순회
    i,j -> [i,j+1] [i+1,j] 유효값 검증
        1. 가능한 범위인지 판단
        2. 해당 위치 두 값이 다른 값인지 판단
    교환 후 i, i+1 라인 비교
        [i,j][i  ,j+1] -> j, j+1 두 라인 비교
        [i,j][i+1,j  ] -> i, i+1 두 라인 비교
    과정 이후 다시 교환

순회 끝나고 최대값 리턴
 */

public class Main {
    static int N;
    static String[][] map;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        N = Integer.parseInt(br.readLine());
        map = new String[N][N];
        for (int i = 0; i < N; i++) {
            String temp = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = temp.charAt(j) + "";
            }
        }
//        System.out.println("===생성===");
//        for (String[] a : map) {
//            System.out.println(Arrays.toString(a));
//        }
//        System.out.println("===생성===\n");

        for (int i = 0; i < N; i++) {
            int cMax = findSameColorMaxInCol(i);
            int rMax = findSameColorMaxInRow(i);
            max = Math.max(Math.max(cMax, rMax), max);
        }
//        System.out.println("기존 map max: " + max);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
//                System.out.println("\ni: " + i + " | j: " + j + "| 순회중 max: " + max);
                if (isValid(i, j, i, j + 1)) {
                    swap(i, j, i, j + 1);
//                    System.out.println("===교체===");
//                    for (String[] a : map) {
//                        System.out.println(Arrays.toString(a));
//                    }
//                    System.out.println("===교체===\n");
                    int c1 = findSameColorMaxInCol(j);
                    int c2 = findSameColorMaxInCol(j + 1);
                    int r1 = findSameColorMaxInRow(i);
//                    System.out.println("c1: " + c1 + " | c2: " + c2 + "| r1: " + r1);
                    max = Math.max(Math.max(Math.max(c1, c2), r1), max);
                    swap(i, j, i, j + 1);
                }
                if (isValid(i, j, i + 1, j)) {
                    swap(i, j, i + 1, j);
//                    System.out.println("===교체===");
//                    for (String[] a : map) {
//                        System.out.println(Arrays.toString(a));
//                    }
//                    System.out.println("===교체===\n");
                    int r1 = findSameColorMaxInRow(i);
                    int r2 = findSameColorMaxInRow(i + 1);
                    int c1 = findSameColorMaxInCol(j);
//                    System.out.println("r1: " + r1 + " | r2: " + r2 + "| c1: " + c1);
                    max = Math.max(Math.max(Math.max(r1, r2), c1), max);
                    swap(i, j, i + 1, j);
                }

            }
        }
        System.out.println(max);
    }

    static void swap(int i, int j, int ni, int nj) {
        String temp = map[i][j];
        map[i][j] = map[ni][nj];
        map[ni][nj] = temp;
    }

    // 값이 다른지, 범위안에 존재하는지
    static boolean isValid(int i, int j, int ni, int nj) {
        return ni <= N - 1 && nj <= N - 1 && !map[i][j].equals(map[ni][nj]);
    }

    // 열 같은값의 연속 여부
    static int findSameColorMaxInCol(int j) {
        int cMax = 1;
        int len = 1;
        String str = map[0][j];
        for (int k = 1; k < N; k++) {
            if (str.equals(map[k][j])) {
                len++;
                cMax = Math.max(cMax, len);
            } else {
                len = 1;
            }
            str = map[k][j];
        }

        return cMax;
    }

    // 행 같은값의 연속 여부
    static int findSameColorMaxInRow(int i) {
        int rMax = 1;
        int len = 1;
        String str = map[i][0];
        for (int k = 1; k < N; k++) {
            if (str.equals(map[i][k])) {
                len++;
                rMax = Math.max(rMax, len);
            } else {
                len = 1;
            }
            str = map[i][k];
        }
        return rMax;
    }
}
