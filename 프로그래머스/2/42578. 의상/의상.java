import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0;i < clothes.length;i++){
            String type = clothes[i][1];
            map.put(type,map.getOrDefault(type,0)+1);
        }
        for(int cnt : map.values()){
            answer *= (cnt+1); // 1은 해당 종류의 옷을 아예 안입는 경우
        }      
        return answer-1; // 모든 종류의 옷을 안입는 경우 제외
    }
}