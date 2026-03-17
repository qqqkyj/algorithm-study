package BOJ.basic1;

import java.io.*;

public class Boj1309 {
    // 결과값이 커질 수 있으므로 문제에서 지정한 나머지 값을 상수로 관리합니다.
    static final long MOD = 9901L;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 우리(cage)의 세로 길이 N을 입력받습니다.
        int n = Integer.parseInt(br.readLine());
        // 계산된 총 경우의 수를 출력합니다.
        System.out.print(go(n));
    }
    
    static long go(int n) {
        // dp[i][j]: i번째 줄까지 사자를 배치했을 때의 경우의 수
        // j의 상태 - 0: 사자 없음, 1: 왼쪽 칸에 사자, 2: 오른쪽 칸에 사자
        long[][] dp = new long[n][3];

        // [초기 상태] 첫 번째 줄(i=0)에 사자를 배치하는 경우의 수는 각각 1개씩입니다.
        // 아무데도 안 놓는 경우(1), 왼쪽에 놓는 경우(1), 오른쪽에 놓는 경우(1)
        dp[0][0] = dp[0][1] = dp[0][2] = 1;

        // [점화식 적용] 두 번째 줄부터 N번째 줄까지 순회하며 경우의 수를 누적합니다.
        for (int i = 1; i < n; i++) {
            // 1. 현재 줄에 사자를 놓지 않는 경우:
            // 이전 줄 상태와 상관없이 모두 가능 (없음, 왼쪽, 오른쪽)
            dp[i][0] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) % MOD;

            // 2. 현재 줄의 왼쪽 칸에 사자를 놓는 경우:
            // 이전 줄에서 사자가 없었거나, 오른쪽 칸에 있었어야 함 (왼쪽은 불가)
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % MOD;

            // 3. 현재 줄의 오른쪽 칸에 사자를 놓는 경우:
            // 이전 줄에서 사자가 없었거나, 왼쪽 칸에 있었어야 함 (오른쪽은 불가)
            dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % MOD;
        }

        // [최종 결과] 마지막 줄(n-1)의 모든 상태(없음, 왼쪽, 오른쪽)를 더한 값이 정답입니다.
        return (dp[n-1][0] + dp[n-1][1] + dp[n-1][2]) % MOD;
    }
}