package day18;

import java.util.*;

public class Basic120910 {
  public int solution(int n, int t) {
        //1. 내 풀이
        // int answer = n;
        // for(int i=0; i<t; i++){
        //     answer*=2;
        // }
        // return answer;
        
        //2. 권장 풀이
        return n << t;
    }
}
