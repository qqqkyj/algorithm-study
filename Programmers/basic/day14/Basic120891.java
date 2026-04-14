package day14;

public class Basic120891 {
  class Solution {
    public int solution(int order) {
        int answer = 0;
        for(String s: String.valueOf(order).split("")){
            if("3".equals(s) || "6".equals(s) || "9".equals(s)) answer++;
        }
        return answer;
    }
}
}
