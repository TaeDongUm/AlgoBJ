import java.util.Scanner;
import java.lang.Math;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int sum=0;
        for(int i =0;i<5;i++){
            int a = sc.nextInt();
            sum += Math.pow(a,2);
        }
        sum %=10;
        System.out.println(sum);
    }
}
