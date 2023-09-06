import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int[] result=new int[41];
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int TC=Integer.parseInt(br.readLine());
        result[0]=0; result[1]=1; result[2]=1;
        for(int i=0;i<TC;i++){
            int n=Integer.parseInt(br.readLine());
            if (n == 0) {
                System.out.println("1 0");
            } else if (n == 1) {
                System.out.println("0 1");
            } else {
                fibo(n);
                System.out.println(result[n-1]+" "+result[n]);
            }

        }
    }

    static int fibo(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            if(result[n]!=0){
                return result[n];
            }
            else{
                result[n]=fibo(n-1) + fibo(n-2);
                return result[n];
            }
        }
    }

}