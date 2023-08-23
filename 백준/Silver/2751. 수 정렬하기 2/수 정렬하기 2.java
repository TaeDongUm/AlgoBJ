import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static int maxplus = -1_000_000;
	static int minplus = Integer.MAX_VALUE;
	static int maxminus = -1_000_000;
	static int minminus = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int[] arrplus = new int[1_000_001];
		int[] arrminus = new int[1_000_001];
		boolean plus=false;
		boolean minus=false;
		int N = Integer.parseInt(br.readLine());
		for(int i=0;i<N;i++) {
			int num = Integer.parseInt(br.readLine());
			if(num>=0) {
				plus = true;
				if(maxplus<num) maxplus = num;
				if(minplus >num) minplus = num;
				arrplus[num] = num;
			}else {
				minus =true;
				if(maxminus<num*(-1)) maxminus = num*(-1);
				if(minminus >num*(-1)) minminus = num*(-1);
				arrminus[num*(-1)] = num;
			}
		}
		if(minus) {
			for(int j=maxminus;j>=minminus;j--) {
				if(arrminus[j] !=0) {
					bw.write(arrminus[j]+" ");
					bw.newLine();
				}
			}
			
		}
		if(plus) {
			for(int j=minplus;j<=maxplus;j++) {
				if(arrplus[j]==0) {
					if(minplus == j) {
						bw.write(arrplus[j]+" ");
						bw.newLine();
					
					}
				}else if(arrplus[j] !=0){
						bw.write(arrplus[j]+" ");
						bw.newLine();
				}
					
			
			}
		}
		bw.flush();
		bw.close();
	}

}