import java.io.*;
import java.util.*;

/*
a층의 b호 인원수 -> (a-1)층의 1호 ~ b호까지 사람들의 수의 합

양의 정수 k와 n에 대해 
k층에 n호에는 몇 명이 살고 있는지 출력

아파트 0층부터
각층에는 1호부터
0층의 i호에는 i명
*/

/*
규칙 찾아서 아파트 만들고 출력하기

k

2   1   4   10  20  35  56  84
1   1   3   6   10  15  21  28
0   1   2   3   4   5   6   7

i   1   2   3   4   5   6   7

k층의 n호 = k층 n-1호 + k-1층 n호
 */
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[][] apt = new int[15][15];

        for (int i = 0; i < 15; i++) {
            apt[0][i] = i;
        }
        for (int i = 1; i < 15; i++) {
            for (int j = 1; j < 15; j++) {
                apt[i][j] = apt[i][j-1] + apt[i-1][j];
            }
        }

        for (int i = 0; i < T; i++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            System.out.println(apt[k][n]);
        }
    }
}