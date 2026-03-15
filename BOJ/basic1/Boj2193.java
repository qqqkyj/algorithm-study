package BOJ.basic1;

import java.io.*;

public class Boj2193 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    int n = Integer.parseInt(br.readLine()); // 길이가 n인 이친수의 개수 구하기
    
    System.out.print(dp(n)); // 결과 출력
  }

  static long dp(int n) {

    long[][] d = new long[n + 1][2];

    // 점화식
    // 마지막이 0인 경우 → 이전이 0 또는 1 모두 가능
    // d[i][0] = d[i-1][0] + d[i-1][1]

    // 마지막이 1인 경우 → 이전은 반드시 0이어야 함 (11 불가능)
    // d[i][1] = d[i-1][0]

    // 길이가 1일 때 가능한 이친수
    // "1" 하나뿐
    d[1][1] = 1;

    // 길이 2부터 n까지 DP 계산
    for (int i = 2; i <= n; i++) {

      // 마지막 숫자가 0인 경우
      d[i][0] = d[i - 1][0] + d[i - 1][1];

      // 마지막 숫자가 1인 경우
      d[i][1] = d[i - 1][0];
    }

    // 길이가 n인 모든 이친수 개수
    return d[n][0] + d[n][1];
  }
}