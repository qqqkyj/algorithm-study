package day8;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Basic120835 {
  public int[] solution(int[] emergency) {
        // 원본 배열 복사(emergency.clone()) 후 오름차순 정렬
        int[] copy = Arrays.copyOf(emergency, emergency.length);
        Arrays.sort(copy);
        
        // map에 해당 값(key)과 순위(value)저장 => 가장 마지막이 1
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int cnt = 1;
        for(int i = copy.length-1; i >= 0 ; i--){
            map.put(copy[i], cnt++);
        }
        
        // answer배열에 emergency배열의 각 원소를 key가진 value를 추가
        int[] answer = new int[emergency.length];
        for(int j = 0; j < emergency.length; j++){
            answer[j] = map.get(emergency[j]);
        }
        
        return answer;
    }
}
