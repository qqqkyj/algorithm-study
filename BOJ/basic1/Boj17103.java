package BOJ.basic1;

import java.io.*;

public class Boj17103 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // 테스트 케이스 개수
    int n = Integer.parseInt(br.readLine());

    // 각 테스트 케이스의 짝수 저장
    int[] arr = new int[n];

    // 에라토스테네스 체를 만들기 위한 최대값
    int max = 0;

    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(br.readLine());
      // 입력된 값 중 가장 큰 값 찾기 (소수 배열 생성 범위 결정)
      max = max > arr[i] ? max : arr[i];
    }

    // 0 ~ max 까지 소수 여부 미리 계산 (에라토스테네스 체)
    // false : 소수
    // true  : 합성수
    boolean[] prime = isPrime(max);

    // 각 테스트 케이스마다 골드바흐 파티션 계산
    for (int i = 0; i < n; i++) {

      // 해당 숫자의 골드바흐 파티션 개수
      int partition = 0;

      // j + (arr[i] - j) = arr[i]
      // 중복을 피하기 위해 j는 arr[i] / 2 까지만 탐색
      for (int j = 2; j <= arr[i] / 2; j++) {

        // j와 arr[i]-j 둘 다 소수라면 골드바흐 파티션
        if (!prime[j] && !prime[arr[i] - j]) {
          partition++; // 가능한 소수 쌍 개수 증가
        }
      }

      // 해당 숫자의 골드바흐 파티션 개수 출력
      System.out.println(partition);
    }
  }

  // 에라토스테네스의 체를 이용해 0~max까지 소수 여부 계산
  static boolean[] isPrime(int max) {

    // false : 소수
    // true  : 합성수
    boolean[] prime = new boolean[max + 1];

    // 0과 1은 소수가 아님
    prime[0] = true;
    prime[1] = true;

    // i의 배수들을 모두 합성수로 표시
    for (int i = 2; i*i <= max; i++) {

      // i+i, i+2i, i+3i ... 형태로 배수 제거
      for (int j = i + i; j <= max; j += i) {
        if (!prime[j])
          prime[j] = true;
      }
    }

    return prime;
  }
}