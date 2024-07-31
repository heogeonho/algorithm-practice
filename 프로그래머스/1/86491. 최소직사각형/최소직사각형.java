import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[][] sizes) {
        for(int[] sl: sizes) {
            if(sl[0]<sl[1]) {
                int temp=sl[0];
                sl[0]=sl[1];
                sl[1]=temp;
            }
        }
        
        int maxX=Integer.MIN_VALUE;
        int maxY=Integer.MIN_VALUE;
        
        for(int[] sl: sizes) {
            if(maxX<sl[0]) maxX=sl[0];
            if(maxY<sl[1]) maxY=sl[1];
        }
        return maxX*maxY;
    }
} 