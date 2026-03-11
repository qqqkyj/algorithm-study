package BOJ.basic1;

import java.util.*;
import java.io.*;

public class Boj1934 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // 테스트 케이스의 개수 입력
    int n = Integer.parseInt(br.readLine());
    StringTokenizer st;
    
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      // 최소공배수를 구할 두 수 입력
      int num1 = Integer.parseInt(st.nextToken());
      int num2 = Integer.parseInt(st.nextToken());
      
      // 1. 유클리드 호제법을 통해 최대공약수(GCD) 계산
      int gcd = gcd(num1, num2);
      
      // 2. 두 수의 곱을 최대공약수로 나누어 최소공배수(LCM) 산출 및 출력
      // 공식: LCM(a, b) = (a * b) / GCD(a, b)
      System.out.println(num1*num2/gcd);
    }
  }

  // 최대공약수(Greatest Common Divisor) 계산 메서드
  static int gcd(int num1, int num2) {
    // 두 수 중 큰 값을 num1으로 위치시키기 위한 정렬
    if (num1 < num2) {
      int tmp = num1;
      num1 = num2;
      num2 = tmp;
    }

    // 유클리드 호제법 반복문: 나머지가 0이 될 때까지 나눔
    while (num2 != 0) {
      int r = num1 % num2; // 나머지 계산
      num1 = num2;         // 큰 수를 작은 수로 교체
      num2 = r;            // 작은 수를 나머지로 교체
    }

    // 나머지가 0이 되었을 때의 나누는 수가 최대공약수
    return num1;
  }
}