package BOJ.basic1;

import java.util.*;
import java.io.*;

public class Boj11054 {
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

  static int go(int[] arr) {
    int n = arr.length;
    // lis[i]: i번째 원소에서 끝나는 '가장 긴 증가하는 부분 수열'의 길이
    int[] lis = new int[n];
    // lds[i]: i번째 원소에서 시작하는 '가장 긴 감소하는 부분 수열'의 길이
    int[] lds = new int[n];
    
    // [단계 1] 정방향으로 LIS 구하기 (왼쪽 -> 오른쪽 증가)
    for (int i = 0; i < n; i++) {
      lis[i] = 1; // 자기 자신만 포함하는 길이 1로 초기화
      for (int j = 0; j < i; j++) { // j를 i 이전까지 탐색
        // 현재 값(arr[i])보다 작은 이전 값(arr[j])을 발견하면 갱신
        if (arr[j] < arr[i])
          lis[i] = Math.max(lis[i], lis[j] + 1);
      }
    }

    // [단계 2] 역방향으로 LDS 구하기 (오른쪽 -> 왼쪽 증가 == 왼쪽 -> 오른쪽 감소)
    for (int i = n - 1; i >= 0; i--) {
      lds[i] = 1; // 자기 자신만 포함하는 길이 1로 초기화
      for (int j = i + 1; j < n; j++) { // j를 i 이후부터 탐색
        // 현재 값(arr[i])이 뒤에 있는 값(arr[j])보다 크면 '감소' 조건 성립
        if (arr[i] > arr[j])
          lds[i] = Math.max(lds[i], lds[j] + 1);
      }
    }
    
    // [단계 3] 각 지점을 바이토닉 수열의 '산꼭대기'로 가정하고 최대 길이 찾기
    int max = 0;
    for (int i = 0; i < n; i++) {
      // (i까지 증가하는 길이) + (i부터 감소하는 길이) - 1
      // -1을 하는 이유는 arr[i]가 양쪽 계산에 모두 포함되어 중복되기 때문입니다.
      max = Math.max(max, lis[i] + lds[i] - 1);
    }
    
    return max;
  }
}