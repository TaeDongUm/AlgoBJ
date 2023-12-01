import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] position;
	static int goal, start, up, down, building, depth;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		building = Integer.parseInt(st.nextToken());
		position = new int[building];
		
		start = Integer.parseInt(st.nextToken());
		goal = Integer.parseInt(st.nextToken());
		up = Integer.parseInt(st.nextToken());
		down = Integer.parseInt(st.nextToken());
		
		System.out.println(bfs(position, start, goal));
		
	}
	public static String bfs(int[] position, int start, int goal) {
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		position[start-1] = 1;
		
		while(!q.isEmpty()) {
			int current = q.poll();
			if(current == goal) {
				return String.valueOf(position[current-1]-1);
			}
			if(current + up <=building) {
				if(position[current +up-1] ==0) {
					position[current + up -1] = position[current-1]+1;
					q.add(current + up);
				}
			}
			if(current -down >=1) {
				if(position[current - down-1] ==0) {
					position[current - down -1] = position[current-1]+1;
					q.add(current-down);
				}
			}
			
			
		}
		return "use the stairs";
	}
}
