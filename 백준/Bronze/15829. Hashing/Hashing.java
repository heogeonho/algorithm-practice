import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());
        String input = br.readLine();

        long sum = 0;
        long r = 1;
        int M = 1234567891;
        
        for (int i = 0; i < L; i++) {
            int charV = input.charAt(i) - 'a' + 1;
            
            sum = (sum + (charV * r)) % M;
            r = (r * 31) % M; 
            // Math.pow() 쓰니 너무 커지는 문제 -> 모듈러 연산 특징 활용
        }
        
        System.out.println(sum%M);
    }
}