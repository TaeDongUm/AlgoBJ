import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static String[][] map;
	static int N;
	static int groupCount;
	static int groupName;
	static int groupNameCount;
	static Queue<int[]> q;
	static ArrayList<Integer> q_count;
	static boolean[][] check;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new String[N][N];
		for(int i=0;i<N;i++) {
			map[i] = br.readLine().split("");
		}
		groupCount=0;
		groupName=1;
		q = new LinkedList<>();
		q_count = new ArrayList<>();
		check = new boolean[N][N];
		for(int i =0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j].equals("1") && !check[i][j]){
					groupNameCount =0;
					dfs(map, i, j, groupName);
					groupName++;
				}
			}
		}
		System.out.println(groupCount);
		Collections.sort(q_count);
		for(int i=0;i<q_count.size();i++) {
			System.out.println(q_count.get(i));
		}
	}
	static void dfs(String[][] map, int x, int y, int groupName) {
		q.add(new int[] {x,y});
		check[x][y]= true;
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			int r = now[0];
			int c = now[1];
			map[r][c] = groupName+"";
			groupNameCount++;
			
			for(int i=0;i<4;i++) {
				int nr = r + dx[i];
				int nc = c + dy[i];
				
				if(nr>=0 && nr<N && nc>=0 && nc <N) {
					if(map[nr][nc].equals("1") && !check[nr][nc]) {
						q.add(new int[] {nr,nc});
						check[nr][nc]=true;
					}
				}
			}
		}
		q_count.add(groupNameCount);
		groupCount++;
	}

}
