package day12;

import java.util.*;
  
public class Basic120850 {
  class Solution {
    public List<Integer> solution(String my_string) {
        List<Integer> list = new ArrayList<>();
        for(char c: my_string.toCharArray()){
            if('0' <= c && c<='9')
                list.add(c - 48);
        }
        
        Collections.sort(list);
        
        return list;
    }
}
}
