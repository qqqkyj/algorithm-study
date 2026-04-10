package day10;

public class Basic120843 {
  class Solution {
    public int solution(int[] numbers, int k) {
        if(k == 1) return numbers[0];
        int cnt = 1 + (k-1)*2;
        if(cnt%numbers.length == 0) return numbers[numbers.length-1];
        return numbers[(cnt%numbers.length)-1];
    }
}
}
