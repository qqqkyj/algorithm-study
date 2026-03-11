package BOJ.basic1;

import java.util.*;
import java.io.*;

public class Boj10820 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line;
    
    // 입력이 더 이상 없을 때까지 한 줄씩 읽어오는 EOF 처리
    while ((line = br.readLine()) != null) {
      char[] arr = line.toCharArray();
      // 인덱스별로 [소문자, 대문자, 숫자, 공백]의 개수를 저장할 배열
      int[] check = new int[4];

      for (int i = 0; i < arr.length; i++) {
        // 아스키코드 차이를 이용하여 소문자('a'~'z') 범위 확인
        if (0 <= arr[i] - 'a' && arr[i] - 'a' < 26) {
          check[0]++;
        }
        // 아스키코드 차이를 이용하여 대문자('A'~'Z') 범위 확인
        else if (0 <= arr[i] - 'A' && arr[i] - 'A' < 26) {
          check[1]++;
        }
        // 공백 문자 확인
        else if (arr[i] == ' ') {
          check[3]++;
        }
        // 위 조건에 해당하지 않는 경우 숫자(0~9)로 간주
        else {
          check[2]++;
        }
      }

      StringBuilder sb = new StringBuilder();
      // 결과 배열을 순회하며 숫자와 공백을 조합
      for (int i = 0; i < check.length - 1; i++) {
        sb.append(check[i]).append(' ');
      }
      // 마지막 원소 추가 후 줄바꿈 출력
      sb.append(check[check.length - 1]);
      System.out.println(sb);
          
    }
  }
}