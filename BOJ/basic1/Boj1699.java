package BOJ.basic1;

import java.util.*;
import java.io.*;

public class Boj1699 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    System.out.print(go(n));
  }

  static int go(int n) {
    /* * d[i]: 숫자 i를 만드는 데 필요한 '최소 제곱수 항의 개수'
     * 예: d[7] -> 2^2 + 1^2 + 1^2 + 1^2 (4개)
     */
    int[] d = new int[n + 1];

    for (int i = 1; i <= n; i++) {
      /* * 초기화: 모든 수는 1^2의 합으로 나타낼 수 있음 (최대 개수)
       * i = 1^2 + 1^2 + ... + 1^2 (총 i개)
       */
      d[i] = i;

      /* * 점화식: d[i] = min(d[i], d[i - j*j] + 1)
       * i보다 작은 제곱수(j*j)를 하나 선택했을 때, 
       * (i - j*j)를 만드는 최소 개수에 방금 선택한 제곱수(j*j) 1개를 더함(+1)
       */
      for (int j = 1; j * j <= i; j++){
        // 현재 저장된 d[i]보다 'i-j*j'의 최소 개수에 1을 더한 값이 더 작다면 갱신
        if(d[i] > d[i - j * j] + 1) { 
          d[i] = d[i - j * j] + 1;
        }
      }
    }
    return d[n];
  }
}