package BOJ.basic1;

import java.util.*;
import java.io.*;

public class Boj16194 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n + 1];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }
    System.out.print(dp(n, arr));
  }

  static int dp(int n, int[] arr) {
    // f[i] 정의: 카드 i개를 구매할 때 지불하는 금액의 최솟값
    int[] f = new int[n + 1];
    
    // 초기값 설정: 1장을 구매하는 최소 비용은 1장짜리 카드팩 가격뿐임
    f[1] = arr[1];

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= i; j++) {
        /* * [최솟값 비교를 위한 초기화 팁]
         * Math.min을 사용할 때 f[i]가 0이면 항상 0이 최솟값이 되는 문제를 방지하기 위해
         * 처음 비교할 때는 i개입 카드팩 가격(arr[i])으로 기준점을 잡음
         */
        if(f[i] == 0) f[i] = arr[i];

        /* * [점화식 핵심]
         * 현재까지 찾은 최소 비용(f[i])과 
         * 'j개입 팩 가격(arr[j]) + 나머지 (i-j)개를 채우는 최소 비용(f[i-j])'을 비교
         */
        f[i] = Math.min(f[i], arr[j] + f[i - j]);
      }
    }
    // n장을 구매하는 데 필요한 최소 비용 반환
    return f[n];
  }
}