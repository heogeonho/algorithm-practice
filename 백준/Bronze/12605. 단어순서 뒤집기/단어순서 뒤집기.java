import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        Stack<String> stack =new Stack<>();
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            String[] words = line.split(" ");
            for (int j = 0; j < words.length; j++) {
                stack.push(words[j]);
            }
            sb.append("Case #"+(i+1)+": ");
            for (int j = 0; j < words.length; j++) {
                sb.append(stack.pop()).append(" ");
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}