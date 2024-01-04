import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.util.Arrays;

public class Main{
    static int[] arr;
    static int[] check;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int M = Integer.parseInt(br.readLine());
        check = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<M;i++){
            check[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=0;i<M;i++){
            System.out.println(binarySearch(arr, check[i]));
        }
    }
    
    public static int binarySearch(int[] arr, int target){
        int st = 0;
        int en = arr.length-1;
        
        
        while(st <= en){
            int mid = (st + en)/2;
            if(arr[mid] < target){
                st = mid +1;
            }else if(arr[mid] > target){
                en = mid -1;
            }else{
                return 1;
            }
        }
        return 0;
    }
}