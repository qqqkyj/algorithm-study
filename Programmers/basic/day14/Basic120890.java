package day14;

  import java.util.*;

public class Basic120890 {
  class Solution {
      public int solution(int[] array, int n) {
          Arrays.sort(array);
          int answer = array[0];
          for(int i=1; i<array.length; i++){
              answer = Math.abs(n-array[i]) >= Math.abs(n-answer) ? 
                  answer : array[i];
          }        
          return answer;
      }
  }
}
