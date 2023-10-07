import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int a_count, c_count, g_count, t_count;
	static int fpoint, rpoint, answer;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int L = Integer.parseInt(st.nextToken());
		int pL = Integer.parseInt(st.nextToken());
		fpoint=0;
		rpoint=pL;
		answer=0;
		String[] arr = br.readLine().split("");
		
		st = new StringTokenizer(br.readLine());
		int[] acgt = new int[4];
		int[] acgt_count = new int[4];
		for(int i=0;i<4;i++) {
			acgt[i] = Integer.parseInt(st.nextToken());
		}
		for(int i =0;i<pL;i++) {
			if(arr[i].equals("A")) acgt_count[0]++;
			if(arr[i].equals("C")) acgt_count[1]++;
			if(arr[i].equals("G")) acgt_count[2]++;
			if(arr[i].equals("T")) acgt_count[3]++;
		}
		for(int i=0;i<4;i++) {
			if(acgt[i]>acgt_count[i]) break;
			if(i==3) answer++;
		}
		
		while(true) {
			if(arr.length ==1) break;
            
			if(arr[fpoint].equals("A")) acgt_count[0]--;
			if(arr[fpoint].equals("C")) acgt_count[1]--;
			if(arr[fpoint].equals("G")) acgt_count[2]--;
			if(arr[fpoint].equals("T")) acgt_count[3]--;
			
			if(arr[rpoint].equals("A")) acgt_count[0]++;
			if(arr[rpoint].equals("C")) acgt_count[1]++;
			if(arr[rpoint].equals("G")) acgt_count[2]++;
			if(arr[rpoint].equals("T")) acgt_count[3]++;
			
			for(int i=0;i<4;i++) {
				if(acgt[i]>acgt_count[i]) break;
				if(i==3) answer++;
			}
			fpoint++;
			rpoint++;
			if(fpoint>L-pL) break;
			if(rpoint>=L) break;
			
		}
		System.out.println(answer);
		
	}

}
