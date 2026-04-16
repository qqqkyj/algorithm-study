import java.util.*;

public class Basic120904 {
    public int solution(int num, int k) {
        String[] arr = String.valueOf(num).split("");
        String match = String.valueOf(k);
        for(int i=0; i<arr.length; i++){
            if(match.equals(arr[i])) return i+1;
        }
        return -1;
    }
}