# 10. 중앙값 구하기(버블 정렬)

https://school.programmers.co.kr/learn/courses/30/lessons/120811

### **문제 설명**

중앙값은 어떤 주어진 값들을 크기의 순서대로 정렬했을 때 가장 중앙에 위치하는 값을 의미합니다. 예를 들어 1, 2, 7, 10, 11의 중앙값은 7입니다. 정수 배열 `array`가 매개변수로 주어질 때, 중앙값을 return 하도록 solution 함수를 완성해보세요.

---

### 제한사항

- `array`의 길이는 홀수입니다.
- 0 < `array`의 길이 < 100
- 1,000 < `array`의 원소 < 1,000

---

### 입출력 예

| array             | result |
| ----------------- | ------ |
| [1, 2, 7, 10, 11] | 7      |
| [9, -1, 0]        | 0      |

---

### 입출력 예 설명

입출력 예 #1

- 본문과 동일합니다.

입출력 예 #2

- 9, -1, 0을 오름차순 정렬하면 -1, 0, 9이고 가장 중앙에 위치하는 값은 0입니다.

---

**💡문제 풀이**

- **내 문제 풀이**
  ```java
  class Solution {
      public int solution(int[] array) {
          int answer = 0;

          for(int i=0; i < array.length-1; i++){
              for(int j=i+1; j < array.length; j++){
                  if(array[i] > array[j]){
                      int tmp = array[j];
                      array[j] = array[i];
                      array[i] = tmp;
                  }
              }
          }

          return array[(int)(array.length/2)];
      }
  }
  ```
- **다른 사람 문제 풀이**
  ```java
  import java.util.Arrays;

  class Solution {
      public int solution(int[] array) {
          Arrays.sort(array);
          return array[array.length / 2];
      }
  }
  ```
