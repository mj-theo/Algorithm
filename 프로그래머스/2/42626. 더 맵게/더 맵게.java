import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b) -> Integer.compare(a,b));
        for(int i = 0;i<scoville.length;i++){
            queue.offer(scoville[i]);
        }
        while(true){
            if(queue.peek()>=K){
                break;
            }
            if(queue.size()<2){
                answer = -1;
                break;
            }
            int first = queue.poll();
            int second = queue.poll();
            int mix = first + (second*2);
            queue.offer(mix);
            answer++;
        }
        System.out.print(queue.peek());
        return answer;
    }
}