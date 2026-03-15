package BOJ.basic1;

import java.io.*;

public class Boj10844 {
  static final long MOD = 1000000000L; // 결과를 10억으로 나눈 나머지

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine()); // 길이가 n인 계단 수

    System.out.print(stair(n)); // 결과 출력
  }

  static long stair(int n) {

    long[][] dp = new long[n + 1][10];

    // i : 숫자의 길이
    // j : 마지막 자리 숫자
    // dp[i][j] = 길이가 i이고 마지막 숫자가 j인 계단 수의 개수

    // 마지막 수가 j일 때 i-1번째 자리의 수에 j-1 또는 j+1이 올 수 있음
    // dp[i][j] = dp[i-1][j-1] + dp[i-1][j+1];

    // 길이가 1인 계단 수 초기화
    // 1~9는 각각 1개씩 존재 (0으로 시작하는 수는 없음)
    for (int j = 1; j <= 9; j++)
      dp[1][j] = 1;

    // 길이 2부터 n까지 DP 계산
    for (int i = 2; i <= n; i++) {

      for (int j = 0; j <= 9; j++) {

        dp[i][j] = 0; // 현재 상태 초기화

        // j = 0이면 j-1이 존재하지 않음
        // 이전 자리가 1인 경우만 가능
        if (j - 1 >= 0)
          dp[i][j] += (dp[i - 1][j - 1])%MOD;

        // j = 9이면 j+1이 존재하지 않음
        // 이전 자리가 8인 경우만 가능
        if (j + 1 <= 9)
          dp[i][j] += (dp[i - 1][j + 1])%MOD;
      }
    }

    // 길이가 n인 모든 계단 수의 개수 합산
    long cnt = 0;
    for (int j = 0; j <= 9; j++)
      cnt += dp[n][j];

    return cnt % MOD; // 문제 조건에 따라 10억으로 나눈 나머지 반환
  }
}