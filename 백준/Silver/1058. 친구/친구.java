import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static ArrayList<Integer>[] list;
	static int n;
	static int maxFriend = 0;
	static boolean[] visited;
	static int[] depth;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		list = new ArrayList[n+1];
		for(int i = 1;i<=n;i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 1;i<=n;i++) {
			String str = br.readLine();
			for(int k = 0;k<n;k++) {
				if(str.substring(k,k+1).equals("Y")) {
					list[i].add(k+1);
					list[k+1].add(i);
				}
			}
		}
		
		for(int i = 1;i<=n;i++) {
			depth = new int[n+1];
			visited = new boolean[n+1];
			bfs(i);
		}
		System.out.print(maxFriend);
	}
	static void bfs(int start) {
		Queue<Integer> queue = new ArrayDeque<>();
		queue.offer(start);
		visited[start] = true;
		depth[start] = 0;
		int friends = 0;
		
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			if(depth[cur] >= 2) {
				continue;
			}
			for(int next : list[cur]) {
				if(!visited[next]) {
					queue.offer(next);
					visited[next] = true;
					depth[next] = depth[cur] + 1;
					friends++;
				}
			}
		}
		maxFriend = Math.max(maxFriend, friends);
		return;
	}
}
