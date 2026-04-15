import java.util.*;

public class Basic120896 {
    public String solution(String s) {     
        Map<Character, Integer> map = new HashMap<>();
        for(char c: s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        
        List<Character> keySet = new ArrayList<>(map.keySet());
        Collections.sort(keySet);
        
        StringBuilder sb = new StringBuilder();
        for(char key: keySet){
            if(map.get(key) == 1) sb.append(key);
        }
        
        return sb.toString();
    }
}