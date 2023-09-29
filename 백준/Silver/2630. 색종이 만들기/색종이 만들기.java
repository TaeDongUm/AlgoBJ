import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int whiteCount = 0;
	static int blueCount = 0;
	static int[][] map;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		divide(0,0,N);
		System.out.println(whiteCount);
		System.out.println(blueCount);
	}
	
	public static void divide(int row, int col, int size) {
		if(check(row, col, size)) {
			if(map[row][col]==0) {
				whiteCount++;
			}
			else {
				blueCount++;
			}
			return;
		}
		
		int newsize = size/2;
		divide(row,col,newsize);
		divide(row,col+newsize,newsize);
		divide(row+newsize,col,newsize);
		divide(row+newsize,col+newsize,newsize);
		
	}
	
	public static boolean check(int row, int col, int size) {
		int color = map[row][col];
		
		for(int i =row;i<row+size;i++) {
			for(int j=col;j<col+size;j++) {
				if(map[i][j] != color) {
					return false;
				}
			}
		}
		return true;
	}
	

}
