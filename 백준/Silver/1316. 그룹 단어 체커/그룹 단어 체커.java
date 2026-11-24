import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main { // 그룹 단어 체커
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int answer = 0;
        for(int i = 0;i<n;i++){
            String str = br.readLine();
            Set<Character> charSet = new HashSet<>();
            char[] chars = str.toCharArray();
            char prev = chars[0];
            boolean valid = true; // 그룹 단어 가능?
            int index = 0;
            while(index<chars.length){
                if(charSet.contains(chars[index])){ // 이미 셋에 있다면
                    if(prev != chars[index]){
                        valid = false;
                        break;
                    }else{
                        prev = chars[index];
                    }
                }else{ // 셋에 없었다면
                    prev = chars[index];
                }
                charSet.add(chars[index]);
                index++;
            }
            if(valid){
                answer++;
            }
        }
        System.out.print(answer);
    }
}
