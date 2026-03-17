package BOJ.basic1;

import java.io.*;

public class Boj15988 {
    // 결과값이 매우 커질 수 있으므로 문제에서 제시한 나머지 값을 상수로 정의합니다.
    static final long MOD = 1000000009L;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 테스트 케이스의 개수 n을 입력받습니다.
        int n = Integer.parseInt(br.readLine());
        
        // 문제의 최대 범위인 1,000,000까지의 데이터를 담을 수 있도록 배열을 생성합니다.
        // dp[숫자][마지막에 더한 수] 구조로 정의했습니다.
        long[][] dp = new long[1000001][4];
        
        // DP 테이블을 미리 채워둡니다 (Pre-computation). 
        // 매번 계산하지 않고 한 번만 계산하여 성능을 최적화합니다.
        dp = go(dp.length);
        
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            // 정수 num을 만드는 총 경우의 수는 (마지막에 1을 쓴 경우 + 2를 쓴 경우 + 3을 쓴 경우)의 합입니다.
            long rst = (dp[num][1] + dp[num][2] + dp[num][3]) % MOD;
            System.out.println(rst);
        }
    }
    
    /**
     * Bottom-up 방식으로 DP 테이블을 채우는 메서드
     * @param n 전체 배열의 길이
     * @return 계산이 완료된 2차원 DP 배열
     */
    static long[][] go(int n) {
        long[][] dp = new long[n][4];

        // 1부터 최대값까지 차례대로 경우의 수를 누적합니다.
        for (int i = 1; i < n; i++) {
            // 마지막에 더할 수 있는 숫자는 1, 2, 3 세 가지입니다.
            for (int j = 1; j < 4; j++) {
                // 케이스 1: 숫자 i가 더하려는 숫자 j와 같은 경우 (예: 1을 만드는데 1을 사용)
                // 자기 자신만 사용하는 경우의 수 1가지를 저장합니다.
                if (i == j) {
                    dp[i][j] = 1;
                } 
                // 케이스 2: 숫자 i를 만들기 위해 이전에 (i-j)를 만든 모든 경우의 수 뒤에 j를 붙이는 경우
                // 점화식: DP[i][j] = DP[i-j][1] + DP[i-j][2] + DP[i-j][3]
                else if (i - j > 0) {
                    dp[i][j] = (dp[i - j][1] + dp[i - j][2] + dp[i - j][3]) % MOD;
                }
            }
        }

        return dp;
    }
}