import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int max = Integer.MIN_VALUE;
	static int N;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		List<Integer> list = new ArrayList<>();
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		dfs(list, 0,0,0);
		System.out.println(max);
		
	}
	
	public static void dfs(List<Integer> list, int depth, int index, int calculation) {
		if(list.size()==2) {
			if(max <calculation) max = calculation;
		}
		
		for(int i=1;i<list.size()-1;i++) {
			int cal = list.get(i-1)*list.get(i+1);
			List<Integer> newlist = new ArrayList<>(list);
			newlist.remove(i);
			dfs(newlist,depth+1,i,calculation + cal);
		}
		
	}
}
