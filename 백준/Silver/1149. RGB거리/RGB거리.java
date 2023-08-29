import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int money = Integer.MAX_VALUE;
	static int N;
	static int[] prev;
	static int[] present;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		prev = new int[3];
		present = new int[3];
		for(int i =0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<3;j++) {
				present[j] = Integer.parseInt(st.nextToken());
			}
			if(prev[0] <1) {
				prev = Arrays.copyOf(present, present.length);
				continue;
			}
			// present[0]
			if(prev[1] > prev[2]) { 
				present[0] = prev[2] + present[0];
			}else {
				present[0] = prev[1] + present[0];
			}
			// present[1]
			if(prev[0] > prev[2]) { 
				present[1] = prev[2] + present[1];
			}else {
				present[1] = prev[0] + present[1];
			}
			// present[2]
			if(prev[0] > prev[1]) { 
				present[2] = prev[1] + present[2];
			}else {
				present[2] = prev[0] + present[2];
			}
			prev = Arrays.copyOf(present, present.length);
		}
		
		for(int i =0;i<3;i++) {
			if(money >prev[i]) money = prev[i];
		}
		System.out.println(money);
		
	}
}