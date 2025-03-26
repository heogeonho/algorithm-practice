import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String line;
        
        // . 입력시 중단 조건, 그 전까진 isBalanced 처리 반복
        while (!(line = br.readLine()).equals(".")) {
            sb.append(isBalanced(line)).append("\n");
        }

        System.out.print(sb);
    }

    // stack 생성해서 괄호일 경우 stack 로직 처리
    static String isBalanced(String line) {
        ArrayDeque<Character> stack = new ArrayDeque<>();

        for (char ch : line.toCharArray()) {
            // 여는 괄호 stack에 push
            // 닫는 괄호 stack에서 상단 값 비교 미충족시 no
            if (ch == '(' || ch == '[') {
                stack.push(ch);
            } else if (ch == ')') {
                if (stack.isEmpty() || stack.pop() != '(') return "no";
            } else if (ch == ']') {
                if (stack.isEmpty() || stack.pop() != '[') return "no";
            }
        }
        // 마지막 처리 후 값 남아있으면 no
        return stack.isEmpty() ? "yes" : "no";
    }
}