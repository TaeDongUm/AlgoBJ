import java.io.*;
import java.util.StringTokenizer;

public class Main { 

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int n=Integer.parseInt(st.nextToken());
		int r=Integer.parseInt(st.nextToken());
		int c=Integer.parseInt(st.nextToken());
		
		int k,ans=0,half, ref;
		while(n>0) {
			k=3;
			half=(int) Math.pow(2, n-1);
			ref=(int) Math.pow(2, 2*n)/4;
			
			if(r<half) k-=2;
			else r-=half;
			
			if(c<half) k-=1;
			else c-=half;
			
			ans+=ref*k;
			n-=1;
		}

		System.out.println(ans);
		br.close();
	}

}