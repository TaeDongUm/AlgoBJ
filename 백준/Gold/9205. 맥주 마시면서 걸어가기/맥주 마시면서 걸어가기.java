import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;
import java.lang.Math;

public class Main {
	static int n, sx,sy,px,py;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		for(int i=0;i<t;i++) {
			List<int[]> list = new ArrayList<>();
			n = Integer.parseInt(br.readLine());
			for(int j =0;j<n+2;j++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				if(j==0) {
					// 상근이네 집 좌표
					sx = x;
					sy = y;
				}else if(j==n+1) {
					// 페스티벌 좌표
					px = x;
					py = y;
				}else {
					// 편의점 좌표
					list.add(new int[]{x,y});
				}
				
			}
			if(bfs(list)) {
				System.out.println("happy");
			}else {
				System.out.println("sad");
			}
		}
	}
	static boolean bfs(List<int[]> list) {
		Queue<int[]> q = new LinkedList<>();
		boolean[] visited = new boolean[n];
		q.add(new int[]{sx,sy});
		int i =0;
		while(!q.isEmpty()) {
			int[] position = q.poll();
			int a = position[0], b = position[1];
			if(Math.abs(a-px)+Math.abs(b-py)<=1000) {
				return true;
			}
			for(int j =0;j<n;j++) {
				if(!visited[j]) {
					// convenience store
					int[] cs= list.get(j);
					int x = cs[0], y=cs[1];
					if(Math.abs(a-x)+Math.abs(b-y)<=1000) {
						q.add(new int[] {x,y});
						visited[j]=true;
					}
				}
			}
		}
		return false;
	}

}