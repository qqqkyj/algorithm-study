import java.util.*;

public class Basic120897 {
    public List<Integer> solution(int n) {
        int[] answer = {};
        List<Integer> list = new ArrayList<>();
        for(int i=1; i<=n; i++){
            if(n%i==0) list.add(i);
        }
        return list;
    }
}