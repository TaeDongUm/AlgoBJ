import java.io.*;
import java.util.*;

public class Main{
    static class Cloud{
        int x,y;
        Cloud(int x, int y){
            this.x=x; 
            this.y=y;
        }
            
    }
    static int n, m;
    static int[][] map;
    static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
    static boolean[][] visited;
    static Queue<Cloud> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        q.add(new Cloud(n - 1, 0));
        q.add(new Cloud(n - 1, 1));
        q.add(new Cloud(n - 2, 0));
        q.add(new Cloud(n - 2, 1));

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken()) - 1;
            int s = Integer.parseInt(st.nextToken());
            movingCloud(d, s);
            Magic();
            createCloud();            
        }

        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sum += map[i][j];
            }
        }
        System.out.println(sum);
    }
    public static void movingCloud(int dir, int speed){
        speed%=n;        
        for(Cloud c: q){
            c.x=(c.x+dx[dir]*speed)%n;
            if(c.x<0)
            	c.x+=n;
            c.y=(c.y+dy[dir]*speed)%n;
            if(c.y<0)
            	c.y+=n;            
            map[c.x][c.y]+=1;
        }
        
    }
    public static void Magic(){
    	visited=new boolean[n][n];
        while(!q.isEmpty()){
            Cloud now=q.poll();
            int water=0;
            visited[now.x][now.y]=true;
            for(int i=1; i<8; i+=2){	
                int nx=now.x+dx[i];
                int ny=now.y+dy[i];
                if((nx>=0 && nx<n && ny>=0 && ny<n) && map[nx][ny]>0){
                    water++;
                }                
            }
            map[now.x][now.y]+=water;
        }
    }
    public static void createCloud(){
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(!visited[i][j] && map[i][j]>=2){
                    map[i][j]-=2;
                    q.add(new Cloud(i,j));
                }
            }
        }
    }
}