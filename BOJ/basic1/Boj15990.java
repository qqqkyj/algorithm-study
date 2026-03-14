package BOJ.basic1;

import java.io.*;

public class Boj15990 {
  // 100만까지의 결과를 한 번만 계산하여 저장할 2차원 DP 테이블
  // f[i][j]: 정수 i를 만드는 방법 중 마지막 숫자가 j(1, 2, 3)인 경우의 수
  static long[][] f = new long[1000001][4];
  static final long MOD = 1000000009L;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    // 테스트 케이스 개수 입력
    int n = Integer.parseInt(br.readLine());
    
    // [핵심: 전처리] 매번 계산하지 않고 최대 범위(100만)까지 미리 계산해 둠
    // 시간 복잡도를 T * N에서 N + T로 획기적으로 줄이는 전략
    dp(1000000); 

    for (int i = 0; i < n; i++) {
      // 확인할 정수 m 입력
      int m = Integer.parseInt(br.readLine());
      // 마지막이 1, 2, 3으로 끝나는 모든 경우의 수를 합산하여 출력
      // (각 값이 이미 MOD 연산이 되어있으므로 합산 후 마지막으로 한 번 더 MOD 수행)
      System.out.println((f[m][1] + f[m][2] + f[m][3]) % MOD);
    }
  }

  static void dp(int n) {
    // 기저 사례(Base Case) 설정
    // 숫자 1, 2, 3을 각각 단독으로 사용하여 만드는 경우 (연속되지 않으므로 가능)
    f[1][1] = 1; // "1"
    f[2][2] = 1; // "2"
    f[3][1] = 1; // "2+1"
    f[3][2] = 1; // "1+2"
    f[3][3] = 1; // "3"

    // 점화식: f[i][j]는 i-j를 만드는 방법 중 마지막 숫자가 j가 아닌 것들의 합
    for (int i = 4; i <= n; i++) {
      // 1로 끝나는 경우: 직전(i-1)에 2 또는 3을 더했어야 함
      f[i][1] = (f[i - 1][2] + f[i - 1][3]) % MOD;
      
      // 2로 끝나는 경우: 직전(i-2)에 1 또는 3을 더했어야 함
      f[i][2] = (f[i - 2][1] + f[i - 2][3]) % MOD;
      
      // 3으로 끝나는 경우: 직전(i-3)에 1 또는 2를 더했어야 함
      f[i][3] = (f[i - 3][1] + f[i - 3][2]) % MOD;
    }
  }
}