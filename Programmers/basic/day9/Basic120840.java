public class Basic120840 {
  class Solution {
    public long solution(int balls, int share) {
        //조합 nCr = n!/(n-r)!r! = n-r+1Cr
        //분모: n부터 n-r+1까지 곱하기
        //분자: 1부터 r까지 나누가
        long answer = 1;
        for(int i=0; i<share; i++){
            answer *= balls-i;
            answer /= i+1; 
        }
        return answer;
    }
}
}
