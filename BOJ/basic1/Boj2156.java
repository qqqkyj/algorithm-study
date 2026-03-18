package BOJ.basic1;

import java.io.*;

public class Boj2156 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }
    System.out.print(go(arr));
  }

  static int go(int[] arr) {
    int n = arr.length;
    // dp[연속마신횟수][포도주인덱스]
    int[][] dp = new int[3][n]; 
    // 0: 현재 잔 안마심, 1: 현재 잔이 첫 번째 연속, 2: 현재 잔이 두 번째 연속

    // [초기값 설정] 첫 번째 포도주에 대한 각 상태 정의
    dp[1][0] = dp[2][0] = arr[0]; 

    for (int i = 1; i < n; i++) {
      // 1. 이번 잔을 마시지 않는 경우: 이전 잔의 모든 상태(0,1,2회 연속) 중 최댓값을 계승
      dp[0][i] = Math.max(Math.max(dp[0][i - 1], dp[1][i - 1]), dp[2][i - 1]);
      
      // 2. 이번 잔이 첫 번째 연속인 경우: 반드시 직전 잔을 '마시지 않았어야' 함
      dp[1][i] = dp[0][i - 1] + arr[i];
      
      // 3. 이번 잔이 두 번째 연속인 경우: 반드시 직전 잔이 '첫 번째 연속 마심' 상태였어야 함
      dp[2][i] = dp[1][i - 1] + arr[i];
    }
    
    // 마지막 포도주까지 고려했을 때, 세 가지 상태 중 가장 큰 값이 정답
    int max = Math.max(dp[0][n - 1], dp[1][n - 1]);
    return Math.max(max, dp[2][n - 1]);
  }
}