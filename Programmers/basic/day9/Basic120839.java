public class Basic120839 {
  class Solution {
    public String solution(String rsp) {
        char[] arr = rsp.toCharArray();
        String answer = "";
        for(char c: arr){
            answer += '0' == c ? "5" : '2' == c ? "0" : "2";
        }

        return answer;
    }
}
