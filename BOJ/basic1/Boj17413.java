package BOJ.basic1;

import java.util.*;
import java.io.*;

public class Boj17413 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input = br.readLine().toCharArray();
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int cnt = 0; cnt < input.length; cnt++) {
            if (input[cnt] == '<') { // 태그 시작
                while (!stack.isEmpty()) sb.append(stack.pop()); // 단어 뒤집기
                sb.append('<');
                cnt++;
                while (input[cnt] != '>') sb.append(input[cnt++]); // 태그 내용 그대로
                sb.append('>');
            } 
            else if (input[cnt] == ' ') { // 공백
                while (!stack.isEmpty()) sb.append(stack.pop()); // 단어 뒤집기
                sb.append(' ');
            } 
            else { // 일반 문자
                stack.push(input[cnt]); // 스택에 쌓기
            }
        }

        while (!stack.isEmpty()) sb.append(stack.pop()); // 마지막 단어 뒤집기

        System.out.print(sb);
    }
}