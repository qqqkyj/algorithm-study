import java.util.*;

public class Basic120905 {
    public List<Integer> solution(int n, int[] numlist) {
        List<Integer> list = new ArrayList<Integer>();
        for(int i=0; i<numlist.length; i++){
            if(numlist[i]%n==0) list.add(numlist[i]);
        }
        return list;
    }
}