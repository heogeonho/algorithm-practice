import java.io.*;
import java.util.*;

class Solution {
        static int solution(int[][] jobs) {
    	PriorityQueue<int[]> jobsPQ=new PriorityQueue<>((o1, o2) -> Integer.compare(o1[0],o2[0]));
    	PriorityQueue<int[]> diskPQ=new PriorityQueue<>((o1, o2) -> Integer.compare(o1[1],o2[1]));

    	for(int[] jl: jobs) jobsPQ.offer(jl);
    	
        
        int answer = 0;
        int time = 0;

        while(!jobsPQ.isEmpty() || !diskPQ.isEmpty()){

            while(!jobsPQ.isEmpty() && jobsPQ.peek()[0] <= time){
            	diskPQ.offer(jobsPQ.poll());
            }

            if(diskPQ.isEmpty()){ 
                time = jobsPQ.peek()[0];
            }else{ 
                int[] j = diskPQ.poll();
                answer += time + j[1] - j[0];
                time += j[1];
            }
        
        }

        answer /= jobs.length;
        return answer;
    }
}