package day13;

public class Basic120888 {
  import java.util.*;

// 권장 방식 : LinkedHashSet (순서 보장 및 중복 제거)
class Solution {
    public String solution(String my_string) {
        Set<Character> set = new LinkedHashSet<>();
        for(char c: my_string.toCharArray()){
            set.add(c);
        }
        
        StringBuilder sb = new StringBuilder();
        for(char c: set){
            sb.append(c);         
        }
        
        return sb.toString();
    }
}
}
