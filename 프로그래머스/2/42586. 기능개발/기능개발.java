import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = new int[100];
        Queue<Integer> queue = new ArrayDeque<>();
        for(int i = 0;i<progresses.length;i++){
            int cnt = 1;
            while(true){
                int result = progresses[i] + (speeds[i]*cnt);
                if(result>=100){
                    queue.offer(cnt);
                    break;
                }
                cnt++;
            }
        }
        int index = 0;
        while(!queue.isEmpty()){
            int cur = queue.poll();
            int cnt = 1;
            while(!queue.isEmpty() && cur>=queue.peek()){
                queue.poll();
                cnt++;
            }
            answer[index] = cnt;
            index++;
        }
        return Arrays.copyOf(answer,index);
    }
}