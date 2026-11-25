import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main { // 선 긋기 https://acmicpc.net/problem/2170
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n =  Integer.parseInt(br.readLine());
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b)->{
            if(a.s==b.s){
                return Integer.compare(a.e,b.e);
            }
            return Integer.compare(a.s,b.s);
        });
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            pq.offer(new Node(a,b));
        }
        Node prev = pq.poll();
        int answer = prev.e-prev.s;
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            if((cur.s-prev.e)<0){
                if(prev.e<cur.e){
                    answer += (cur.s-prev.e) + (cur.e-cur.s);
                    prev = cur;
                }
            }else{ // cur.s - prev.e >= 0
                answer += cur.e-cur.s;
                prev = cur;
            }
        }
        System.out.println(answer);
    }

    static class Node{
        int s;
        int e;
        Node(int s, int e){
            this.s = s;
            this.e = e;
        }
    }
}
