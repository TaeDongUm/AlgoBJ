import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int[][] map;
	static int[][] home;
	static int[][] chicken;
	static int cntHome, cntChicken;
	static boolean[] ok;
	static int min=Integer.MAX_VALUE;
	static Queue<Integer> queue;
	static int result;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		queue = new LinkedList<>();
		map = new int[N][N];
		for(int i =0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// home count
		cntHome =0;
		for(int i= 0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j] == 1) {
					cntHome++;
				}
			}
		}
		cntChicken=0;
		for(int i= 0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j] == 2) {
					cntChicken++;
				}
			}
		}
		ok = new boolean[cntChicken];
		int home_index=0;
		int chicken_index=0;
		home = new int[cntHome][2];
		chicken = new int[cntChicken][2];
		for(int i= 0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j] == 1) {
					home[home_index] = new int[] {i,j};
					home_index++;
				}
				if(map[i][j] ==2) {
					chicken[chicken_index] = new int[] {i,j};
					chicken_index++;
				}
			}
		}
		calculation(M, chicken, home, 0,0);
		int size = queue.size();
		int[] distance = new int[size];
		for(int i =0;i<size;i++) {
			distance[i] = queue.poll();
		}
		for(int i=0;i<distance.length;i++) {
			if(min>distance[i]) {
				min = distance[i];
			}
		}
		System.out.println(min);
		
	}
	public static void calculation(int M, int[][] chicken, int[][] home, int index,int depth) {

		if(depth == M) {	
			int result=0;
			for(int j =0;j<home.length;j++) {
				int min =98;
				for(int i=0;i<chicken.length;i++) {
					if(ok[i]) {
						int length = Math.abs(chicken[i][0]-home[j][0]) + Math.abs(chicken[i][1]-home[j][1]);
						min = Math.min(min, length);
					}
				}
				result += min;
			}
			queue.add(result);
			return;
		}
		for(int i=index;i<ok.length;i++) {
			ok[i] = true;
			calculation(M, chicken, home, i+1,depth+1);
			ok[i] = false;
		}
	}
}