package BOJ.basic1;

import java.io.*;

public class Boj1212 {
  public static void main(String[] args) throws Exception {

    // 빠른 입력을 위한 BufferedReader
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // 8진수 문자열 입력
    String str = br.readLine();

    // 결과를 저장할 StringBuilder
    StringBuilder sb = new StringBuilder();

    // 8진수의 각 자리를 순회
    for (int i = 0; i < str.length(); i++) {

      // 문자 → 숫자 변환 ('3' -> 3)
      int n = str.charAt(i) - '0';

      // 8진수 → 2진수 변환
      // 8 = 2^3 이므로 8진수 한 자리는 2진수 3자리로 변환됨
      sb.append(n / 4);      // 2^2 자리 (4의 자리)
      n = n % 4;
      sb.append(n / 2)       // 2^1 자리 (2의 자리)
        .append(n % 2);      // 2^0 자리 (1의 자리)
    }

    // 변환 결과 예시
    // 3 -> 011
    // 1 -> 001
    // 4 -> 100
    // 전체 문자열은 "011001100" 형태가 됨

    // 앞쪽 불필요한 0 제거
    // 예: 011 → 11, 001 → 1
    if (sb.charAt(0) == '0') {
      if (sb.charAt(1) == '0') {
        // "00x" 형태라면 앞의 두 자리 제거
        sb = new StringBuilder(sb.substring(2));
      } else {
        // "0x" 형태라면 앞의 한 자리 제거
        sb = new StringBuilder(sb.substring(1));
      }
    }

    // 최종 2진수 출력
    System.out.print(sb);
  }
}