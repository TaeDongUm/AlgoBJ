import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
 
class road{
    int start;
    int end;
    int length;
 
    public road(int start, int end, int length) {
        this.start = start;
        this.end = end;
        this.length = length;
    }
}
 
 
public class Main {
 
    static List<road> list;
    static int N,D;
    static int result = Integer.MAX_VALUE;
    static boolean [] check;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
 
        N = Integer.parseInt(s[0]);
        D = Integer.parseInt(s[1]);
 
 
        list = new ArrayList<>();
 
        int start,end, cost;
 
        for(int i=0; i<N; i++){
            String[] s1 = br.readLine().split(" ");
            start = Integer.parseInt(s1[0]);
            end = Integer.parseInt(s1[1]);
            cost = Integer.parseInt(s1[2]);
            if(start>D|| end>D){
                continue;
            }
            list.add(new road(start,end,cost));
        }
 
        check = new boolean[list.size()];
        dfs(0,D,0);
 
        System.out.println(result);
    }
 
    private static void dfs(int start, int end, int distance){
        if(start>end){
            return;
        }
        else if(start==end){
            result= Math.min(result,distance);
            return;
        }
        else{
            result = Math.min(result, distance+(end-start));
        }
 
        for(int i=0; i<list.size(); i++){
            if(!check[i]){
            	road road = list.get(i);
                if(road.start==start){
                    check[i]=true;
                    dfs(road.end, D, distance+ road.length);
                    check[i]=false;
                }
            }
        }
        dfs(start+1, D, distance+1);
 
    }
}