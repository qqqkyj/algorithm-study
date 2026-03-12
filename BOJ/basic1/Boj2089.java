package BOJ.basic1;

import java.io.*;

public class Boj2089 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();
    
    // -2진수 변환 과정
    // 일반 2진수와 동일하게 "나머지"를 구해가며 진법 변환을 수행
    
    // 나머지가 음수일 때 보정이 필요
    // n: 몫, r: 나머지 (r = n % -2)

    // 기본 진법 공식
    // x = (-2 * 몫) + 나머지

    // 하지만 Java에서 n % -2 계산 시 나머지가 -1이 될 수 있음
    // 진법 표현에서는 나머지가 반드시 0 또는 1이어야 하므로 보정 필요

    // r < 0 일 때
    // r += 2
    // 몫 += 1
    // 이유:
    // x = -2*n + r
    // x = -2*(n+1) + (r+2)
    // → 값은 동일하지만 나머지를 양수(0 또는 1)로 만들 수 있음

    if (n == 0)
      sb.append(n);

    while (n != 0) {
      if (n % -2 < 0) { // 나머지가 음수인 경우
        sb.append(n % -2 + 2); // 나머지를 0 또는 1로 보정
        n = n / -2 + 1; // 몫도 함께 보정
      } else { // 나머지가 정상(0 또는 1)
        sb.append(n % -2); // 그대로 결과에 추가
        n = n / -2; // 몫 갱신
      }
    }

    // 나머지는 낮은 자리부터 저장되므로 뒤집어서 출력
    System.out.print(sb.reverse());
  }
}