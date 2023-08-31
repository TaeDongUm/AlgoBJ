import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int[] switch1=new int[n];
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			switch1[i]=Integer.parseInt(st1.nextToken());
		}
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		int m=Integer.parseInt(st2.nextToken());
		for(int i=0;i<m;i++) {
			StringTokenizer st3 = new StringTokenizer(br.readLine());
			int gen=Integer.parseInt(st3.nextToken());
			int num=Integer.parseInt(st3.nextToken())-1;
			if(gen==1) {
				for(int j=num;j<n;j+=num+1) {
					switch1[j]=1-switch1[j];
				}
			}else {
				int mk=Math.min(num, n-1-num);
				switch1[num]=1-switch1[num];
				for(int j=1;j<=mk;j++) {
					if(switch1[num-j]!=switch1[num+j])
						break;
					switch1[num-j]=1-switch1[num-j];
					switch1[num+j]=1-switch1[num+j];
				}
			}
		}
		
		for(int i=0;i<n;i++) {
			if(i%20==0 && i>0) {
				System.out.println();
			}
			System.out.print(switch1[i]+" ");
		}

	}



}