import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Basic120903 {
  class Solution {
    public int solution(String[] s1, String[] s2) {
        int answer = 0;
//         1. 내 풀이
//         Map<String, Integer> map = new HashMap<>();
//         for(String s : s1){
//             map.put(s, map.getOrDefault(s, 0) +1);
//         }
//         for(String s : s2){
//             map.put(s, map.getOrDefault(s, 0) +1);
//         }
        
//         for(String key: map.keySet()){
//             if(map.get(key) >= 2) answer++;
//         }
        
//         2. 권장 풀이
        Set<String> set = new HashSet<>(Arrays.asList(s1));
        for(String s: s2){
            if(set.contains(s)) answer++;
        }
        
        return answer;
    }
}
}
