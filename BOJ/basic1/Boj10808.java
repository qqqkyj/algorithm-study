package BOJ.basic1;

import java.util.*;
import java.io.*;

public class Boj10808 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 알파벳 'a'부터 'z'까지(26개)의 빈도수를 담을 배열
        int[] arr = new int[26];

        // 1. 문자열을 순회하며 알파벳별 등장 횟수를 Map에 카운팅
        Map<Character, Integer> map = new HashMap<>();
        for (char c : br.readLine().toCharArray()) {
            // getOrDefault를 사용하여 처음 등장하는 문자는 0, 기존 문자는 +1 처리
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // 2. Map에 저장된 데이터를 출력용 배열(arr)로 이관
        // map.keySet()을 통해 존재하는 알파벳만 순회
        for (char c : map.keySet()) {
            // 'c' - 'a' 연산을 통해 문자를 0~25 사이의 인덱스로 변환 (예: 'a'->0, 'b'->1)
            arr[c - 'a'] = map.get(c);
        }

        // 3. 결과 출력을 위한 문자열 생성
        StringBuilder sb = new StringBuilder();
        // 배열의 마지막 원소 전까지 숫자와 공백을 추가
        for (int i = 0; i < arr.length - 1; i++) {
            sb.append(arr[i]).append(' ');
        }
        // 마지막 원소는 뒤에 공백 없이 추가하여 형식 맞춤
        sb.append(arr[arr.length - 1]);

        System.out.print(sb);
    }
}