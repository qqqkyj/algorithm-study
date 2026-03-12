package BOJ.basic1;

import java.util.*;
import java.io.*;

public class Boj1373 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // 2진수 문자열 입력
    String str = br.readLine();

    // 8진수는 2^3 이므로 2진수를 "3자리씩" 묶어 계산해야 한다.
    // 길이가 3의 배수가 되도록 앞에 0을 채워 정렬
    while (str.length() % 3 != 0)
      str = "0" + str;

    // 각 자리를 숫자로 계산하기 위해 int 배열 생성
    int arr[] = new int[str.length()];

    // 문자열을 한 글자씩 분리
    String strArr[] = str.split("");

    // 문자열 배열 → 정수 배열로 변환
    for (int i = 0; i < arr.length; i++) {
      arr[i] = Integer.parseInt(strArr[i]);
    }

    StringBuilder sb = new StringBuilder();

    // 2진수 3자리 = 8진수 1자리
    // 따라서 인덱스를 3씩 증가시키면서 계산
    for (int i = 0; i < arr.length; i+=3) {

      // 3자리 이진수를 10진수로 계산
      // (2^2, 2^1, 2^0) → (4, 2, 1)
      // 예: 101 → 1*4 + 0*2 + 1*1 = 5
      int sum = arr[i] * 4 + arr[i + 1] * 2 + arr[i + 2] * 1;

      // 계산된 값을 이어붙이면 8진수 결과가 됨
      sb.append(sum);
    }

    // 최종 8진수 출력
    System.out.print(sb);
  }
}