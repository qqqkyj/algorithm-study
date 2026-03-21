package BOJ.basic1;

import java.util.*;
import java.io.*;

public class Boj13398 {
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
    int[] front = new int[arr.length];
    int[] back = new int[arr.length];

    // 왼쪽 → 오른쪽 최대 연속 부분합
    // front[i] = i를 끝으로 하는 최대 연속 부분합
    front[0] = arr[0];
    for (int i = 1; i < front.length; i++) {
      front[i] = arr[i]; // 현재 값 단독 시작
      // 이전까지의 최대 부분합에 현재 값을 이어붙이는 게 더 크면 갱신
      if (front[i] < front[i - 1] + arr[i])
        front[i] = front[i - 1] + arr[i];
    }

    // 오른쪽 → 왼쪽 최대 연속 부분합
    // back[i] = i를 시작으로 하는 최대 연속 부분합
    back[back.length - 1] = arr[arr.length - 1];
    for (int i = back.length - 2; i >= 0; i--) {
      back[i] = arr[i]; // 현재 값 단독 시작
      // 뒤쪽 최대 부분합에 현재 값을 이어붙이는 게 더 크면 갱신
      if (back[i] < back[i + 1] + arr[i])
        back[i] = back[i + 1] + arr[i];
    }

    int max = Integer.MIN_VALUE;

    // 1️. 아무 것도 제거하지 않은 경우 (기본 최대 부분합)
    for (int i = 0; i < front.length; i++) {
      max = Math.max(max, front[i]);
    }

    // 2️. 하나의 원소를 제거하는 경우
    // i를 제거한다고 가정하면:
    // → 왼쪽 최대 부분합 (front[i-1]) + 오른쪽 최대 부분합 (back[i+1])
    if (front.length > 1) {
      for (int i = 1; i < front.length - 1; i++) {
        max = Math.max(max, front[i - 1] + back[i + 1]);
      }
    }
    
    return max;
  }
}