package BOJ.basic1;

import java.util.*;
import java.io.*;

public class Boj11656 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line = br.readLine();
    
    // 1. 접미사의 개수는 문자열의 길이와 같으므로 그만큼의 문자열 배열 생성
    String[] arr = new String[line.length()];
    
    // 2. substring을 활용해 문자열의 모든 접미사를 추출하여 배열에 저장
    for (int i = 0; i < line.length(); i++) {
      // i번째 인덱스부터 끝까지 잘라내어 저장 (예: "ba", "a" 등)
      arr[i] = line.substring(i, line.length());
    }

    // 3. 자바의 내장 정렬 기능을 사용하여 접미사들을 사전순으로 정렬
    // (String 배열의 경우 기본적으로 오름차순/사전순 정렬을 수행함)
    Arrays.sort(arr);

    // 4. 출력을 위해 StringBuilder에 정렬된 접미사들을 추가
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < arr.length - 1; i++) {
      // 각 접미사 뒤에 줄바꿈 문자(\n)를 붙여 연결
      sb.append(arr[i]).append("\n");
    }
    // 마지막 접미사는 뒤에 줄바꿈 없이 추가하여 형식 맞춤
    sb.append(arr[arr.length - 1]);
    
    // 최종 결과 출력
    System.out.print(sb);
  }
}