import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static int length;
	static int[][] dp;
	static int[] dx= {-1,1,0,0};
	static int[] dy= {0,0,-1,1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		
		int row = Integer.parseInt(st.nextToken());
		int col = Integer.parseInt(st.nextToken());
		
		map= new int[row][col];
		dp = new int[row][col];
		length = 0;
		
		for(int i=0;i<row;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<col;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = -1;
			}
		}
		int answer = dfs(map, dp, 0,0);
		System.out.println(answer);
		
	}
	
	static int dfs(int[][] map, int[][]dp, int x, int y) {
		if(x == map.length-1 && y == map[0].length-1) {
			return 1;
		}
		
		if(dp[x][y]==-1) {
			dp[x][y]=0;
			for(int i=0;i<4;i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx>=0 && nx<map.length && ny>=0 && ny<map[0].length) {
					if(map[nx][ny] < map[x][y]) {
						dp[x][y] += dfs(map,dp,nx,ny );
					}
				}
			}
		}
		return dp[x][y];
	}

}
