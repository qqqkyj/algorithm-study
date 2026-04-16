package day18;

import java.util.*;

public class Basic120909 {
    public int solution(int n) {
        for(int i=1; i<n; i++){
            if(Math.pow(i,2) == n) return 1;
        }
        return 2;
    }
}
