import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int N,M;
	static int[] trees;
	static int maxHeight, answer=Integer.MIN_VALUE;
	static int minHeight=Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		trees = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			trees[i] = Integer.parseInt(st.nextToken());
			
		}
		Arrays.sort(trees);
		binaryS(trees);
		System.out.println(answer);
		
	}
	
	public static void binaryS(int[] trees) {
		int st = 0;
		int en = trees[trees.length-1];
		int target = M;
		while(st <= en) {
			long sum=0;
			int min = (st + en)/2;
			for(int  i=0;i<N;i++) {
				if(min <trees[i]) {
					sum += trees[i] - min;
				}
			}
			if(sum >=target) {
				st = min+1;
				answer = Math.max(answer, min);
				if(sum == target) return;
			}
			if(sum < target) {
				en = min-1;
			}
			
		}
		
	}
}
