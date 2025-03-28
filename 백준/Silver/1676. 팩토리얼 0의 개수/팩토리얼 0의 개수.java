import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        // 5와 2가 있으면 0이 하나 발생하는 원리 생각
        // 5가 몇개 들어갈까만 생각하면 되는 문제
        // N의 범위 0 <= N <= 500
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        System.out.println(N/5+N/25+N/125);
    }
}