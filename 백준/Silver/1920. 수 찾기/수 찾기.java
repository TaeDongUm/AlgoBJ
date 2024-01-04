import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.Arrays;

public class Main{
    static int[] arr;
    static int[] check;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw =  new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws Exception{

        StringTokenizer s;
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        
        s = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(s.nextToken());
        }
        Arrays.sort(arr);
        int M = Integer.parseInt(br.readLine());
        check = new int[M];
        s = new StringTokenizer(br.readLine());
        for(int i=0;i<M;i++){
            check[i] = Integer.parseInt(s.nextToken());
        }

        for(int i=0;i<M;i++){
           int target = check[i];
           int st = 0;
           int en = arr.length-1;
        
           int check =1;
            while(st <= en){
                int mid = (st + en)/2;
               if(arr[mid] < target){
                   st = mid +1;
                }else if(arr[mid] > target){
                    en = mid -1;
                }else{
                    check =0;
                    break;
                }
            }
            if(check ==1){
                bw.append(0 + "\n");
            }else{
                bw.append(1 + "\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }

}