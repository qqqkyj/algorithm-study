# 11. **최빈값 구하기(HashMap)**

https://school.programmers.co.kr/learn/courses/30/lessons/120812

### **문제 설명**

최빈값은 주어진 값 중에서 가장 자주 나오는 값을 의미합니다. 정수 배열 `array`가 매개변수로 주어질 때, 최빈값을 return 하도록 solution 함수를 완성해보세요. 최빈값이 여러 개면 -1을 return 합니다.

---

### 제한사항

- 0 < `array`의 길이 < 100
- 0 ≤ `array`의 원소 < 1000

---

### 입출력 예

| array              | result |
| ------------------ | ------ |
| [1, 2, 3, 3, 3, 4] | 3      |
| [1, 1, 2, 2]       | -1     |
| [1]                | 1      |

---

### 입출력 예 설명

입출력 예 #1

- [1, 2, 3, 3, 3, 4]에서 1은 1개 2는 1개 3은 3개 4는 1개로 최빈값은 3입니다.

입출력 예 #2

- [1, 1, 2, 2]에서 1은 2개 2는 2개로 최빈값이 1, 2입니다. 최빈값이 여러 개이므로 -1을 return 합니다.

입출력 예 #3

- [1]에는 1만 있으므로 최빈값은 1입니다.

---

<aside>

**💡문제 풀이**

</aside>

- **내 문제 풀이**
  ```java
  import java.util.*;

  class Solution {
      public int solution(int[] array) {
          Map<Integer, Integer> map = new HashMap<>();
          for(int i = 0; i < array.length; i++)
          {
              map.put(array[i], map.containsKey(array[i]) ? map.get(array[i]) + 1 : 1 );
              // array[i]의 key가 있다면 value+1, 없다면 map에 (array[i],1)을 추가
          }

          int maxFreqKey = 0;
          int maxFreqValue = 0;
          for(int a : map.keySet())
          {
              //map의 value들 중 가장 큰 값을 가지는 key,value 구하기
              if(maxFreqValue < map.get(a))
              {
                  maxFreqKey = a;
                  maxFreqValue = map.get(a);
              }
          }

          int cnt=0;
          for(int value : map.values())
          {
              //maxFreqValue가 value인 개수 구하기
              if(value == maxFreqValue)
                  cnt++;
          }

          return cnt == 1 ? maxFreqKey : -1;
      }
  }
  ```
- **다른 사람 문제 풀이**
  ```java
  import java.util.*;

  class Solution {
      public int solution(int[] array) {
          Map<Integer, Integer> freqMap = new HashMap<>();

          // 1. 각 숫자의 등장 횟수 저장
          for (int num : array) {
              freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
          }

          int maxFreq = 0;      // 최빈값 등장 횟수
          int maxValue = 0;     // 최빈값
          boolean isDuplicate = false; // 최빈값 중복 여부

          // 2. 최빈값과 등장 횟수 찾기
          for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
              int num = entry.getKey();
              int count = entry.getValue();

              if (count > maxFreq) {
                  maxFreq = count;
                  maxValue = num;
                  isDuplicate = false; // 새로운 최빈값 발견 → 중복 초기화
              } else if (count == maxFreq) {
                  isDuplicate = true;  // 최빈값이 여러 개
              }
          }

          // 3. 최빈값 반환
          return isDuplicate ? -1 : maxValue;
      }
  }

  ```
