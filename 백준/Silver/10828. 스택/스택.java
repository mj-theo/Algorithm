import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main { // 스택 https://acmicpc.net/problem/10828
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[] stack = new int[100001];
        int top = -1;
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            switch(cmd){
                case "push":
                    top++;
                    stack[top] = Integer.parseInt(st.nextToken());
                    break;
                case "top":
                    if(top == -1){
                        System.out.println(-1);
                    }else{
                        System.out.println(stack[top]);
                    }
                    break;
                case "pop":
                    if(top==-1){
                        System.out.println(-1);
                    }else{
                        System.out.println(stack[top]);
                        top--;
                    }
                    break;
                case "size":
                    System.out.println(top+1);
                    break;
                case "empty":
                    if(top == -1){
                        System.out.println(1);
                    }else{
                        System.out.println(0);
                    }
            }
        }
    }
}
