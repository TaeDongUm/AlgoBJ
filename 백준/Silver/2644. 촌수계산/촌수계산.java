import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int V, E, start, end;
	static ArrayList<Integer>[] graph;
	static int[] arr;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		V = Integer.parseInt(br.readLine()); // 정점 갯수
		st = new StringTokenizer(br.readLine());
		
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(br.readLine()); // 간선 갯수
		arr = new int[V+1];
		graph = new ArrayList[V+1];
		for(int i=1;i<=V;i++) {
			graph[i] = new ArrayList<>();
		}
		for(int i=1;i<=E;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			graph[x].add(y);
			graph[y].add(x);
		}
		Arrays.fill(arr, -1);
		bfs(start);
		System.out.println(arr[end]);
		
	}
	public static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		arr[start] = 0;
		
		while(!q.isEmpty()) {
			int current = q.poll();
			
			for(int y : graph[current]) {
				if(arr[y] != -1) continue;
				q.add(y);
				arr[y] = arr[current] +1;
			}
		}
	}
	
}
