import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    static int groupCount=0;
    static boolean[] visited;
    static int[][] map;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        map = new int[N+1][N+1];
        visited = new boolean[N+1];
        
        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int a= Integer.parseInt(st.nextToken());
            int b= Integer.parseInt(st.nextToken());
            map[a][b] = 1;
            map[b][a] = 1;
        }
        for(int i=1;i<visited.length;i++) {
            if(!visited[i]) {
                dfs(map,i);
                groupCount++;
            }
        }
        System.out.println(groupCount);
    }
    
    static void dfs(int[][] map, int x) {

    	if(visited[x]==true) return;
    	
        visited[x] = true;
        for(int i=0;i<map[0].length;i++) {
        	if(map[x][i]==1) {
        		dfs(map, i);
        	}
        }
    }

}