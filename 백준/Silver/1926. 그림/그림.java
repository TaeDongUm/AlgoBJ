import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int picCount=0;
	static int maxArea = Integer.MIN_VALUE;
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[n][m];
		int[][] visited = new int[n][m];
		for(int i = 0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		bfs(map, visited, n, m);
		if(picCount ==0) {
			System.out.println(0);
			System.out.println(0);
		}else {
			System.out.println(picCount);
			System.out.println(maxArea);
			
		}
	}
	
	static void bfs(int[][] map, int[][] visited, int n, int m) {
		Queue<int[]> q = new LinkedList<>();
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(map[i][j] ==1 && visited[i][j] !=1) {
					visited[i][j] = 1;
					q.add(new int[] {i,j});
					int tmpArea = 1;
					while(!q.isEmpty()) {
						int[] cur = q.poll();
						int x = cur[0];
						int y = cur[1];
						
						for(int k= 0;k<4;k++) {
							int nx = x + dx[k];
							int ny = y + dy[k];
							
							if(nx <n && nx >=0 && ny <m && ny >=0) {
								if(map[nx][ny] ==1 &&visited[nx][ny] !=1) {
									q.add(new int[] {nx, ny});
									visited[nx][ny] =1;
									tmpArea++;
								}
							}
						}
					}
					picCount++;
					if(maxArea < tmpArea) maxArea = tmpArea;
				}
				
			}
		}
	}

}
