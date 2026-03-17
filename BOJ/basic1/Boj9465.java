package BOJ.basic1;

import java.util.*;
import java.io.*;

public class Boj9465 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // 테스트 케이스 개수 T를 입력받습니다.
    int t = Integer.parseInt(br.readLine());
    for (int i = 0; i < t; i++) {
      // 스티커의 가로 길이 N을 입력받습니다.
      int n = Integer.parseInt(br.readLine());
      int[][] arr = new int[2][n];
      StringTokenizer st;
      // 2행 N열의 스티커 점수 데이터를 배열에 채웁니다.
      for (int j = 0; j < 2; j++) {
        st = new StringTokenizer(br.readLine());
        for (int k = 0; k < n; k++) {
          arr[j][k] = Integer.parseInt(st.nextToken());
        }
      }
      // DP를 활용하여 구한 최대 점수를 출력합니다.
      System.out.println(go(arr));
    }
  }
  
  static int go(int[][] arr) {
    // dp[행][열]: 해당 위치의 스티커를 선택했을 때 얻을 수 있는 누적 최대 점수
    int[][] dp = new int[arr.length][arr[0].length];

    // [초기값 설정 - 1열] 첫 번째 칸은 자기 자신의 점수가 곧 최대값입니다.
    dp[0][0] = arr[0][0];
    dp[1][0] = arr[1][0];

    // [초기값 설정 - 2열] N이 2 이상일 때를 대비한 처리입니다.
    // 인덱스 1 위치의 스티커는 직전 대각선의 스티커를 반드시 포함하는 것이 이득입니다.
    if (arr[0].length >= 2) {
      dp[0][1] = dp[1][0] + arr[0][1];
      dp[1][1] = dp[0][0] + arr[1][1];
    }

    // [점화식 수행 - 3열부터] 
    for (int i = 2; i < dp[0].length; i++) {
      // 0행 i번째 스티커를 떼는 경우의 수:
      // 1. 바로 왼쪽 대각선(1행 i-1)에서 오는 경우
      // 2. 한 칸 건너뛴 대각선(1행 i-2)에서 오는 경우
      // 3. 한 칸 건너뛴 같은 행(0행 i-2)에서 오는 경우 (지그재그가 아닌 건너뛰기)
      int max1 = Math.max(dp[1][i - 1], dp[1][i - 2]);
      max1 = Math.max(max1, dp[0][i - 2]);
      dp[0][i] = max1 + arr[0][i];

      // 1행 i번째 스티커를 떼는 경우의 수:
      // 위와 동일하게 반대편 행의 i-1, i-2 및 자기 행의 i-2 중 최댓값을 선택합니다.
      int max2 = Math.max(dp[0][i - 1], dp[0][i - 2]);
      max2 = Math.max(max2, dp[1][i - 2]);
      dp[1][i] = max2 + arr[1][i];
    }

    // [최종 결과] 마지막 열에서 0행을 고른 경우와 1행을 고른 경우 중 더 큰 값을 반환합니다.
    return Math.max(dp[0][dp[0].length-1], dp[1][dp[0].length-1]);
  }
}