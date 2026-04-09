package day8;

public class Basic120836 {
  // 약수의 개수
    public int solution(int n) {
        int answer = 0;
        for(int i = 1; i*i <= n; i++){
            if(n % i == 0) {
                if(n / i == i) answer++; //제곱인 경우 1만 더하기
                else answer += 2; // 그 외는 쌍을 이룸
            }
        }
        return answer;
    }
}
