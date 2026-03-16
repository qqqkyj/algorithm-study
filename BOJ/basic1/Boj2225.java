package BOJ.basic1;

import java.util.*;
import java.io.*;

public class Boj2225 {
  static final long MOD = 1000000000L;
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
    System.out.print(go(n,k));
  }

  static long go(int n, int k) {
    // d[i][j]: i개를 더해서 합이 j가 되는 경우의 수
    long[][] d = new long[k + 1][n + 1];

    // 초기 상태: 0개를 사용하여 합이 0이 되는 경우의 수는 1가지
    d[0][0] = 1;

    for (int i = 1; i <= k; i++) {
      for (int j = 0; j <= n; j++) {
        /* * [핵심 로직]
         * L : 마지막에 더해지는 수 (0 <= L <= j)
         * d[i][j] = Σ (d[i-1][j-L]) 
         * i개를 써서 j를 만드는 것은, (i-1)개를 써서 (j-L)을 만든 후 마지막에 L을 더하는 것들의 총합
         */
        for (int l = 0; l <= j; l++) {
          d[i][j] += d[i - 1][j - l];
          d[i][j] %= MOD;
        }
      }
    }

    // 최종적으로 k개를 사용하여 합 n을 만드는 경우의 수 반환
    return d[k][n];
  }
}