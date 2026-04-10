import java.util.Arrays;

public class Basic120838 {
  class Solution {
    public String solution(String letter) {
        String[] arr = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        
        String[] strArr = letter.split(" ");
        StringBuilder sb = new StringBuilder();
        for(String s: strArr){
            sb.append((char)(Arrays.asList(arr).indexOf(s) + 'a'));
        }
        
        return sb.toString();
    }
}
}
