import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for(int i=0;i<T;i++) {
			st = new StringTokenizer(br.readLine());
			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			if(H !=1) {
				if(N %H !=0)System.out.println((N % H)*100+(N/H)+1);
				else {
					System.out.println((H)*100+(N/H));
				}
			}else {
				System.out.println(H*100+N);
			}
			
		}
		
	}

}
