import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Deque<Node> stack = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            int val = Integer.parseInt(st.nextToken());
            while(!stack.isEmpty() && stack.peek().val < val){ // 자기보다 앞단의 타워가 작으면 미리 지워놓기.
                stack.pop();
            }
            if(stack.isEmpty()){
                System.out.print(0 + " ");
            }else{
                System.out.print(stack.peek().index + " ");
            }
            stack.push(new Node(i, val));
        }
    }

    static class Node{
        int index;
        int val;
        Node(int index, int val){
            this.index = index;
            this.val = val;
        }
    }
}
