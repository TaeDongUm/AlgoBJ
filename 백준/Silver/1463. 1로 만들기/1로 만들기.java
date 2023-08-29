import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
	static int count, min=Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		calculation(N,count);
		System.out.println(min);
	}
	private static void calculation(int N,int count) {
		if(N ==1) {
			if(min >count) min = count;
			return;
		}
		if(count >=min) return;
		if(N % 3 ==0) {
			calculation(N/3, count+1);
		}
		if(N % 2 ==0) {
			calculation(N/2, count +1);
		}
		calculation(N-1,count+1);
		
	}

}
