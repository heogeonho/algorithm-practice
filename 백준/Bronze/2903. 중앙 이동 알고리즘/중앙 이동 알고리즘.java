import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int sidePoints = (int) Math.pow(2, n) + 1;
        
        int total = sidePoints * sidePoints;
        
        System.out.println(total);
        br.close();
    }
}