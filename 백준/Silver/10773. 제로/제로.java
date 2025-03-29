import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for(int i = 0; i < K; i++) {
            int input = Integer.parseInt(br.readLine());
            if(input == 0) {
                stack.pop();
            } else {
                stack.push(input);
            }
        }
        int sum = 0;
        while(!stack.isEmpty()) {
            sum += stack.pop();
        }
        System.out.println(sum);
    }
}