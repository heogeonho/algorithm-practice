import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        long A = sc.nextLong();
        long B = sc.nextLong();
        
        System.out.println(bfs(A, B));
    }
    
    static int bfs(long A, long B) {
        Queue<long[]> queue = new LinkedList<>();
        queue.add(new long[]{A, 1});
        
        while (!queue.isEmpty()) {
            long[] current = queue.poll();
            long num = current[0];
            int steps = (int) current[1];
           
       
            if (num == B) {
                return steps;
            }
            
            if (num * 2 <= B) {
                queue.add(new long[]{num * 2, steps + 1});
            }
            if (num * 10 + 1 <= B) {
                queue.add(new long[]{num * 10 + 1, steps + 1});
            }
        }
        
        return -1;
    }
}