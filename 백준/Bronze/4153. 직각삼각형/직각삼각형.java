import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String line;
        while(!(line = br.readLine()).equals("0 0 0") ){
            String[] num = line.split(" ");
            int a = Integer.parseInt(num[0]);
            int b = Integer.parseInt(num[1]);
            int c = Integer.parseInt(num[2]);
            int[] tmp = new int[]{a,b,c};
            
            Arrays.sort(tmp);
            if(tmp[0]*tmp[0] + tmp[1]*tmp[1] == tmp[2]*tmp[2]){
                System.out.println("right");
            }else{
                System.out.println("wrong");
            }
            
        }
       
        
    }
}