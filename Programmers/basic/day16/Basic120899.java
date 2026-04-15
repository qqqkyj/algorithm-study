import java.util.*;

public class Basic120899 {
    public int[] solution(int[] array) {
        int[] answer = new int[2];
        int[] clone = array.clone();
        Arrays.sort(clone);
        answer[0] = clone[clone.length-1];
        
        for(int i=0; i<array.length; i++){
            if(array[i] == answer[0]) answer[1]=i;
        }
        return answer;
    }
}