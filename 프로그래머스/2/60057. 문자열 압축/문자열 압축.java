class Solution {
    public int solution(String s) {
        int answer = Integer.MAX_VALUE;
        for(int i = 1;i<=s.length()/2; i++){
            String prev = s.substring(0,i);
            StringBuilder sb = new StringBuilder();
            int cnt = 0;
            for(int j = 0;j<s.length();j+=i){
                String str = s.substring(j,Math.min(s.length(),j+i));
                if(str.equals(prev)){
                    cnt++;
                }else{
                    if(cnt>1){
                        sb.append(cnt);
                    }
                    sb.append(prev);
                    prev = str;
                    cnt = 1;
                }
            }
            if(cnt>1){
                sb.append(cnt);
            }
            sb.append(prev);
            answer = Math.min(answer,sb.length());
        }
        answer = Math.min(answer,s.length());
        return answer;
    }
}