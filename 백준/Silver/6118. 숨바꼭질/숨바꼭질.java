import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<ArrayList<Integer>> list;
	static boolean[] visited;
	static int cnt;
	static int[] answer;
	static int max;
	static boolean flag;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		list = new ArrayList<>();
		visited = new boolean[N + 1];
		answer = new int[N + 1];
		
		for (int i = 0; i < N + 1; i++) {
			list.add(new ArrayList<>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list.get(a).add(b);
			list.get(b).add(a);
		}
		bfs(N, M, list, visited);
		
		int cnt = 0;
		for (int i = 1; i < N + 1; i++) {
			if (flag == false && answer[i] == max) {
				System.out.print(i + " ");
				flag = true;
			}
			if (answer[i] == max) {
				cnt++;
			}
		}
		System.out.print(max + " " + cnt);
	}

	private static void bfs(int N, int M, ArrayList<ArrayList<Integer>> list, boolean[] visited) {
		Queue<Integer> q = new LinkedList<>();
		q.add(1);
		visited[1] = true;
		cnt = 0;

		while (!q.isEmpty()) {
			int now = q.poll();
			for (int next : list.get(now)) {
				if (visited[next] == false) {
					visited[next] = true;
					if (answer[next] == 0) {
						answer[next] = answer[now] + 1;
						max = answer[next];
					}
					q.add(next);
				}
			}
		}
	}

}