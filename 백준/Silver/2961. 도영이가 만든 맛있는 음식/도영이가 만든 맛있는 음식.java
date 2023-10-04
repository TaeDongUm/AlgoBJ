import java.util.Scanner;
import java.lang.Math;
public class Main {
	static boolean[] isSelected;
	static int N;
	static int[] Sour;
	static int[] Bitter;
	static int minTaste;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		isSelected = new boolean[N];
		Sour = new int[N];
		Bitter = new int[N];
		minTaste =Integer.MAX_VALUE;
		for(int i =0;i<N;i++) {
			Sour[i] = sc.nextInt();
			Bitter[i] = sc.nextInt();
		}
		Cooking(0,1,0);
		System.out.println(minTaste);
	}
	private static void Cooking(int index, int multipleS, int plusB) {
		
		if(index == N) {
			int CountFalse =0;
			for(int i =0;i<N;i++) {
				if(isSelected[i]) continue;
				CountFalse++;
			}
			if(CountFalse==N) return;
			minTaste = Math.min(minTaste, Math.abs(multipleS - plusB));
			return;
		}
		
		isSelected[index] = true;
		Cooking(index+1,multipleS*Sour[index],plusB+Bitter[index]);
		isSelected[index] = false;
		Cooking(index+1, multipleS,plusB);
		
		
	}

}
