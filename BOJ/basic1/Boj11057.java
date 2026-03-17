package BOJ.basic1;

import java.util.*;
import java.io.*;

public class Boj11057 {
  static final long MOD = 10007L;
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    System.out.print(go(n));
  }

  static long go(int n) {
    // dp[i][j]: 길이가 i+1인 수에서, 가장 앞자리가 j인 오르막 수의 개수를 저장
    long[][] dp = new long[n][10];

    // [초기화] 길이가 1인 수(한 자리 수)는 0~9까지 각각 1개씩 존재함
    for (int i = 0; i < 10; i++) {
      dp[0][i] = 1;
    }

    // [점화식 계산] dp[n][j] = 현재 자리 j 뒤에 올 수 있는(j보다 크거나 같은) 모든 이전 단계 경우의 합
    for (int i = 1; i < n; i++) { // 수의 길이를 늘려감
      for (int j = 0; j < 10; j++) { // 현재 결정할 앞자리 숫자 j
        // 오르막 수 조건: 앞자리 j는 뒷자리 r보다 작거나 같아야 함 (j <= r)
        for (int r = j; r < 10; r++) {
          dp[i][j] += dp[i - 1][r];
        }
        // 합산 과정에서 값이 커질 수 있으므로 문제에서 제시한 MOD로 나머지 연산 수행
        dp[i][j] %= MOD;
      }
    }

    // [최종 합계 계산] 길이가 n인 모든 오르막 수(0~9로 시작하는 모든 경우)를 더함
    int sum = 0;
    for (int i = 0; i < 10; i++) {
      sum += dp[n - 1][i];
    }
    // 최종 결과값에 대해서 다시 한 번 나머지 연산을 수행하여 반환
    return sum % MOD;
  }
}