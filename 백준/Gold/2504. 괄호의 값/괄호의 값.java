import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        // ArrayDeque 활용하기 (스택, 큐 모두)
        ArrayDeque<Character> stack = new ArrayDeque<>();
        int result = 0;
        int temp = 1;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                stack.push(c);
                temp *= 2;
            } else if (c == '[') {
                stack.push(c);
                temp *= 3;
            } else if (c == ')') {
                // 스택이 비었거나 짝이 안 맞으면 invalid
                if (stack.isEmpty() || stack.peek() != '(') {
                    result = 0;
                    break;
                }

                // 바로 직전이 '('이면 "()"이므로 현재 temp를 더함
                if (s.charAt(i - 1) == '(') {
                    result += temp;
                }

                // 나누기를 통해 중첩된 상태 벗어나기
                stack.pop();
                temp /= 2;
            } else if (c == ']') {
                if (stack.isEmpty() || stack.peek() != '[') {
                    result = 0;
                    break;
                }

                if (s.charAt(i - 1) == '[') {
                    result += temp;
                }

                stack.pop();
                temp /= 3;
            }
        }

        // 다 끝났는데 스택에 남아있으면 invalid
        if (!stack.isEmpty()) result = 0;

        System.out.println(result);
    }
}