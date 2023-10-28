import java.util.*;
class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        boolean answer = true;

        for(int i =0;i<s.length();i++){
            if(s.charAt(i)=='(')stack.push(s.charAt(i));
            if(s.charAt(i)==')'){
                if(!stack.isEmpty()){
                    stack.pop();
                }else{
                  answer=false;  
                  break;
                } 
            }
        }
        if(!stack.isEmpty()) answer=false;
        return answer;
    }
}