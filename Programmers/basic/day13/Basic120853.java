package day13;

public class Basic120853 {
  class Solution {
    public int solution(String s) {
        int answer = 0;
        String[] arr = s.split(" ");
        for(int i=0; i<arr.length; i++){
            if("Z".equals(arr[i])){
                answer-=Integer.parseInt(arr[i-1]);
            }
            else{
                answer+=Integer.parseInt(arr[i]);
            }
        }
        return answer;
    }
}
}
