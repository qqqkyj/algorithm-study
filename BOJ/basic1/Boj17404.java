package BOJ.basic1;

import java.util.*;
import java.io.*;

public class Boj17404 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[][] arr = new int[n][3]; // 각 집을 R,G,B로 칠하는 비용
    StringTokenizer st;
    for (int i = 0; i < arr.length; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < arr[i].length; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    System.out.println(go(arr));
  }

  static int go(int[][] arr) {
    int[][] dp = new int[arr.length][3];
    // dp[i][c] = i번째 집까지 칠했을 때, i번째 집을 c색으로 칠하는 최소 비용

    int min = Integer.MAX_VALUE;
    for (int k = 0; k < 3; k++) { // 0번 집 색을 R/G/B 각각으로 고정하여 3번 계산

      for (int j = 0; j < 3; j++) {
        if (j == k)
          dp[0][j] = arr[0][j]; // 0번 집을 k색으로 시작
        else
          dp[0][j] = 1001; // 다른 색은 선택 못하도록 큰 값으로 설정
      }

      for (int i = 1; i < dp.length; i++) {
        // 이전 집과 다른 색만 선택 가능
        dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + arr[i][0];
        dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + arr[i][1];
        dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + arr[i][2];
      }

      // System.out.println(Arrays.deepToString(dp)); // 디버깅용 출력

      for (int j = 0; j < 3; j++) {
        if (j != k)
          min = Math.min(min, dp[dp.length-1][j]); 
          // 마지막 집은 첫 집(k)과 다른 색이어야 함 (원형 조건)
      }
    }
    
    return min; // 모든 경우 중 최소 비용
  }
}