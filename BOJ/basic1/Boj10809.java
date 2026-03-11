package BOJ.basic1;

import java.io.*;

public class Boj10809 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    // 입력받은 문자열을 한 글자씩 분리하여 char 배열에 저장
    char[] arr = br.readLine().toCharArray();
    
    // 알파벳 'a'-'z'까지 총 26개의 위치 정보를 담을 배열 생성
    int[] alphabet = new int[26];
    
    // 모든 알파벳 위치를 일단 -1(미등장 상태)로 초기값 설정
    for(int i = 0; i < alphabet.length; i++)
    {
      alphabet[i] = -1;
    }

    // 문자열의 첫 글자부터 끝까지 순회
    for (int i = 0; i < arr.length; i++) {
      // 해당 알파벳의 위치 값이 아직 -1인 경우에만 현재 인덱스(i)를 저장
      // (이를 통해 처음 등장하는 위치만 기록됨)
      if (alphabet[arr[i] - 'a'] == -1)
        alphabet[arr[i] - 'a'] = i;
    }

    StringBuilder sb = new StringBuilder();
    // 마지막 인덱스 전까지 숫자와 공백을 StringBuilder에 추가
    for(int i = 0; i < alphabet.length-1; i++)
    {
      sb.append(alphabet[i]).append(' ');
    }
    // 마지막 숫자를 추가 (뒤에 공백이 붙지 않도록 별도 처리)
    sb.append(alphabet[alphabet.length-1]);
    
    // 최종 결과 출력
    System.out.print(sb);
  }
}