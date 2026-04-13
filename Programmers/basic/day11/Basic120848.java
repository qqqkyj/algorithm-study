package day11;

import java.util.*;

public class Basic120848 {
   public int solution(int n) {
        int[] arr = new int[11];
        int answer = 1;
        arr[0]=1;
        for(int i=1; i<=10; i++){
            arr[i] = arr[i-1] * i;
            if(arr[i] <= n) answer = i;
        }
        
        return answer;
    }
}
