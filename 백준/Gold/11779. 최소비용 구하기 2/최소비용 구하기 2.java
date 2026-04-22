import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static ArrayList<Node>[] list;
	static int[] dist;
	static boolean[] visited;
	static int[] trail;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		StringTokenizer st;
		list = new ArrayList[n+1];
		dist = new int[n+1];
		visited = new boolean[n+1];
		trail = new int[n+1];
		
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		for(int i = 1;i<=n;i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 0; i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			list[start].add(new Node(end,weight));
		}
		
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		System.out.println(dijkstra(start,end));
		
		Stack<Integer> stack = new Stack<>();
		int cur = end;
		while(cur!=0) {
			stack.push(cur);
			cur = trail[cur];
		}
		System.out.println(stack.size());
		while(!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}
	}
	
	static int dijkstra(int start, int end) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start,0));
		dist[start] = 0;
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			int curIndex = cur.targetNode;
			if(!visited[curIndex]) {
				visited[curIndex] = true;
				for(Node next : list[curIndex]) {
					if(!visited[next.targetNode] && dist[next.targetNode] >= dist[curIndex] + next.value) {
						dist[next.targetNode] = dist[curIndex] + next.value;
						trail[next.targetNode] = curIndex;
						pq.add(new Node(next.targetNode,dist[next.targetNode]));
					}
				}
			}
		}
		return dist[end];
	}
	
	static class Node implements Comparable<Node>{
		int targetNode;
		int value;
		Node(int targetNode, int value){
			this.targetNode = targetNode;
			this.value = value;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.value-o.value;
		}
	}
}
