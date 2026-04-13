package day11;

import java.util.*;

public class Basic120845 {
  class Solution {
    public int solution(int[] box, int n) {
        int answer = 1;
        for(int length : box){
            // 가로, 세로, 높이 각각을 n으로 나눈 후 곱하면 주사위의 최대 개수
            answer *= length/n;
        }
        return answer;
    }
}
}
