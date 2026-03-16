package BOJ.basic1;

import java.util.*;
import java.io.*;

public class Boj1912 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }
    System.out.print(go(arr));
  }

  static long go(int[] arr) {
    // dp[i]: i번째 원소를 마지막으로 포함하는 연속합 중 최댓값
    int[] dp = new int[arr.length];
    
    // 초기값 설정: 첫 번째 원소는 그 자체로 최댓값의 시작점
    int max = dp[0] = arr[0]; 
    
    for (int i = 1; i < arr.length; i++) {
      /* * 핵심 점화식:
       * (이전까지의 연속합 + 현재 값) vs (현재 값 단독)
       * 이전 합에 현재를 더하는 게 이득인지, 아니면 여기서부터 새로 시작하는 게 이득인지 판단
       */
      dp[i] = Math.max(dp[i - 1] + arr[i], arr[i]);
      
      // 전체 구간 중 가장 컸던 연속합을 갱신
      max = Math.max(max, dp[i]);
    }
    return max;
  }
}