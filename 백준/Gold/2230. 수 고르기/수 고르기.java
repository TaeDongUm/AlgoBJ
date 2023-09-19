import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int min = Integer.MAX_VALUE;
    static int px,py,N,M;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        px =0;
        py =0;
        ArrayList<Integer>arr = new ArrayList<>();
        int[] result = new int[2];
        for(int i =0;i<N;i++) {
            arr.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(arr);
        calculation(arr);
        System.out.println(min);
    }
    public static void calculation(ArrayList<Integer> arr) {
    	while(px<N) {
    		if(arr.get(px)-arr.get(py)<M) {
    			px++;
    			continue;
    		}
    		if(arr.get(px)-arr.get(py)==M) {
    			min = M;
    			break;
    		}
    		min = Math.min(min, arr.get(px)-arr.get(py));
            py++;
    	}
    }

}
