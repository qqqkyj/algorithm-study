package day12;

import java.util.*;

public class Basic120852 {
  class Solution {
      public List<Integer> solution(int n) {
          List<Integer> set = new ArrayList<>();
          for(int i=2; i*i<=n; i++){
                  if(n%i==0){
                      while(n%i==0) n/=i;
                      set.add(i);
                  }
              }
          
          if(n > 1) set.add(n);
          
          return set;
      }
  }
}
