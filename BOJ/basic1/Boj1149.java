package BOJ.basic1;

import java.util.*;
import java.io.*;

public class Boj1149 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 집의 개수 N을 입력받습니다.
        int n = Integer.parseInt(br.readLine());
        
        // 각 집을 R, G, B로 칠할 때의 비용을 저장할 2차원 배열입니다.
        int[][] arr = new int[n][3];
        StringTokenizer st;

        // 각 줄마다 새로운 StringTokenizer를 생성하여 R, G, B 비용을 각각 읽어옵니다.
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 최적화된 최소 비용을 계산하는 go 메서드를 호출합니다.
        System.out.print(go(arr));
    }

    static int go(int[][] arr) {
        // dp[i][j]: i번째 집을 j색으로 칠했을 때, i번째 집까지의 누적 최소 비용
        int[][] dp = new int[arr.length][arr[0].length];
        
        // [초기 상태 설정] 첫 번째 집은 이전 집이 없으므로 입력받은 비용 자체가 최소 비용입니다.
        dp[0][0] = arr[0][0]; // 첫 번째 집을 빨강으로 칠할 때
        dp[0][1] = arr[0][1]; // 첫 번째 집을 초록으로 칠할 때
        dp[0][2] = arr[0][2]; // 첫 번째 집을 파랑으로 칠할 때

        // [점화식 적용] 두 번째 집(인덱스 1)부터 마지막 집까지 순회합니다.
        // 핵심: 현재 집의 색은 '직전 집과 다른 색' 중 최소 비용을 선택합니다.
        for (int i = 1; i < dp.length; i++) {
            // 현재 집을 빨강(0)으로 칠할 경우: 이전 집은 초록(1) 또는 파랑(2)이어야 함
            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + arr[i][0];
            
            // 현재 집을 초록(1)으로 칠할 경우: 이전 집은 빨강(0) 또는 파랑(2)이어야 함
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + arr[i][1];
            
            // 현재 집을 파랑(2)으로 칠할 경우: 이전 집은 빨강(0) 또는 초록(1)이어야 함
            dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + arr[i][2];
        }

        // [최종 결과] 마지막 집까지 다 칠했을 때, R, G, B 세 가지 경우 중 가장 적은 비용을 찾습니다.
        int rst = Math.min(dp[arr.length - 1][0], dp[arr.length - 1][1]);
        rst = Math.min(rst, dp[arr.length - 1][2]);
        
        return rst;
    }
}