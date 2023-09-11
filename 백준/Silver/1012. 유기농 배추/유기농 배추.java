import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dx= {-1,1,0,0};
    static int[] dy= {0,0,-1,1};
    static int areaCount=0;
    static Queue<int[]> q = new LinkedList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[][] map;
        boolean[][] check;
        int T = Integer.parseInt(br.readLine());
        for(int i =0;i<T;i++) {
        	areaCount =0;
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            
            map = new int[M][N];
            check = new boolean[M][N];
            
            for(int j =0;j<K;j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                
                map[x][y] = 1;
            }
            countMap(map, check);
            System.out.println(areaCount);
                
        }
    }
    
    public static void countMap(int[][] map, boolean[][] check) {
        for(int i=0;i<map.length;i++) {
            for(int j=0;j<map[i].length;j++) {
                if(check[i][j]== true) continue;
                if(map[i][j] ==1) {
                    check[i][j]= true;
                    q.add(new int[] {i,j});
                    while(!q.isEmpty()) {
                    	int[] current = q.poll();
	                    for(int k=0;k<4;k++) {
	                        int nx = current[0] +dx[k];
	                        int ny = current[1] +dy[k];
	                        
	                        if(nx>=0 && nx<map.length && ny>=0 && ny<map[0].length){
	                            if(map[nx][ny] == 1 && check[nx][ny] == false ) {
	                            	check[nx][ny] = true;
	                            	q.add(new int[] {nx, ny});
	                            }
	                        }
	                            
	                        
	                    }
	                    if(q.isEmpty()) areaCount++;
                    }
                }
            }
        }
    }

}