import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static Queue<int[]> q;
	static int N;
	static int groupCount;
	static int max = -1;
    static int maxHeight=-1;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		q = new LinkedList<>();
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
                if(maxHeight <map[i][j]) maxHeight = map[i][j];
			}
		}
		for(int i=0;i<=maxHeight;i++) {
			rain(map,i);
			safeZone(map, 0,0);
		}
		System.out.println(max);
		
	}
	static void rain(int[][] map, int depth) {
		for(int i=0;i<map.length;i++) {
			for(int j=0;j<map[i].length;j++) {
				if(map[i][j]==0) continue;
				if(map[i][j]<=depth) map[i][j]=0;
			}
		}
		
	}
	
	static void safeZone(int[][] map, int x, int y) {
		visited = new boolean[N][N];
		groupCount=0;
		for(int i=0;i<map.length;i++) {
			for(int j=0;j<map[i].length;j++) {
				if(visited[i][j]) continue;
				if(map[i][j] !=0) {
					q.add(new int[] {i,j});
					visited[i][j] = true;
					
					while(!q.isEmpty()) {
						int[] now = q.poll();
						int r = now[0];
						int c = now[1];
						
						for(int k =0;k<4;k++) {
							int nr = r + dx[k];
							int nc = c + dy[k];
							
							if(nr>=0 && nr<N && nc >=0 && nc<N) {
								if(map[nr][nc] !=0 && visited[nr][nc] == false) {
									q.add(new int[] {nr,nc});
									visited[nr][nc] = true;
								}
							}
							
						}
								
					}
					groupCount++;
					
				}
			}
		}
		if(max <groupCount) max = groupCount;
		
	}

}
