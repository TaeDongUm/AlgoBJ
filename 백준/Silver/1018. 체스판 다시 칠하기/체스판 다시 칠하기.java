import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static String[][] map;
	static int count;
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		map = new String[N][M];
		
		for(int i =0;i<N;i++) {
			map[i] = br.readLine().split("");
		}
		int a = N-8;
		int b = M-8;
		for(int i =0;i<=a;i++) {
			for(int l=0;l<=b;l++) {
				count=0;
				for(int j=0+i;j<8+i;j++) {
					for(int k=0+l;k<8+l;k++) {
						if(((j+k)%2==0) && map[j][k].equals("W")) continue;
						if(((j+k)%2!=0) && map[j][k].equals("B")) continue;
						count++;
						
					}
				}
				int result = Math.min(count, 64-count);
				if(min > result) min = result;

			}
		}
		System.out.println(min);
		
	}

}
