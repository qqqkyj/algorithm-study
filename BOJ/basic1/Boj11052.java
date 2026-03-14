package BOJ.basic1;

import java.util.*;
import java.io.*;

public class Boj11052 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n+1]; // 각 카드팩의 가격을 저장하는 배열 (인덱스 = 카드 개수)
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    System.out.print(dp(n, arr));
  }

  static int dp(int n, int[] arr) {
    // f[i] 정의: 카드 i개를 구매할 때 지불하는 금액의 최댓값
    int[] f = new int[n + 1];
    
    // 초기값 설정: 카드 1장을 사는 최댓값은 1장짜리 카드팩 가격과 동일
    f[1] = arr[1];

    // 외곽 루프: 1장부터 n장까지 순차적으로 최댓값을 구해나감 (Bottom-Up)
    for (int i = 1; i <= n; i++) {
      // 내부 루프: i장을 채우기 위해 마지막에 선택할 카드팩(j)을 모든 경우의 수로 따져봄
      for (int j = 1; j <= i; j++) {
        /* * [점화식 핵심]
         * arr[j]: j개가 들어있는 카드팩의 가격
         * f[i - j]: 나머지 (i-j)개를 채우는 최댓값 (이미 계산된 값 활용)
         * 이 두 값을 더한 것과 현재 f[i]에 저장된 최댓값을 비교하여 갱신
         */
        f[i] = Math.max(f[i], arr[j] + f[i - j]);
      }
    }

    // 최종적으로 n장을 채우는 최댓값 반환
    return f[n];
  }
}