import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] board;
	static boolean[][] visited;
	static ArrayList<Integer>[] list;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		list = new ArrayList[n+1];
		board = new int[n+1][n+1];
		
		for(int i = 1;i<=n;i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 1;i<=n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int k = 1;k<=n;k++) {
				int next = Integer.parseInt(st.nextToken());
				if(next==1) {
					list[i].add(k); // 방향 그래프
				}
			}
		}
		
		for(int i = 1;i<=n;i++) {
			visited = new boolean[n+1][n+1];
			bfs(i);
		}
		
		for(int i = 1;i<=n;i++) {
			for(int j = 1;j<=n;j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	static void bfs(int index) {
		Queue<Integer> queue = new ArrayDeque<>();
		queue.offer(index);
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			for(int next : list[cur]) {
				if(!visited[index][next]) {
					visited[index][next] = true;
					queue.offer(next);
					board[index][next] = 1;
				} 
			}
		}
	}
}
