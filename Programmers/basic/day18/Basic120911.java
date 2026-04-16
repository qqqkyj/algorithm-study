package day18;

import java.util.*;

public class Basic120911 {
  public String solution(String my_string) {
        //1. 내 풀이
        // my_string = my_string.toLowerCase();
        // String[] arr = my_string.split("");
        // Arrays.sort(arr);
        // StringBuilder sb = new StringBuilder();
        // for(String s: arr){
        //     sb.append(s);
        // }
        // return sb.toString();
        
        //2. 권장 방식
        char[] arr = my_string.toLowerCase().toCharArray();
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        for(char c: arr){
            sb.append(c);
        }
        
        return sb.toString();
    }
}
