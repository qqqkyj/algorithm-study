package BOJ.basic1;

import java.io.*;

public class Boj11655 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // 입력받은 문자열을 한 글자씩 처리하기 위해 char 배열로 변환
    char[] arr = br.readLine().toCharArray();
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < arr.length; i++) {
      // 1. 소문자('a'-'z') 범위 판별
      if (0 <= arr[i] - 'a' && arr[i] - 'a' < 26) {
        // (현재 문자 위치 + 13)을 26으로 나눈 나머지를 구하여 알파벳 순환 처리
        arr[i] = (char)('a' + (arr[i] - 'a' + 13) % 26);
      }
      // 2. 대문자('A'-'Z') 범위 판별
      else if (0 <= arr[i] - 'A' && arr[i] - 'A' < 26) {
        // 대문자 기준으로 13글자 밀어내기 및 순환 처리
        arr[i] = (char)('A' + (arr[i] - 'A' + 13) % 26);
      }
      // 알파벳이 아닌 공백이나 숫자는 조건문을 건너뛰고 그대로 추가됨
      sb.append(arr[i]);
    }

    // 변환된 전체 문자열 출력
    System.out.print(sb);
  }
}