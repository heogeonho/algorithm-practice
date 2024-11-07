import java.util.*;
import java.io.*;

public class Main {
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        for(int i=0; i<n; i++){
            for(int b=0;b<i;b++) {
                System.out.print(" ");
            }
            for(int s=0;s<n-i;s++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}