import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main { // 좌표 정렬하기 https://acmicpc.net/submit/11650
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> {
            if(a.x==b.x){
                return Integer.compare(a.y,b.y);
            }
            return Integer.compare(a.x,b.x);
        });
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            pq.offer(new Node(x,y));
        }
        for(int i = 0; i < n; i++){
            Node cur = pq.poll();
            System.out.println(cur.x + " " + cur.y);
        }
    }

    static class Node{
        int x;
        int y;
        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
