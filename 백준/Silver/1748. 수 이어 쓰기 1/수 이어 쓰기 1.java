import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int result = 0;
        int size = 1;        // 현재 자릿수
        int criteria = 10;   // 자릿수 경계값 

        for (int i = 1; i <= N; i++) {
            if (i == criteria) { // 자릿수 바뀌는 시점
                size++;
                criteria *= 10;
            }
            result += size;  // 현재 숫자의 자리수를 더함
        }

        System.out.println(result);
    }
}
