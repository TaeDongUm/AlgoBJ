import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int M, N, count, preTomato;
	static int[][] map;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	static Queue<int[]> q = new LinkedList<>();
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		count = 0;
		preTomato =0;
		
		for(int i = 0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) {
					q.add(new int[] {i,j});
				}
				if(map[i][j] == 0) preTomato++;
				
			}
		}
		bfs(map);
		if(preTomato != 0) System.out.println(-1);
		if(preTomato == 0) {
			if(count ==0) System.out.println(0);
			if(count !=0) System.out.println(count-1);
		}
		
	}
	
	public static void bfs(int[][] map) {
		while(!q.isEmpty()) {
			int[] temp = q.poll();
			int x = temp[0];
			int y = temp[1];
			
			for(int i=0;i<4;i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx >=0 && nx<N && ny >=0 && ny<M) {
					if(map[nx][ny] == 0) {
						preTomato--;
						map[nx][ny] = map[x][y]+1;
						count = Math.max(count, map[nx][ny]);
						q.add(new int[] {nx,ny});
					}
				}
			}
		}
	}

}
