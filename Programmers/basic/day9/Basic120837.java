public class Basic120837 {
  class Solution {
    public int solution(int hp) {
        int answer = 0;
        
        // 장군 개미
        while(hp >= 5){
            answer = answer + hp/5;
            hp = hp % 5;
        }
    
        // 병정 개미
        while(hp >= 3){
                answer = answer + hp/3;
                hp = hp % 3;
            }
        
        // 일 개미
        answer += hp;
        
        
        return answer;
    }
}
}
