import java.util.*;


class Solution {
 public static int[] solution(int[] prices) {
	     
     
               int s = prices.length;
        int[] d = new int[s];
        
        for (int i = 0; i < s; i++) {
            int temp = 0;
            for (int j = i + 1; j < s; j++) {
                temp++;
                if (prices[i] > prices[j]) {
                    break;
                }
            }
            d[i] = temp;
        }
        
        return d;
    }
}