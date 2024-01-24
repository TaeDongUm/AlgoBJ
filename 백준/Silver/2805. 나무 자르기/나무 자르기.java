import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int N,M;
	static int[] trees;
	static int answer=Integer.MIN_VALUE;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1;
		st1 = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st1.nextToken());
		M = Integer.parseInt(st1.nextToken());
		
		trees = new int[N];
		st1 = new StringTokenizer(br.readLine());
        int max =0;
		for(int i=0;i<N;i++) {
			trees[i] = Integer.parseInt(st1.nextToken());
            max = Math.max(trees[i], max);
		}
		int st = 0;
		int en = max;
		int target = M;
        int min;
		while(st <= en) {
			long sum=0;
			min = (st + en)/2;
			for(int  i=0;i<N;i++) {
				if(min <trees[i]) {
					sum += trees[i] - min;
				}
			}
			if(sum >=target) {
				st = min+1;
				answer = Math.max(answer, min);
				if(sum == target) break;
			}
			if(sum < target) {
				en = min-1;
			}
			
		}
		System.out.println(answer);
		
	}

		
	
}
