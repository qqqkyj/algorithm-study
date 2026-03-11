package BOJ.basic1;

import java.io.*;

public class Boj6588 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    // 1. 프로그램 시작 시 최대 범위(1,000,000)까지의 소수 판별 배열을 한 번만 생성
    // (매번 소수를 구하지 않아 시간 복잡도가 대폭 감소함)
    boolean[] check = isPrime(1000000);
    
    int num;
    // 0이 입력될 때까지 테스트 케이스 반복 처리
    while ((num = Integer.parseInt(br.readLine())) != 0) {
      
      // 2. 골드바흐의 추측 검증: 두 홀수 소수의 합 찾기
      // 문제 조건에 따라 가장 작은 홀수 소수인 3부터 순회
      for (int i = 3; i < num; i++) {
        // i와 (num - i)가 모두 소수인지 미리 만들어둔 check 배열로 확인
        if (!check[i] && !check[num-i]) {
          // 찾은 즉시 출력하고 break (i가 작을수록 b-a가 최대가 됨)
          System.out.println(num + " = " + i + " + " + (num - i));
          break;
        }
      }
    }
  }

  // 에라토스테네스의 체 알고리즘: 소수가 아닌 수를 true로 마킹
  static boolean[] isPrime(int num) {
    boolean[] check = new boolean[num+1]; // false가 소수
    check[0] = true; // 0은 제외
    check[1] = true; // 1은 제외

    // 2부터 시작하여 발견된 소수의 배수들을 지워나감
    for (int i = 2; i <= num; i++) {
      if (!check[i]) { // i가 소수일 때만 그 배수들을 처리
        // i*2, i*3... 배수들을 소수 후보에서 제외
        for (int j = i + i; j <= num; j += i) { 
          check[j] = true;
        }
      }
    }
    return check;
  }
}